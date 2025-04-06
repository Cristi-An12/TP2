package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.*;

public class RegistrarInscripto {
    public static final String ARCHIVO = "PARTICIPANTES.txt";

    public void registrar (String nombreConcurso, int numInscripto){
        String fechaInscripto = LocalDate.now ().format (DateTimeFormatter.ofPattern ("dd/MM/yy"));
        String LineaCOmpleta = fechaInscripto + ", " + nombreConcurso + ", numero de inscripcion:" + numInscripto;

        try (FileWriter writer = new FileWriter (ARCHIVO, true)){
            writer.write (LineaCOmpleta + "\n");
        }catch (IOException e){
            e.printStackTrace ();
        }
    }
}
