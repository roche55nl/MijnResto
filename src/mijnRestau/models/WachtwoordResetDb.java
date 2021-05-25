package mijnRestau.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Properties;
import java.util.Random;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

import mijnRestau.Database.DbKlant;

public class WachtwoordResetDb {
    
    private static int randomCode;
	public static void Send(String email)  {
  
    	try{
    		Random rand = new Random();    
    	randomCode = rand.nextInt();
    	String host = "smtp.gmail.com";
    	String user = "rachidelmisbahi7@gmail.com";
    	String pass = "Wadwad1974";
    	String to = email;
    	String subject = "Wachtwoord reset";
    	String message1 = "Uw nieuw wachtwoord is: " + randomCode;
    	boolean sessionDebug = false;
    	Properties pros = System.getProperties();
    	pros.put("mail.smtp.starttls.enable", "true");
    	pros.put("mail.smtp.host", host);
    	pros.put("mail.smtp.port", "587");
    	pros.put("mail.smtp.auth", "true");
    	pros.put("mail.smtp.starttls.required", "true");
  // 	java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
    	Session mailSession = Session.getInstance(pros, new javax.mail.Authenticator() {
    	    protected PasswordAuthentication getPasswordAuthentication() {
    	        return new PasswordAuthentication(user, pass);
    	    }
    	});
    	
    	mailSession.setDebug(sessionDebug);    	
    	Message msg = new MimeMessage(mailSession);
    	msg.setFrom(new InternetAddress());
    	Address address = (new InternetAddress(to));
    	msg.setRecipient(Message.RecipientType.TO, address);
    	msg.setSubject(subject);
    	msg.setText(message1);
    	Transport transport = mailSession.getTransport("smtp");
    	System.out.println("Een ogenblikje ....");
    	transport.connect(host, user, pass);
    	Transport.send(msg);
    	System.out.println("Bericht gestuurd!");

     		Connection con=DbKlant.DBConnection();	
     		Integer i =randomCode; 
         PreparedStatement ps = con.prepareStatement("UPDATE userinfo SET password=? WHERE email = '"+email+"';");	            
         ps.setString(1,i.toString());
         ps.executeUpdate();
         System.out.println( i.toString());
     	transport.close();
    	JOptionPane.showMessageDialog(null,"Nieuw wachtwoord is naar "+  email +" gestuurd.");
    	
    	}catch(Exception ex) {
    		JOptionPane.showMessageDialog(null, ex);
    	}
	}	
}
