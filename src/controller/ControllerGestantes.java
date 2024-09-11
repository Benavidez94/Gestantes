package controller;

import model.ConsultasGestantes;
import model.Gestantes;
import view.ViewGestantes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 * Controlador para manejar las acciones en la vista de gestantes.
 */
public class ControllerGestantes implements ActionListener {
    private Gestantes gestante;
    private ViewGestantes viewGestantes;
    private ConsultasGestantes consultasGestantes;

    public ControllerGestantes(Gestantes gestante, ViewGestantes viewGestantes, ConsultasGestantes consultasGestantes) {
        this.gestante = gestante;
        this.viewGestantes = viewGestantes;
        this.consultasGestantes = consultasGestantes;
        this.viewGestantes.btn_create.addActionListener(this);
        this.viewGestantes.btn_update.addActionListener(this);
        this.viewGestantes.btn_clean.addActionListener(this);
        this.viewGestantes.btn_read.addActionListener(this);
        this.viewGestantes.btn_delete.addActionListener(this);
        this.viewGestantes.btn_principal.addActionListener(this);        
    }   
    
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == viewGestantes.btn_create) {
                if (validateInputs()) {
                    gestante.setNombre(viewGestantes.txt_name.getText());
                    gestante.setNumeroIdentificacion(viewGestantes.txt_numeroidentificacion.getText());
                    gestante.setFechaIngreso(viewGestantes.txt_fechaingreso.getText());
                    gestante.setMunicipioAfiliacion(viewGestantes.txt_municipio.getText());
                    if (consultasGestantes.registrar(gestante)) {
                        JOptionPane.showMessageDialog(null, "Gestante agregado");
                        limpiar();
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al agregar");
                    }
                }
            } else if (e.getSource() == viewGestantes.btn_update) {
                if (validateInputs() && !viewGestantes.txt_id.getText().trim().isEmpty()) {
                    gestante.setId(Integer.parseInt(viewGestantes.txt_id.getText()));
                    gestante.setNombre(viewGestantes.txt_name.getText());
                    gestante.setNumeroIdentificacion(viewGestantes.txt_numeroidentificacion.getText());
                    gestante.setFechaIngreso(viewGestantes.txt_fechaingreso.getText());
                    gestante.setMunicipioAfiliacion(viewGestantes.txt_municipio.getText());
                    if (consultasGestantes.modificar(gestante)) {
                        JOptionPane.showMessageDialog(null, "Gestante modificado");
                        limpiar();
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al modificar");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "ID no puede estar vacío.");
                }
            } else if (e.getSource() == viewGestantes.btn_delete) {
                if (!viewGestantes.txt_id.getText().trim().isEmpty()) {
                    gestante.setId(Integer.parseInt(viewGestantes.txt_id.getText()));
                    if (consultasGestantes.eliminar(gestante)) {
                        JOptionPane.showMessageDialog(null, "Gestante eliminado");
                        limpiar();
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al eliminar");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El ID no puede estar vacío.");
                }
            } else if (e.getSource() == viewGestantes.btn_read) {
                if (!viewGestantes.txt_id.getText().trim().isEmpty()) {
                    gestante.setId(Integer.parseInt(viewGestantes.txt_id.getText()));
                    if (consultasGestantes.buscar(gestante)) {
                        viewGestantes.txt_id.setText(String.valueOf(gestante.getId()));
                        viewGestantes.txt_name.setText(gestante.getNombre());
                        viewGestantes.txt_numeroidentificacion.setText(gestante.getNumeroIdentificacion());
                        viewGestantes.txt_fechaingreso.setText(gestante.getFechaIngreso());
                        viewGestantes.txt_municipio.setText(gestante.getMunicipioAfiliacion());
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al buscar");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El ID no puede estar vacío.");
                }
            } else if (e.getSource() == viewGestantes.btn_clean) {
                limpiar();
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Número no válido. Verifique los campos de ID.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error inesperado: " + ex.getMessage());
        }
    }

    /**
     * Valida que todos los campos necesarios estén oe llenos.
     * @return true si todos los campos son válidos, false de lo contrario.
     */
    private boolean validateInputs() {
        if (viewGestantes.txt_name.getText().trim().isEmpty() ||
            viewGestantes.txt_numeroidentificacion.getText().trim().isEmpty() ||
            viewGestantes.txt_fechaingreso.getText().trim().isEmpty() ||
            viewGestantes.txt_municipio.getText().trim().isEmpty()) {
            
            JOptionPane.showMessageDialog(null, "Todos los campos deben estar llenos.");
            return false;
        }
        
        return true;
    }

    /**
     * Limpia todos los campos de la vista.
     */
    private void limpiar() {
        viewGestantes.txt_id.setText("");
        viewGestantes.txt_name.setText("");
        viewGestantes.txt_numeroidentificacion.setText("");
        viewGestantes.txt_fechaingreso.setText("");
        viewGestantes.txt_municipio.setText("");
    }
}