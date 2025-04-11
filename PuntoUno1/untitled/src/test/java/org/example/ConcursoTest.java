package org.example;
import java.time.LocalDate;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConcursoTest {
    LocalDate fechaInicio = LocalDate.now ();
    LocalDate fechaLimite = LocalDate.now ().plusDays (10);


    @Test
    void concursoTest () {
        var enMemoria = new FakeRegistroDeInscripcion();
        var EmvioMail = new FakeNotificacionDeMail ();

        Concurso concurso = new Concurso ("1234", fechaInicio, fechaLimite,
                "concurso de Prueba", enMemoria, EmvioMail);

        Participante p = new Participante ("Jhon", "Lennon", LocalDate.now ().plusDays (2),"JohnLennon@gmail.com");

        concurso.agregarParticipante (p.fechaInscripcionParticipante (), p);

        Assert.assertTrue (enMemoria.startsWith ("Jhon"));
        Assert.assertTrue (EmvioMail.startsWith ("JohnLennon@gmail.com"));
    }


}