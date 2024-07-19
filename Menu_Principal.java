package lab_1_programacion_2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu_Principal extends JFrame {
    public Menu_Principal() {
        setTitle("Menú Principal");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        mostrarMenu();
    }

    private void mostrarMenu() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));

        JButton verInboxButton = new JButton("VER MI INBOX");
        verInboxButton.addActionListener(e -> verInbox());

        JButton mandarCorreoButton = new JButton("MANDAR CORREO");
        mandarCorreoButton.addActionListener(e -> mandarCorreo());

        JButton leerCorreoButton = new JButton("LEER UN CORREO");
        leerCorreoButton.addActionListener(e -> leerCorreo());

        JButton limpiarInboxButton = new JButton("LIMPIAR MI INBOX");
        limpiarInboxButton.addActionListener(e -> limpiarInbox());

        JButton cerrarSesionButton = new JButton("CERRAR SESION");
        cerrarSesionButton.addActionListener(e -> cerrarSesion());

        panel.add(verInboxButton);
        panel.add(mandarCorreoButton);
        panel.add(leerCorreoButton);
        panel.add(limpiarInboxButton);
        panel.add(cerrarSesionButton);

        setContentPane(panel);
    }

    private void verInbox() {
        if (JavaLook.accountActual != null) {
            JavaLook.accountActual.printInbox();
        } else {
            JOptionPane.showMessageDialog(this, "No hay una cuenta iniciada.");
        }
    }

    private void mandarCorreo() {
        if (JavaLook.accountActual != null) {
            String destinatario = JOptionPane.showInputDialog(this, "Ingrese la dirección del destinatario:");
            if (destinatario == null) return; // Cancelado por el usuario

            String asunto = JOptionPane.showInputDialog(this, "Ingrese el asunto:");
            if (asunto == null) return; // Cancelado por el usuario

            String contenido = JOptionPane.showInputDialog(this, "Ingrese el contenido:");
            if (contenido == null) return; // Cancelado por el usuario

            EmailAccount cuentaDestinatario = JavaLook.buscarCuenta(destinatario);

            if (cuentaDestinatario != null) {
                Email nuevoEmail = new Email(JavaLook.accountActual.getDireccionEmail(), asunto, contenido);
                boolean enviado = cuentaDestinatario.recibirEmail(nuevoEmail);
                JOptionPane.showMessageDialog(this, enviado ? "Correo enviado exitosamente." : "El inbox del destinatario está lleno.");
            } else {
                JOptionPane.showMessageDialog(this, "La dirección de email no existe.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "No hay una cuenta iniciada.");
        }
    }

    private void leerCorreo() {
        if (JavaLook.accountActual != null) {
            String posicionStr = JOptionPane.showInputDialog(this, "Ingrese la posición del correo:");
            if (posicionStr == null) return; // Cancelado por el usuario

            try {
                int posicion = Integer.parseInt(posicionStr);
                JavaLook.accountActual.leerEmail(posicion);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Posición inválida. Debe ingresar un número.");
            } catch (ArrayIndexOutOfBoundsException ex) {
                JOptionPane.showMessageDialog(this, "Posición fuera de rango.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "No hay una cuenta iniciada.");
        }
    }

    private void limpiarInbox() {
        if (JavaLook.accountActual != null) {
            JavaLook.accountActual.borrarLeidos();
            JOptionPane.showMessageDialog(this, "Inbox limpiado.");
        } else {
            JOptionPane.showMessageDialog(this, "No hay una cuenta iniciada.");
        }
    }

    private void cerrarSesion() {
        JavaLook.accountActual = null;
        new JavaLook().setVisible(true);
        dispose();
    }
}
