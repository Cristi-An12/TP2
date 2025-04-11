package org.example;
import java.time.LocalDate;

public class Participante {

    private String nombre;
    private String apellido;
    private int numInscripcion;//la dara el concurso con un autoincremental
    private LocalDate fechaInscripto;
    private int puntos=0;
    private String Mail;

    public Participante (String nombre, String apellido, LocalDate fechaInscripto, String Mail) {

        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaInscripto = fechaInscripto;
        this.Mail = Mail;
    }

    public void agregarPuntos (int puntosAgregados){
        puntos = puntos+puntosAgregados;
    }

    public void asignarNumeroDeParticipante (int numInscripcion){
        this.numInscripcion = numInscripcion;
    }

    public void puntosGanados(){
        System.out.println ("Los puntos de " + nombre + " " + apellido + " es de:" + puntos);
    }

    public LocalDate fechaInscripcionParticipante() {
        return fechaInscripto;
    }

    public int numeroDeInscripto (){
        return numInscripcion;
    }

    public int verPuntos (){
        return puntos;
    }

    public String verNombre(){
        return nombre;
    }

    public String mailDeParticipante(){return Mail;}
}
