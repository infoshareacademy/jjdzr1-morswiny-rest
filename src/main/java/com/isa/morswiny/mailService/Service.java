package com.isa.morswiny.mailService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Map;
import java.util.Properties;

public class Service {

    private static final Logger STDOUT = LoggerFactory.getLogger("CONSOLE_OUT");
    private static final String MORSWIN_MAIL = "morswiny.events@onet.pl";

    Properties prop = new Properties();

    public void loadProperties() {
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.ssl.enable", "true");
        prop.put("mail.smtp.starttls.enable", "false");
        prop.put("mail.smtp.host", "smtp.poczta.onet.pl");
        prop.put("mail.smtp.port", "465");
        prop.put("mail.smtp.ssl.trust", "smtp.poczta.onet.pl");
    }

    //e-mail is created only for the project, that given the password is not hidden
    Session session = Session.getInstance(prop, new Authenticator() {

        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(MORSWIN_MAIL, "infoShare1");
        }
    });

    public boolean send(Map<String, String> data){

        try {
            session.setDebug(true);
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(MORSWIN_MAIL));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(MORSWIN_MAIL));
            message.setSubject("Subject: " + data.get("subject") + " | From: " + data.get("email"));

            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent(data.get("message"), "text/html; charset=UTF-8");

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart);

            message.setContent(multipart, "UTF-8");
            Transport.send(message);

            return true;

        } catch (MessagingException e) {
            STDOUT.error(e.getMessage());
            return false;
        }
    }

}
