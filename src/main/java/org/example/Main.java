package org.example;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Running...");

        JFrame frame = new JFrame();
        frame.setContentPane(new Seleccion().MainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setVisible(true);
    }
}