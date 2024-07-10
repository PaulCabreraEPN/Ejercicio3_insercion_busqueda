package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class fom2 {
    public JButton okBtn;
    public JTextField consultaTxt;
    public JLabel resultadoTxt;
    public JPanel MainPanel;
    private JLabel rest1;
    private JLabel rest2;
    private JLabel rest3;
    private JLabel rest4;

    String url= "jdbc:mysql://localhost:3306/Lista_estudiantes";
    String user="root";
    String password="123456";

    public fom2() {
        okBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                try (Connection connection= DriverManager.getConnection(url,user,password)){
                    System.out.println("Conectado a la base de datos");
                    String query = "select *, round(((b1+b2)/2),2) as promedio from estudiantes where nombre = '"+ consultaTxt.getText() +"'";
                    System.out.println(query);

                    Statement statement = connection.createStatement();
                    ResultSet resultSet=statement.executeQuery(query);

                    while (resultSet.next()){

                        rest1.setText("Nombre : "+ resultSet.getString("nombre"));
                        rest2.setText("Cedula : " + resultSet.getString("cedula"));
                        rest3.setText("Notas : b1 =" + resultSet.getString("b1")+" | b2 =" + resultSet.getString("b2"));
                        rest4.setText("Promedio :" + resultSet.getString("promedio"));
                    }

                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());

                }
            }
        });
    }
}
