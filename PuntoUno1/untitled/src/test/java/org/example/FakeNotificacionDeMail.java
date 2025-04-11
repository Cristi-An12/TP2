package org.example;

public class FakeNotificacionDeMail implements MailService{
    private String mailDestinatario;
    private String NombreParticipante;
    private String NombreConcurso;
    @Override
    public void enviarEmailInscripcion (String mailDestinatario, String NombreParticipante, String NombreConcurso) {
        this.mailDestinatario=mailDestinatario;
        this.NombreParticipante=NombreParticipante;
        this.NombreConcurso=NombreConcurso;
    }
    public boolean startsWith (String start){
        return start.startsWith (mailDestinatario);
    }
}
