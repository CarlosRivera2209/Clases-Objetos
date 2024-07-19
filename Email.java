package lab_1_programacion_2;

public class Email {

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
        System.out.println("DE: " + remitente);
        System.out.println("ASUNTO: " + asunto);
        System.out.println("CONTENIDO: " + contenido);
    }
}
