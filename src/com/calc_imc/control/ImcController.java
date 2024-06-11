package com.calc_imc.control;
import com.calc_imc.util.DatabaseHelper;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.calc_imc.model.ImcBeam;
import com.calc_imc.view.MainViewer;
import javax.swing.JOptionPane;

public class ImcController implements ActionListener {
    private MainViewer context;
    private ImcBeam imc;

    public ImcController(MainViewer context) {
        this.context = context;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String nome = context.getNomeText().getText();
            String idadeStr = context.getIdadeText().getText();
            String pesoStr = context.getPesoText().getText();
            String alturaStr = context.getAlturaText().getText();

            if (nome.isEmpty() || pesoStr.isEmpty() || alturaStr.isEmpty() || idadeStr.isEmpty()) {
                throw new IllegalArgumentException("Nome, idade, peso e altura devem ser preenchidos.");
            }
            
            pesoStr = pesoStr.replace(',', '.');
            alturaStr = alturaStr.replace(',', '.');

            double peso = Double.parseDouble(pesoStr);
            double altura = Double.parseDouble(alturaStr);
            int idade = Integer.parseInt(idadeStr);

            imc = new ImcBeam(pesoStr, alturaStr);
            context.getResultadoPane().setText(imc.getResult());

            DatabaseHelper.salvarResultado(nome, idade, peso, altura, imc.calcularIMC());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(context.getAppFrame(), "Por favor, insira valores numéricos válidos para peso (00.0) e altura (0.00).", "Erro de Formato", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(context.getAppFrame(), "Por favor, preencha todos os campos obrigatórios: nome, idade, peso e altura.", "Campo Vazio", JOptionPane.WARNING_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(context.getAppFrame(), "Ocorreu um erro: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}