/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.GoVoyage.entites;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

/**
 *
 * @author admin
 */
public class Mail {

    private static String USER_NAME;  // GMail user name (just the part before "@gmail.com")
    private static String PASSWORD; // GMail password
    private static String RECIPIENT;
    private static String ssubject;
    private static String bbody;

    public static String getUSER_NAME() {
        return USER_NAME;
    }

    public static void setUSER_NAME(String USER_NAME) {
        Mail.USER_NAME = USER_NAME;
    }

    public static String getPASSWORD() {
        return PASSWORD;
    }

    public static void setPASSWORD(String PASSWORD) {
        Mail.PASSWORD = PASSWORD;
    }

    public static String getRECIPIENT() {
        return RECIPIENT;
    }

    public static void setRECIPIENT(String RECIPIENT) {
        Mail.RECIPIENT = RECIPIENT;
    }

    public static String getSsubject() {
        return ssubject;
    }

    public static void setSsubject(String ssubject) {
        Mail.ssubject = ssubject;
    }

    public static String getBbody() {
        return bbody;
    }

    public static void setBbody(String bbody) {
        Mail.bbody = bbody;
    }

    public static void sendFromGMaill(String fromm, String pass, String too, String subject, String body) {

     String to = too;//change accordingly

      // Sender's email ID needs to be mentioned
      String from = fromm;//change accordingly
      final String username = fromm;//change accordingly
      final String password = pass;//change accordingly

      // Assuming you are sending email through relay.jangosmtp.net
      String host = "smtp.gmail.com";

      Properties props = new Properties();
      props.put("mail.smtp.auth", "true");
      props.put("mail.smtp.starttls.enable", "true");
      props.put("mail.smtp.host", host);
      props.put("mail.smtp.port", "587");

      // Get the Session object.
      Session session = Session.getInstance(props,
      new javax.mail.Authenticator() {
             @Override
             protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(username, password);
         }
      });

      try {
         // Create a default MimeMessage object.
         Message message = new MimeMessage(session);

         // Set From: header field of the header.
         message.setFrom(new InternetAddress(from));

         // Set To: header field of the header.
         message.setRecipients(Message.RecipientType.TO,
         InternetAddress.parse(to));

         // Set Subject: header field
         message.setSubject(subject);

         // Now set the actual message
         message.setText(body);

         // Send message
         Transport.send(message);

         System.out.println("Sent message successfully....");

      } catch (MessagingException e) {
            throw new RuntimeException(e);
      }
    
    }
}