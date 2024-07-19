/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab_1_programacion_2;

public class EmailAccount{
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
    public void printInbox(){
        System.out.println("Dirección de email: " + direccionEmail);
        System.out.println("Nombre de usuario: " + nombreUsuario);
        int totalEmails=0;
        int emailsSinLeer=0;
        for(int index=0;index<inbox.length;index++){
            if(inbox[index]!=null){
                totalEmails++;
                if(!inbox[index].isLeido()){
                    emailsSinLeer++;
                }
                System.out.println((index + 1)+" - "+inbox[index].getRemitente()+" - "+inbox[index].getAsunto()+" - "+(inbox[index].isLeido() ? "LEIDO" : "SIN LEER"));
            }
        }
        System.out.println("Correos sin leer: "+emailsSinLeer);
        System.out.println("Total de correos recibidos: "+totalEmails);
    }
    public void leerEmail(int pos){
        if (pos<1 || pos>inbox.length || inbox[pos-1]==null) {
            System.out.println("Correo No Existe");
        }else{
            inbox[pos-1].print();
            inbox[pos-1].marcarComoLeido();
        }
    }
    public void borrarLeidos(){
        for(int index = 0;index< inbox.length;index++){
            if(inbox[index]!=null && inbox[index].isLeido()){
                inbox[index]=null;
            }
        }
    }
}