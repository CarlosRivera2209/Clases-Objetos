/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab1p2;


import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author Jorge Aguirre
 */
public class JavaLook {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("EMAIL");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Crear botones
        JButton LoginBtn = new JButton("Login");
        JButton CrearCuentaBtn = new JButton("Crear Cuenta");
        
        
        JPanel panel = new JPanel();
        panel.add(LoginBtn);
        panel.add(CrearCuentaBtn);
        
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
        
        //Accion al apretar Login
        LoginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }   
        });
        
        //Accion al apretar Crear Cuenta
        CrearCuentaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 
            }   
        });
        
        
    }
    
    
    //JOptionPane.showMessageDialog(frame, "BOTON FUNCIONA");
}
