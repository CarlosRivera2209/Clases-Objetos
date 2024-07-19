package lab_1_programacion_2;


import javax.swing.JFrame;
import javax.swing.JOptionPane;



public class Email extends JFrame {

    private String remitente;
    private String asunto;
    private String contenido;
    private boolean leido;

    public Email(String remitente, String asunto, String contenido) {
        this.remitente = remitente;
        this.asunto = asunto;
        this.contenido = contenido;
        this.leido = false;
    }

    public String getRemitente() {
        return remitente;
    }

    public String getAsunto() {
        return asunto;
    }

    public String getContenido() {
        return contenido;
    }

    public boolean isLeido() {
        return leido;
    }

    public void marcarComoLeido() {
        this.leido = true;
    }

    public void print() {
        JOptionPane.showMessageDialog(this, "DE: " + remitente + "\n" + "ASUNTO: "  + asunto + "\n "+ "CONTENIDO: " + contenido);
     
    }
}

