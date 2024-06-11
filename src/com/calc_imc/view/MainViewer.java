package com.calc_imc.view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextPane;


import com.calc_imc.control.ImcController;
import java.awt.Toolkit;
import javax.swing.border.TitledBorder;

public class MainViewer {

    private JFrame appFrame;
    private JTextField nomeText;
    private JTextField idadeText;
    private JTextField pesoText;
    private JTextField alturaText;
    private JTextPane resultadoPane;

	/**
	 * Launch the application.
	 */
    public static void main(String[] args) {
    	
        SplashScreen splash = new SplashScreen(5000); 
        splash.showSplash();    	
    	
        EventQueue.invokeLater(() -> {
            try {
                MainViewer window = new MainViewer();
                window.appFrame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

	/**
	 * Create the application.
	 */
    public MainViewer() {
        initialize();
    }

	/**
	 * Initialize the contents of the frame.
	 */
    private void initialize() {
        appFrame = new JFrame();
        appFrame.getContentPane().setBackground(new Color(153, 241, 251));
        appFrame.setTitle("Calculadora de IMC");
        appFrame.setBounds(100, 100, 413, 549);
        appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        appFrame.getContentPane().setLayout(null);
        
        java.net.URL iconURL = getClass().getResource("/icon.png");
        if (iconURL != null) {
            appFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(iconURL));
        } else {
            System.err.println("Icon not found");
        }

        JLabel lblTitle = new JLabel("Calculadora de IMC");
        lblTitle.setBackground(new Color(255, 255, 255));
        lblTitle.setFont(new Font("Nirmala UI", Font.BOLD, 25));
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setBounds(42, 21, 300, 30);
        appFrame.getContentPane().add(lblTitle);

        JLabel lblNome = new JLabel("Nome*");
        lblNome.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNome.setBounds(22, 75, 46, 30);
        appFrame.getContentPane().add(lblNome);

        nomeText = new JTextField();
        nomeText.setHorizontalAlignment(SwingConstants.CENTER);
        nomeText.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        nomeText.setToolTipText("Primeiro nome");
        nomeText.setFont(new Font("Tahoma", Font.PLAIN, 14));
        nomeText.setBounds(69, 70, 292, 40);
        appFrame.getContentPane().add(nomeText);
        nomeText.setColumns(10);

        JLabel lblIdade = new JLabel("Idade");
        lblIdade.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblIdade.setBounds(240, 138, 46, 30);
        appFrame.getContentPane().add(lblIdade);

        idadeText = new JTextField();
        idadeText.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        idadeText.setHorizontalAlignment(SwingConstants.CENTER);
        idadeText.setFont(new Font("Tahoma", Font.PLAIN, 14));
        idadeText.setBounds(291, 133, 70, 40);
        appFrame.getContentPane().add(idadeText);
        idadeText.setColumns(10);

        JLabel lblPeso = new JLabel("Peso (kg)*");
        lblPeso.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblPeso.setBounds(22, 133, 70, 30);
        appFrame.getContentPane().add(lblPeso);

        pesoText = new JTextField();
        pesoText.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        pesoText.setToolTipText("Formato 00.0");
        pesoText.setHorizontalAlignment(SwingConstants.CENTER);
        pesoText.setFont(new Font("Tahoma", Font.PLAIN, 14));
        pesoText.setBounds(102, 133, 112, 40);
        appFrame.getContentPane().add(pesoText);
        pesoText.setColumns(10);

        JLabel lblAltura = new JLabel("Altura (m)*");
        lblAltura.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblAltura.setBounds(22, 196, 76, 30);
        appFrame.getContentPane().add(lblAltura);

        alturaText = new JTextField();
        alturaText.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        alturaText.setToolTipText("Formato 0.00");
        alturaText.setHorizontalAlignment(SwingConstants.CENTER);
        alturaText.setFont(new Font("Tahoma", Font.PLAIN, 14));
        alturaText.setBounds(102, 191, 112, 40);
        appFrame.getContentPane().add(alturaText);
        alturaText.setColumns(10);

        JButton calcularButton = new JButton("Calcular");
        calcularButton.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        calcularButton.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 16));
        calcularButton.setBounds(92, 257, 200, 50);
        calcularButton.addActionListener(new ImcController(this));
        appFrame.getContentPane().add(calcularButton);

        resultadoPane = new JTextPane();
        resultadoPane.setFont(new Font("Tahoma", Font.BOLD, 17));
        resultadoPane.setBackground(new Color(153, 241, 251));
        resultadoPane.setBounds(32, 335, 320, 61);
        resultadoPane.setContentType("text/html");
        resultadoPane.setEditable(false);
        appFrame.getContentPane().add(resultadoPane);
        
        JLabel lblFooter = new JLabel("2024 © By Luana Figueiredo");
        lblFooter.setFont(new Font("Tahoma", Font.PLAIN, 10));
        lblFooter.setHorizontalAlignment(SwingConstants.CENTER);
        lblFooter.setForeground(new Color(85, 85, 85));
        lblFooter.setBounds(92, 416, 200, 14);
        appFrame.getContentPane().add(lblFooter);
        
        int width = 400;
        int height = 480;
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screen.width - width) / 2;
        int y = (screen.height - height) / 2;
        appFrame.setBounds(x, y, width, height);
        
        appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        appFrame.getContentPane().setLayout(null);
    }

    public JTextField getNomeText() {
        return nomeText;
    }

    public JTextField getIdadeText() {
        return idadeText;
    }

    public JTextField getPesoText() {
        return pesoText;
    }

    public JTextField getAlturaText() {
        return alturaText;
    }

    public JTextPane getResultadoPane() {
        return resultadoPane;
    }

	public Component getAppFrame() {
		// TODO Auto-generated method stub
		return null;
	}
	
}