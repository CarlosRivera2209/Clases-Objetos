/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab_1_programacion_2;

public class EmailAccount {
    private String email;
    private String password;
    private String nombre;
    private Email[] inbox;

    public EmailAccount(String email, String password, String nombre) {
        this.email=email;
        this.password=password;
        this.nombre=nombre;
        this.inbox=new Email[50];
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean recibirEmail(Email em) {
        for(int index=0;index< inbox.length;index++) {
            if (inbox[index] == null) {
                inbox[index] = em;
                return true;
            }
        }
        return false;
    }

    public void printInbox() {
        System.out.println("Cuenta: " + email + " - " + nombre);
        int correossinleer=0;
        int totalEmails=0;
        for (int index=0;index<inbox.length;index++) {
            if (inbox[index] != null) {
                totalEmails++;
                String estado = inbox[index].isLeido() ? "LEIDO" : "SIN LEER";
                if (!inbox[index].isLeido()) {
                    correossinleer++;
                }
                System.out.println((index+1) + " - " + inbox[index].getRemitente() + " - " + inbox[index].getAsunto() + " - " + estado);
            }
        }
        System.out.println("Correos sin leer: " + correossinleer);
        System.out.println("Total de correos recibidos: " + totalEmails);
    }

    public void leerEmail(int pos) {
        if (pos < 1 || pos > inbox.length || inbox[pos - 1] == null) {
            System.out.println("Correo No Existente");
        } else {
            Email email = inbox[pos - 1];
            email.print();
            email.marcarComoLeido();
        }
    }

    public void borrarLeidos() {
        for (int index=0;index<inbox.length;index++) {
            if (inbox[index] != null && inbox[index].isLeido()) {
                inbox[index] = null;
            }
        }
    }
}
