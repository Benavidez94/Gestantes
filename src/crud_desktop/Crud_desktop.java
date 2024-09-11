package crud_desktop;

import controller.ControllerPrincipal;
import controller.ControllerGestantes;
import model.ConsultasGestantes;
import model.Gestantes;
import view.Principal;
import view.ViewGestantes;

public class Crud_desktop {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // Crear instancias de los modelos, vistas y controladores
            Gestantes gestantes = new Gestantes();
            ConsultasGestantes consultasGestantes = new ConsultasGestantes();
            ViewGestantes viewGestantes = new ViewGestantes();
            ControllerGestantes controllerGestantes = new ControllerGestantes(gestantes, viewGestantes, consultasGestantes);
            
            Principal principalView = new Principal();
            ControllerPrincipal controllerPrincipal = new ControllerPrincipal(principalView, viewGestantes);

            // Iniciar el controlador principal
            controllerPrincipal.iniciar(); // Asegúrate de que el método se llama correctamente

            // Mostrar la vista principal
            principalView.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace(); // Manejo básico de excepciones
            // En un entorno de producción, podrías usar un logger en lugar de e.printStackTrace()
        }
    }
}