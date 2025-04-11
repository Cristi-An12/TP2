package org.example;

import java.sql.*;
import java.time.LocalDate;

public class BdDRegistrarInscripto /*implements RegistrarInscriptos*/{
//    private Connection conexion;
//
//    public BdDRegistrarInscripto (Connection conexion){
//        this.conexion=conexion;
//    }
//
//    @Override
//    public void registrarInscriptos (String Nombre_participante, String id_concurso, LocalDate fechaInscripto) {
//        String sql = "INSERT INTO Inscripciones (id_participante, id_concurso, fechaInscripto) VALUES (?,?,?)";
//
//        try (PreparedStatement dato = conexion.prepareStatement (sql)){
//            Date fechaSQL = Date.valueOf (fechaInscripto);
//
//            dato.setInt (1, Nombre_participante);
//            dato.setInt (2, id_concurso);
//            dato.setDate (3, fechaSQL);
//            dato.executeUpdate ();
//
//
//        }catch (SQLException e){
//            System.err.println ("Error al conectarse "+ e.getMessage ());
//        }
//    }
}

