package org.example;

import java.time.LocalDate;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main (String[] args) {
        LocalDate fechaInicio = LocalDate.now ();
        LocalDate fechaLimite = LocalDate.now ().plusDays (10);
        LocalDate PrimerosDias = LocalDate.now ();

        String username = "Cristian";
        String password = "1234";
        String host = "YOUR_HOST_ADDRESS";
        String port = "2525";


        TXTRegistrarInscripto registro = new TXTRegistrarInscripto("Archivo.txt");
        MailService mailService = new MailRegistro(username, password, host, port);

        Concurso concurso = new Concurso ("1234", fechaInicio, fechaLimite, "CONCURSO DE ROCK", registro, mailService);

        Participante participante1 = new Participante ("Chester", "Bennington", LocalDate.now ().plusDays (1), "ChesterBennington@gmail.com");
        Participante participante2 = new Participante ("Ricardo", "Iorio", LocalDate.now ().plusDays (3),"ChesterBennington@gmail.com");
        Participante participante3 = new Participante ("John", "Lennon", LocalDate.now ().plusDays (2), "JohnLennon@gmail.com");

        concurso.agregarParticipante (participante1.fechaInscripcionParticipante(), participante1);
        concurso.agregarParticipante (participante2.fechaInscripcionParticipante(), participante2);
        concurso.agregarParticipante (participante3.fechaInscripcionParticipante(), participante3);

        participante1.puntosGanados ();
        participante2.puntosGanados ();
        participante3.puntosGanados ();


    }
}