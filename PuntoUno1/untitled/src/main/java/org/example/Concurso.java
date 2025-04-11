package org.example;

import java.time.LocalDate;
import java.util.List;

public class Concurso {
    private String nombreConcurso;
    private String id_concurso;
    private int cantParticipantes=0;
    private LocalDate fechInicio;
    private LocalDate fechLimite;
    private LocalDate primerosDias;
    private RegistrarInscriptos registrar;
    private MailService ServicioDeMail; //Servicio de Gmail inyectado

    public Concurso (String id_concurso, LocalDate fechInicio, LocalDate fechLimite,
                     String nombreConcurso, RegistrarInscriptos registrar, MailService ServicioDeMail) {
        this.id_concurso=id_concurso;
        this.fechInicio= fechInicio;
        this.fechLimite = fechLimite;
        this.nombreConcurso = nombreConcurso;
        this.registrar=registrar;
        this.ServicioDeMail = ServicioDeMail; //inyeccion de dependencia
    }

    public boolean agregarParticipante(LocalDate fechaInscripto, Participante P){
        primerosDias = fechInicio.plusDays (5);
        if (fechaInscripto.isAfter (fechInicio) && fechaInscripto.isBefore(fechLimite)) {
            if (fechaInscripto.isBefore(primerosDias)){
                P.agregarPuntos (10);
            }
            cantParticipantes++;
            P.asignarNumeroDeParticipante (cantParticipantes);

            //registrar la inscripcion
           registrar.registrarInscriptos (P.verNombre (), id_concurso, fechaInscripto);

           //enviar mail de comfirmacion
            ServicioDeMail.enviarEmailInscripcion (P.mailDeParticipante (), P.verNombre (), this.nombreConcurso);

            System.out.println("Participante inscripto con exito");
            return true;
        } else{
            System.out.println(fechaInscripto + " supera la fecha limite de " + fechLimite);
        }
        return false;
    }

}
