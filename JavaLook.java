/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab1p2;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JavaLook extends JFrame {

    private static EmailAccount[] cuentas = new EmailAccount[50];
    static EmailAccount accountActual = null;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            inicializarCuentas();
            new JavaLook().setVisible(true);
        });
    }

    public JavaLook() {
        setTitle("JavaLook - Sistema de Email");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        mostrarMenuInicio();
    }

    private void mostrarMenuInicio() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));

        JButton loginButton = new JButton("LOGIN");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });

        JButton crearAccountButton = new JButton("CREAR ACCOUNT");
        crearAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crearCuenta();
            }
        });

        panel.add(loginButton);
        panel.add(crearAccountButton);

        setContentPane(panel);
    }

    private void mostrarMenuPrincipal() {
        new Menu_Principal().setVisible(true);
        dispose();
    }

    private void login() {
        String email = JOptionPane.showInputDialog(this, "Ingrese su dirección de email:");
        if (email == null) {
            return;
        }

        String password = JOptionPane.showInputDialog(this, "Ingrese su password:");
        if (password == null) {
            return;
        }

        EmailAccount cuenta = buscarCuenta(email, password);
        if (cuenta != null) {
            accountActual = cuenta;
            mostrarMenuPrincipal();
        } else if (buscarCuenta(email) != null) {
            JOptionPane.showMessageDialog(this, "Password incorrecto.");
        } else {
            JOptionPane.showMessageDialog(this, "Email no existe.");
        }
    }

    private void crearCuenta() {
        if (buscarCuentaLibre() != -1) {
            String email = JOptionPane.showInputDialog(this, "Ingrese la dirección de email deseada:");
            if (email == null) {
                return; 
            }

            if (buscarCuenta(email) == null) {
                String nombreUsuario = JOptionPane.showInputDialog(this, "Ingrese el nombre del usuario:");
                if (nombreUsuario == null) {
                    return; 
                }

                String password = JOptionPane.showInputDialog(this, "Ingrese el password:");
                if (password == null) {
                    return; 
                }

                int indiceLibre = buscarCuentaLibre();
                cuentas[indiceLibre] = new EmailAccount(email, password, nombreUsuario);
                accountActual = cuentas[indiceLibre];
                JOptionPane.showMessageDialog(this, "Cuenta creada exitosamente. Inicie sesión.");
                mostrarMenuInicio(); 
            } else {
                JOptionPane.showMessageDialog(this, "La dirección de email ya existe.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "No hay espacio para más cuentas.");
        }
    }

    private static void inicializarCuentas() {
        for (int i = 0; i < cuentas.length; i++) {
            cuentas[i] = null;
        }
    }

    public static EmailAccount buscarCuenta(String email) {
        for (EmailAccount cuenta : cuentas) {
            if (cuenta != null && cuenta.getDireccionEmail().equals(email)) {
                return cuenta;
            }
        }
        return null;
    }

    public static EmailAccount buscarCuenta(String email, String password) {
        for (EmailAccount cuenta : cuentas) {
            if (cuenta != null && cuenta.getDireccionEmail().equals(email) && cuenta.getPassword().equals(password)) {
                return cuenta;
            }
        }
        return null;
    }

    private static int buscarCuentaLibre() {
        for (int i = 0; i < cuentas.length; i++) {
            if (cuentas[i] == null) {
                return i;
            }
        }
        return -1;
    }
}