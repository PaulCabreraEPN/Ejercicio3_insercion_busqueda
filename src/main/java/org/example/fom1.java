package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class fom1 {
    public JPanel MainPanel;
    public JTextField cedula;
    public JTextField nombre;
    public JTextField N1;
    public JButton registrarButton;
    public JButton cancelarButton;
    private JTextField N2;
    private JButton regresarButton;
    private JLabel estado;

    String url = "jdbc:mysql://localhost:3306/notas_estudiantes";
    String usuario = "root";
    String password = "123456";

    public fom1() {
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cedula.setText(null);
                nombre.setText(null);
                N1.setText(null);
                N2.setText(null);
            }
        });
        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                frame.setContentPane(new Seleccion().MainPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(400, 400);
                frame.setVisible(true);
            }
        });
        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try (Connection connection= DriverManager.getConnection(url,usuario,password)){
                    estado.setText("Cargando...");
                    String sql = "insert into estudiantes (cedula,nombre,b1,b2) values (?,?,?,?)";
                    PreparedStatement cadena = connection.prepareStatement( sql);
                    cadena.setString(1,cedula.getText());
                    cadena.setString(2,nombre.getText());
                    cadena.setDouble(3,Double.parseDouble(N1.getText()));
                    cadena.setDouble(4,Double.parseDouble(N2.getText()));

                    System.out.println("Exito");
                    estado.setText("Registro Exitoso");
                    cadena.executeUpdate();

                }catch (SQLException e1){
                    estado.setText("Campo erroneo");
                }

            }
        });
    }
}
