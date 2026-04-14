package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    private String nombreBd = "indiceMasa";
    private String usuario = "root";
    private String password = "root";
    private String url = "jdbc:mysql://localhost:3306/" + nombreBd +
            "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url, usuario, password);
        } catch (Exception e) {
            System.out.println("Error conexión: " + e.getMessage());
            return null;
        }
    }
}