package controller;

import view.Principal;
import view.ViewGestantes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerPrincipal implements ActionListener {
    private Principal frmPri;
    private ViewGestantes frmPro;

    public ControllerPrincipal(Principal frmPri, ViewGestantes frmPro) {
        this.frmPri = frmPri;
        this.frmPro = frmPro;
        // Registrar el controlador para los botones
        this.frmPri.btn_destiny.addActionListener(this);
        this.frmPri.btn_exit.addActionListener(this);
    }

    // Método para configurar las vistas
    public void iniciar() {
        // Configura los títulos de las ventanas
        frmPro.setTitle("Destino");
        frmPri.setTitle("Principal");
        
        // Ajusta la ubicación de las ventanas para que estén centradas en la pantalla
        frmPri.setLocationRelativeTo(null);
        frmPro.setLocationRelativeTo(null);
        
        // Inicialmente, no se debe mostrar la ventana de destino
        frmPro.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmPri.btn_destiny) {
            // Muestra la ventana de destino
            frmPro.setVisible(true);
            // Opcional: Cierra la ventana principal
            frmPri.dispose(); // Esto cierra la ventana principal
        }

        if (e.getSource() == frmPri.btn_exit) {
            // Sale de la aplicación
            System.exit(0);
        }
    }
}
