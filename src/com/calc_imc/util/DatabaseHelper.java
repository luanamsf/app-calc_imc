package com.calc_imc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

public class DatabaseHelper {

    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "123"; 

    public static Connection getConnection() throws SQLException {
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);

        // Criar tabela imc_records, caso ela não exista.
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT EXISTS (SELECT FROM information_schema.tables WHERE table_name = 'imc_records')");
            if (!rs.next() || !rs.getBoolean(1)) {
                String createTableSQL = "CREATE TABLE imc_records (" +
                        "id SERIAL PRIMARY KEY," +
                        "nome VARCHAR(100) NOT NULL," +
                        "idade INT NOT NULL," +
                        "peso DOUBLE PRECISION NOT NULL," +
                        "altura DOUBLE PRECISION NOT NULL," +
                        "imc DOUBLE PRECISION NOT NULL," +
                        "data TIMESTAMP DEFAULT CURRENT_TIMESTAMP)";
                stmt.executeUpdate(createTableSQL);
            }
        }

        return conn;
    }

    public static void salvarResultado(String nome, int idade, double peso, double altura, double imc) {
        String sql = "INSERT INTO imc_records (nome, idade, peso, altura, imc) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nome);
            pstmt.setInt(2, idade);
            pstmt.setDouble(3, peso);
            pstmt.setDouble(4, altura);
            pstmt.setDouble(5, imc);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static List<String> buscarResultados() {
        List<String> resultados = new ArrayList<>();
        String sql = "SELECT id, nome, idade, peso, altura, imc FROM tabela_imc ORDER BY id";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                int idade = rs.getInt("idade");
                double peso = rs.getDouble("peso");
                double altura = rs.getDouble("altura");
                double imc = rs.getDouble("imc");

                String resultado = String.format("ID: %d, Nome: %s, Idade: %d, Peso: %.2f, Altura: %.2f, IMC: %.2f",
                        id, nome, idade, peso, altura, imc);
                resultados.add(resultado);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultados;
    }
}
