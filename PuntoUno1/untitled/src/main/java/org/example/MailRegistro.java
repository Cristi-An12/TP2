package org.example;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.util.Properties;


public class MailRegistro implements MailService{
    private final String username;
    private final String password;
    private final String host;
    private final String port;

    public MailRegistro (String username, String password, String host, String port){
        this.username=username;
        this.password = password;
        this.host=host;
        this.port=port;
    }

    @Override
    public void enviarEmailInscripcion (String MailDestinatario, String NombreParticipante, String NombreConcurso) {
        Properties prop = new Properties();
        prop.put("mail.smtp.auth", true);
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", host);
        prop.put("mail.smtp.port", port);
        prop.put("mail.smtp.ssl.trust", host);

        Session session = Session.getInstance(prop, new Authenticator () {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("inscripciones@concursos.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(MailDestinatario));
            message.setSubject("Inscripción exitosa al concurso: " + NombreConcurso);

            String contenido = "Estimado/a " + NombreParticipante + ",\n\n"
                    + "Le confirmamos que su inscripción al concurso '" + NombreConcurso + "' ha sido registrada exitosamente.\n\n"
                    + "Saludos cordiales,\nEquipo de Concursos";

            message.setText(contenido);

            Transport.send(message);

            System.out.println("Email de inscripción enviado exitosamente a " + MailDestinatario);

        } catch (MessagingException e) {
            System.err.println("Error al enviar email: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
