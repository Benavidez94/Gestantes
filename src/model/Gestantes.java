package model;

/**
 * Clase Gestantes en la aplicación.
 */
public class Gestantes {
    private int id;
    private String nombre;
    private String numeroIdentificacion;
    private String fechaIngreso;
    private String municipioAfiliacion;

    // Getter y Setter para id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter y Setter para nombre
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter y Setter para numeroIdentificacion
    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    // Getter y Setter para fechaIngreso
    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    // Getter y Setter para municipioAfiliacion
    public String getMunicipioAfiliacion() {
        return municipioAfiliacion;
    }

    public void setMunicipioAfiliacion(String municipioAfiliacion) {
        this.municipioAfiliacion = municipioAfiliacion;
    }

    // Método toString para representación en cadena del objeto
    @Override
    public String toString() {
        return "Gestantes{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", numeroIdentificacion='" + numeroIdentificacion + '\'' +
                ", fechaIngreso='" + fechaIngreso + '\'' +
                ", municipioAfiliacion='" + municipioAfiliacion + '\'' +
                '}';
    }
}
