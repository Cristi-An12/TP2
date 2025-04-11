package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.*;

public class TXTRegistrarInscripto implements RegistrarInscriptos {
    private String rutaArchivo;

    public TXTRegistrarInscripto (String rutaArchivo) {
        this.rutaArchivo=rutaArchivo;
    }


    @Override
    public void registrarInscriptos (String Nombre_participante, String id_concurso, LocalDate fechaInscripto) {
        DateTimeFormatter formato =DateTimeFormatter.ofPattern ("dd/MM/yy");
        String linea=" Nombre participante: " + Nombre_participante + " || Id concurso: " + id_concurso +  fechaInscripto.format (formato);
        try (FileWriter esc = new FileWriter (rutaArchivo, true)){
            esc.write (linea + "\n");
        }catch (IOException e){
            System.err.println ("Error al escribir el archivo :" + e.getMessage ());
        }

    }
}
