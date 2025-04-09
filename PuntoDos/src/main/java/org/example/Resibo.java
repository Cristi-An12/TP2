package org.example;
import java.io.FileWriter;
import java.io.IOException;

import java.io.Writer;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Resibo implements RegistroVentas{
    private String RutaArchivo;

    public Resibo (String RutaArchivo){
        this.RutaArchivo = RutaArchivo;
    }

    @Override
    public void registrarVenta (double TotalCosto) {
        String fechaActual = LocalDate.now ().format (DateTimeFormatter.ofPattern ("dd/MM/yy"));
        String Linea = fechaActual + " || " + TotalCosto ;

        try (FileWriter escribir = new FileWriter (RutaArchivo, true)){
            escribir.write (Linea + "\n");
        }catch (IOException e){
            e.printStackTrace ();
        }
    }
}
