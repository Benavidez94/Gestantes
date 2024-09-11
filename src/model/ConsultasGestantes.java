package model;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase ConsultasGestantes para realizar operaciones CRUD en la tabla gestantes.
 */
public class ConsultasGestantes extends Conexion {

    private static final Logger LOGGER = Logger.getLogger(ConsultasGestantes.class.getName());

    // Método para registrar un nuevo gestante
    public boolean registrar(Gestantes p) {
        if (p == null || p.getNombre() == null || p.getNumeroIdentificacion() == null) {
            LOGGER.warning("Datos incompletos para registrar un gestante.");
            return false;
        }

        String sql = "INSERT INTO gestantes (nombre, numeroIdentificacion, fechaIngreso, municipioAfiliacion) VALUES (?, ?, ?, ?)";
        try (Connection con = getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, p.getNombre());
            ps.setString(2, p.getNumeroIdentificacion());
            ps.setString(3, p.getFechaIngreso());
            ps.setString(4, p.getMunicipioAfiliacion());
            ps.executeUpdate(); // Use executeUpdate() for INSERT/UPDATE/DELETE statements
            return true;
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error al registrar: ", e);
            return false;
        }
    }

    // Método para modificar un gestante existente
    public boolean modificar(Gestantes p) {
        if (p == null || p.getId() <= 0) {
            LOGGER.warning("Datos incompletos para modificar un gestante.");
            return false;
        }

        String sql = "UPDATE gestantes SET nombre = ?, numeroIdentificacion = ?, fechaIngreso = ?, municipioAfiliacion = ? WHERE id = ?";
        try (Connection con = getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, p.getNombre());
            ps.setString(2, p.getNumeroIdentificacion());
            ps.setString(3, p.getFechaIngreso());
            ps.setString(4, p.getMunicipioAfiliacion());
            ps.setInt(5, p.getId());
            ps.executeUpdate(); // Use executeUpdate() for INSERT/UPDATE/DELETE statements
            return true;
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error al modificar: ", e);
            return false;
        }
    }

    // Método para eliminar un gestante
    public boolean eliminar(Gestantes p) {
        if (p == null || p.getId() <= 0) {
            LOGGER.warning("Datos incompletos para eliminar un gestante.");
            return false;
        }

        String sql = "DELETE FROM gestantes WHERE id = ?";
        try (Connection con = getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, p.getId());
            ps.executeUpdate(); // Use executeUpdate() for INSERT/UPDATE/DELETE statements
            return true;
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error al eliminar: ", e);
            return false;
        }
    }

    // Método para buscar un gestante por su id
    public boolean buscar(Gestantes p) {
        if (p == null || p.getId() <= 0) {
            LOGGER.warning("Datos incompletos para buscar un gestante.");
            return false;
        }

        String sql = "SELECT * FROM gestantes WHERE id = ?";
        try (Connection con = getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, p.getId());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    p.setId(rs.getInt("id"));
                    p.setNombre(rs.getString("nombre"));
                    p.setNumeroIdentificacion(rs.getString("numeroIdentificacion"));
                    p.setFechaIngreso(rs.getString("fechaIngreso"));
                    p.setMunicipioAfiliacion(rs.getString("municipioAfiliacion"));
                    return true;
                }
                return false;
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error al buscar: ", e);
            return false;
        }
    }
}
