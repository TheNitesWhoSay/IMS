package com.revature.email;

import java.time.LocalDateTime;
import java.util.Properties;
import java.util.Set;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.revature.ims_backend.entities.Stock;
import com.revature.logging.Log;
import com.revature.persist.DataLayer;

public class Notifications {
	
	private DataLayer dataLayer;
	private static LocalDateTime lastNotification;
	
	public Notifications(DataLayer dataLayer) {
		this.dataLayer = dataLayer;
	}
	
	public void runCheck() {
		Log.info("Running a check!");
		if ( lastNotification == null ||
			 lastNotification.isBefore(LocalDateTime.now().minusMinutes(30)) )
		{
			boolean shortOnStuff = false;
			String message = "You are short of the following items: \n\n";
			Set<Stock> inventoryLevels = dataLayer.getInventoryLevels();
			for ( Stock stock : inventoryLevels ) {
				if ( stock != null && stock.getProduct() != null &&
					 stock.getNumInStock() < stock.getProduct().getReorderQuantity() ) {
					
					int missing = stock.getProduct().getReorderQuantity() - stock.getNumInStock();
					message += stock.getNumInStock() + "/"
							+ stock.getProduct().getReorderQuantity() + " "
							+ stock.getProduct().getName() + "\n";
					shortOnStuff = true;
				}
			}
			
			if ( shortOnStuff )
				sendEmail(message);
		}
	}
	
	public void sendEmail(String textToSend) {
		Log.info("triyng to send an email!");
		String to = "forsbergjj@gmail.com";
		String from = "IMS@revature.com";
		String host = "localhost";
		Properties properties = System.getProperties();
		properties.setProperty("mail.smtp.host", host);
		Session session = Session.getDefaultInstance(properties);
		Message message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("You're running low on supplies!");
			message.setText(textToSend);
			Transport.send(message);
			Log.info("Sent an email!");
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
	}
}
