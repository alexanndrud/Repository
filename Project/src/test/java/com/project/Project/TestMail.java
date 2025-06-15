package com.project.Project;

import javax.mail.*;
import javax.mail.internet.*;

import java.util.Properties;

public class TestMail {
    public static void main(String[] args) {
        String host = "smtp.gmail.com";
        String from = "alexanndru100.gd@gmail.com";
        String password = "qxfc cwqx rkki kzds";  // Folosește parola de aplicație

        Properties properties = System.getProperties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress("lalvision@lalvision.ro"));
            message.setSubject("Test Email");
            message.setText("This is a test email.");

            Transport.send(message);
            System.out.println("Email sent successfully.");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
