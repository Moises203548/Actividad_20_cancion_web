package com.cancionweb.util;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.util.Properties;

public class EnviarCorreo {

    private static final String CORREO_REMITENTE = "webcancionrecuperarcontrasena@gmail.com";
    private static final String CLAVE_APP = "mkeafdowchocntma";

    public static boolean enviarCorreoRecuperacion(String destinatario, String enlaceRecuperacion) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(CORREO_REMITENTE, CLAVE_APP);
            }
        });

        try {
            Message mensaje = new MimeMessage(session);
            mensaje.setFrom(new InternetAddress(CORREO_REMITENTE));
            mensaje.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
            mensaje.setSubject("Recuperación de clave - Cancion Web");
            mensaje.setContent(
                    "<h3>Recuperación de clave</h3>" +
                            "<p>Hiciste una solicitud para recuperar tu clave.</p>" +
                            "<p>Haz clic en el siguiente enlace para establecer una nueva clave:</p>" +
                            "<a href='" + enlaceRecuperacion + "'>" + enlaceRecuperacion + "</a>" +
                            "<p>Este enlace expira en 30 minutos.</p>" +
                            "<p>Si no solicitaste esto, ignora este correo.</p>",
                    "text/html; charset=UTF-8"
            );

            Transport.send(mensaje);
            return true;

        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
    }
}