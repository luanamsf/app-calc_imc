package com.calc_imc.view;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class SplashScreen extends JWindow {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int duration;

    public SplashScreen(int duration) {
        this.duration = duration;
    }

    public void showSplash() {
        JPanel content = (JPanel) getContentPane();
        content.setBackground(Color.white);

        int width = 400;
        int height = 300;
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screen.width - width) / 2;
        int y = (screen.height - height) / 2;
        setBounds(x, y, width, height);

        URL imgURL = getClass().getResource("/splash.png");
        if (imgURL != null) {
            JLabel label = new JLabel(new ImageIcon(imgURL));
            content.add(label, BorderLayout.CENTER);
        } else {
            System.err.println("Couldn't find file: splash.png");
        }

        JLabel copyrt = new JLabel("2024 © By Luana Figueiredo", JLabel.CENTER);
        copyrt.setFont(new Font("Tahoma", Font.PLAIN, 12));
        content.add(copyrt, BorderLayout.SOUTH);

        setVisible(true);

        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        setVisible(false);
    }

    public static void main(String[] args) {
        SplashScreen splash = new SplashScreen(3000);
        splash.showSplash();

        MainViewer mainViewer = new MainViewer();
        mainViewer.getAppFrame().setVisible(true);
    }
}