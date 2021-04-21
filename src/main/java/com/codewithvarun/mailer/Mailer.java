package com.codewithvarun.mailer;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Map;
import java.util.Properties;

public class Mailer {
    private static final String HOST = "smtp.gmail.com";
    private static final Map<String,String> CONFIG = Map.of(
            "mail.smtp.host", HOST,
            "mail.smtp.port", "587",
            "mail.smtp.auth", "true",
            "mail.smtp.starttls.enable", "true"
    );
    public boolean send(MailPacket mailPacket) {
        String username = "<GOOGLE_USERNAME>";
        String password = "<GOOGLE_PASSWORD>";


        var props = new Properties();
        CONFIG.forEach(props::setProperty);

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(mailPacket.getFrom()));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(mailPacket.getTo())
            );
            message.setSubject(mailPacket.getSubject());
            message.setText(mailPacket.getBody());

            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }
}
