package org.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionBdD {
    private static Connection conexion= null;

    public static Connection conexiones (){
        if(conexion == null){
            try {
                //estos son datos inventados para representar los paranebtros de configuracion
                String Url = "jdbc:mysql://localhost:3300/restautant_db";
                String user = "usuario";
                String password = "contraseña";

                //cargar el drive JDBC
                Class.forName ("com.mysql.jdbc.Drive");
                //crea una tabla si no existe
                crearTablaDeRecibos ();
            }catch (ClassNotFoundException |SQLException e){
                System.err.println ("Error al conectar la base de datos" + e.getMessage ());
            }

        }
        return conexion;

    }
    public static void crearTablaDeRecibos() throws SQLException{
        String sql = "CREATE TABLE IF NOT EXISTS recibos (" +
                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                "fecha_hora TIMESTAMP" +
                "id_participante VARCHAR(100) "+
                "id_concurso VARCHAR(100))";
        //CAMBIAR TIMESTAMP POR UNO QUE SOPORTE LOCALDATE
        try (Statement dato = conexion.createStatement ()){
            dato.execute (sql);
        }
    }

    public static void cerrarConexion (){
        if (conexion != null){
            try {
                conexion.close ();
            }catch (SQLException e){
                System.err.println ("Error al cerrar la conexion: "+ e.getMessage ());
            }
        }
    }


}

