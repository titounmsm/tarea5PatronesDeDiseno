package ayudadoc.helpers.mail;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import ayudadoc.entities.MailEntity;

import java.util.Properties;

public class SMTPMailSender {
    private static SMTPMailSender instance;
    private final String host;
    private final String port;
    private final String username;
    private final String password;

    private SMTPMailSender(String host, String port, String username, String password) {
        this.host = host;
        this.port = port;
        this.username = username;
        this.password = password;
    }

    public static synchronized SMTPMailSender getInstance(String host, String port, String username, String password) {
        if (instance == null) {
            instance = new SMTPMailSender(host, port, username, password);
        }
        return instance;
    }

    public void sendMail(MailEntity mail) throws MessagingException {
        // Configuramos las propiedades de la sesión de correo
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);

        // Creamos una instancia de la sesión de correo
        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        // Creamos el mensaje de correo electrónico
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(mail.getFrom()));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(mail.getTo()));
        message.setSubject(mail.getSubject());
        message.setText(mail.getBody());

        // Enviamos el mensaje de correo electrónico
        Transport.send(message);
    }
}
