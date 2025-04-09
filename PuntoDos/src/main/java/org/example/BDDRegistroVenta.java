package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BDDRegistroVenta implements RegistroVentas{
    private Connection Conexion;

    public BDDRegistroVenta (Connection Conexion){
        this.Conexion = Conexion;
    }
    @Override
    public void registrarVenta (double TotalCosto) {
        LocalDateTime fechaActual = LocalDateTime.now ();
        String SQL = "INSERT INTO RegistroVesntas (fechaActual, TotalCosto) VALUES (?,?)";

        try (PreparedStatement dato = Conexion.prepareStatement(SQL)){
            dato.setTimestamp (1, Timestamp.valueOf (fechaActual));
            dato.setDouble (2, TotalCosto);
            dato.executeUpdate ();
        }catch (SQLException e){
            System.err.println ("error al insertar en la base de datos: " + e.getMessage ());
        }
    }
}
