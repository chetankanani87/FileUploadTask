package lib;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

public class EmailWithAttachmentUtility {

	public static void SendEmail(String sub, String msg, String path1, String description1, String path2, String description2)
			throws EmailException {
		// Create the attachment
		EmailAttachment attachment = new EmailAttachment();
		/* You can also use EmailAttachment to reference any valid URL for files that
		 * you do not have locally. When the message is sent, the file will be
		 * downloaded and attached to the message automatically.
		 * attachment.setURL(new URL("http://www.apache.org/images/asf_logo_wide.gif")); */
		attachment.setPath(path1);
		attachment.setDisposition(EmailAttachment.ATTACHMENT);
		attachment.setDescription(description1);
		attachment.setName("Chetan Kanani");

		// Create the email message
		MultiPartEmail email = new MultiPartEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("abc@gmail.com", "xyz"));
		email.setSSLOnConnect(true);
		email.addTo("abc@gmail.com", "xyz");
		email.setFrom("abc@gmail.com", "ck");
		email.setSubject(sub);
		email.setMsg(msg);

		// add the attachment
		email.attach(attachment);
		
		attachment = new EmailAttachment();
		attachment.setPath(path2);
		attachment.setDisposition(EmailAttachment.ATTACHMENT);
		attachment.setDescription(description2);
		attachment.setName("Chetan Kanani");
		email.attach(attachment);

		// send the email
		email.send();
		System.out.println("Email with attachment successfully sent...!!!");
	}
}
