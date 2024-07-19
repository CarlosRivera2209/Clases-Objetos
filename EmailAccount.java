/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab_1_programacion_2;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Jorge Aguirre
 */
public class EmailAccount extends JFrame{
    private String direccionEmail;
    private String password;
    private String nombreUsuario;
    private Email[] inbox;

    public EmailAccount(String direccionEmail, String password, String nombreUsuario){
        this.direccionEmail=direccionEmail;
        this.password=password;
        this.nombreUsuario=nombreUsuario;
        this.inbox=new Email[50];
    }

    public String getDireccionEmail(){
        return direccionEmail;
    }

    public String getPassword(){
        return password;
    }

    public String getNombreUsuario(){
        return nombreUsuario;
    }

    public boolean recibirEmail(Email em){
        for(int index=0;index<inbox.length;index++){
            if(inbox[index]==null){
                inbox[index]=em;
                return true;
            }
        }
        return false;
    }
    public void printInbox() {
        JOptionPane.showMessageDialog(this, "Dirección de email: "+direccionEmail+"\n" +"Nombre de usuario: "+nombreUsuario);
        int totalEmails=0;
        int emailsSinLeer=0;
        for(int index=0;index<inbox.length;index++){
            if(inbox[index] != null){
                totalEmails++;
                if (!inbox[index].isLeido()){
                    emailsSinLeer++;
                }
                
                JOptionPane.showMessageDialog(this, (index+1) + " - " + inbox[index].getRemitente() + " - " + inbox[index].getAsunto() + " - " + (inbox[index].isLeido() ? "LEIDO" : "SIN LEER"));
            }
        }
        JOptionPane.showMessageDialog(this,"Correos sin leer: " +emailsSinLeer);
        JOptionPane.showMessageDialog(this,"Total de correos recibidos: " +totalEmails);
    }
    public void leerEmail(int pos){
        if(pos<1 || pos>inbox.length || inbox[pos-1]==null){
            JOptionPane.showMessageDialog(this,"correo no existe");
        }else{
            inbox[pos-1].print();
            inbox[pos-1].marcarComoLeido();
        }
    }
    public void borrarLeidos(){
        for(int index=0;index<inbox.length;index++){
            if(inbox[index]!=null && inbox[index].isLeido()){
                inbox[index]=null;
            }
        }
    }
}