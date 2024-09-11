package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    private static final Logger LOGGER = Logger.getLogger(Conexion.class.getName());
    
    private String base = "crud_gestantes"; // Nombre de la base de datos
    private String user = "root"; // Usuario de la base de datos
    private String password = ""; // Contraseña de la base de datos
    private String url = "jdbc:mysql://localhost:3306/" + base + "?serverTimezone=UTC"; // URL de conexión con timezone UTC
    
    // Método para obtener la conexión
    public Connection getConexion() {
        Connection con = null;
        try {
            // Usar el nuevo driver de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establecer la conexión
            con = DriverManager.getConnection(this.url, this.user, this.password);
        } catch (SQLException e) {
            // Manejo de excepciones SQL
            LOGGER.log(Level.SEVERE, "Error en la conexión: ", e);
        } catch (ClassNotFoundException ex) {
            // Manejo de excepciones si el driver no se encuentra
            LOGGER.log(Level.SEVERE, "Driver MySQL no encontrado", ex);
        }
        return con; // Retorna la conexión
    }
}
