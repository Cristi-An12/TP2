package org.example;

import java.time.LocalDate;

public class FakeRegistroDeInscripcion implements RegistrarInscriptos{
    private String Nombre_Participante;
    private String id_concurso;
    private LocalDate fechaInscripto;

    @Override
    public void registrarInscriptos (String Nombre_participante, String id_concurso, LocalDate fechaInscripto) {
        this.Nombre_Participante = Nombre_participante;
        this.id_concurso = id_concurso;
        this.fechaInscripto = fechaInscripto;
    }

    public boolean startsWith (String start){
        return this.Nombre_Participante.startsWith (start);

    }
}
