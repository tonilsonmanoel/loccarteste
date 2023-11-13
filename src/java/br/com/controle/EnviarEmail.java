/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controle;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Tonilson
 */
public class EnviarEmail {
      public boolean enviarEmail(String email, String codigoVerificador){
        boolean teste= false;
        
        String meuEmail = "tonilsonmanoel@gmail.com";
        String senhaEmail = "lbjpanbspgcvdnea";
        String enviaEmail = email;
        
        try {
           Properties pr = new Properties();
           pr.setProperty("mail.smtp.host", "smtp.gmail.com");
           pr.setProperty("mail.smtp.port", "587");
           pr.setProperty("mail.smtp.auth", "true");
           pr.setProperty("mail.smtp.starttls.enable","true");
           pr.put("mail.smtp.socketFactory.port", "587");
           pr.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            
           // get Session
           Session session = Session.getInstance(pr, new Authenticator() {
               @Override
               protected PasswordAuthentication getPasswordAuthentication(){
                    return new PasswordAuthentication(meuEmail, senhaEmail);
               }
           });
           
           Message mess = new MimeMessage(session);
           mess.setRecipient(Message.RecipientType.TO, new InternetAddress(enviaEmail));
           mess.setSubject("Recuperação de Senha LocCar");
           mess.setText("Recuperação de senha do Loccar  \nEsse é seu codigo verificador: "+codigoVerificador + "\n \n Digite o codigo verificador na pagina recuperação senha. ");
            Transport.send(mess);
            teste = true;
        } catch (Exception e) {
        }
        return teste;
    }
}
