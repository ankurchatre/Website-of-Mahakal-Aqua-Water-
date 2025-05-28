package Website;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class SendMail  {
	
	    
	        
	   public static void sendEmail(String message, String subject, String from, String to) {
	        String host = "smtp.gmail.com";
	        // Get system properties
	        Properties properties = System.getProperties();
	        properties.put("mail.smtp.host", host);
	        properties.put("mail.smtp.port", "465");
	        properties.put("mail.smtp.ssl.enable", "true");
	        properties.put("mail.smtp.auth", "true");
	        // Enable TLS 1.2
	        properties.put("mail.smtp.ssl.protocols", "TLSv1.2");

	        Session session = Session.getInstance(properties, new Authenticator() {
	            @Override
	            protected PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication("ankurchatre1@gmail.com", "abcd efgh ijkln opqrs"); // Use the generated app password
	            }
	        });

	        session.setDebug(true);

	        // Step 2: Compose the message
	        MimeMessage m = new MimeMessage(session);
	        
	        try {
	            // From email
	            m.setFrom(new InternetAddress(from)); // Corrected this line
	            // Adding recipient to message
	            m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
	            // Adding subject to message
	            m.setSubject(subject);
	            // Adding text to message
	            m.setText(message);
	            // Send message using transport class
	            Transport.send(m);
	            
	            System.out.println("Sent successfully");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}

	

