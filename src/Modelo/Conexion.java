
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private Connection conexion;
    private static final String user = "root";
    private static final String password = "josecepida";
    private static final String url = "jdbc:mysql://localhost:3306/bd_ejemplo";
    
    public Connection getConnection(){
        try {
            conexion = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión establecida");
        } catch (SQLException e) {
            System.out.println("Error al conectar: " + e.getMessage());
        }
        return conexion;
    }
}
