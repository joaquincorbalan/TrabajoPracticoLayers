package Modelo;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

public class Notificacion implements Notification {
    private String mensaje;
    private List<Empleado> empleados;
    private final String HOST;
    private final String PORT;
    private final String USERNAME;
    private final String PASS;
    private final String FROM;


    public Notificacion(String a61df6ee928375, String host, String port, String password, String from,
                        String mensaje, List<Empleado> empleados) {
        USERNAME = a61df6ee928375;
        HOST = host;
        PORT = port;
        PASS = password;
        FROM = from;
        this.mensaje = mensaje;
        this.empleados = empleados;
    }

    @Override
    public Optional<String> enviarNotificacion() {
        if (!empleados.isEmpty()) {
            for (Empleado empleado : empleados) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                String fecha = LocalDate.now().format(formatter);
                //Configuracion SMTP
                Properties props = new Properties();
                props.put("mail.smtp.auth", "true");
                props.put("mail.smtp.starttls.enable", "true");
                props.put("mail.smtp.host", this.HOST);
                props.put("mail.smtp.port", this.PORT);
                //Creacion del mail
                Session session = Session.getInstance(props,
                        new Authenticator() {
                            @Override
                            protected PasswordAuthentication getPasswordAuthentication() {
                                return new PasswordAuthentication(USERNAME, PASS);
                            }
                        });
                try {
                    Message message = new MimeMessage(session);
                    message.setFrom(new InternetAddress(FROM));
                    message.setRecipient(Message.RecipientType.TO, new InternetAddress(empleado.getEmail()));
                    message.setSubject("Felicitacion de Cumpleaños ");
                    message.setText(mensaje + " " + empleado.getNombreCompleto());
                    Transport.send(message);
                    System.out.println("MailEnviado");

                } catch (MessagingException e) {
                    throw new RuntimeException(e);
                }


            }
            return Optional.of("Mensaje enviado Exitosamente");
        }
        return Optional.of("---");
    }
}







