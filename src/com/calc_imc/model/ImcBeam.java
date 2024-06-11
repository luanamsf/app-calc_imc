package com.calc_imc.model;

import java.text.DecimalFormat;

public class ImcBeam {
    private String nome;
    private String idade;
    private float peso;
    private float altura;

    public ImcBeam() {}

    public ImcBeam(String peso, String altura) {
        setPeso(peso);
        setAltura(altura);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public void setPeso(String peso) {
        try {
            this.peso = Float.parseFloat(peso);
        } catch (NumberFormatException e) {
            this.peso = 0;
        }
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public void setAltura(String altura) {
        try {
            this.altura = Float.parseFloat(altura);
        } catch (NumberFormatException e) {
            this.altura = 0;
        }
    }


    public double calcularIMC() {
        return peso / (altura * altura);
    }
    
    
    public String getResult() {
        double imc = calcularIMC();
        DecimalFormat df = new DecimalFormat("##.##");
        String imcFormatted = df.format(imc);
        String color;
        String resultado;
        
        if (Double.isNaN(imc) || Double.isInfinite(imc)) {
            resultado = "Valor inválido";
            color = "red";
        } else if (imc <= 18.5) {
            resultado = "Abaixo do peso";
            color = "blue"; 
        } else if (imc < 25) {
            resultado = "Peso normal";
            color = "green"; 
        } else if (imc < 30) {
            resultado = "Sobrepeso";
            color = "orange"; 
        } else if (imc < 35) {
            resultado = "Obesidade grau I";
            color = "red"; 
        } else if (imc <= 40) {
            resultado = "Obesidade grau II";
            color = "red"; 
        } else {
            resultado = "Obesidade grau III";
            color = "red";
        }
        
        return String.format("<html><div style='font-family: Tahoma;text-align:center;font-size: 17pt; font-weight: bold;'>IMC: %s <br><span style='color:%s;'>%s</span></div></html>", imcFormatted, color, resultado);

    }
    
    @Override
    public String toString() {
        return String.format("Nome: %s, Idade: %d, Peso: %.2f, Altura: %.2f, IMC: %.2f", nome, idade, peso, altura, calcularIMC());
    }

	public double getImc() {
		// TODO Auto-generated method stub
		return 0;
	}
}