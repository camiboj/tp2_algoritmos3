package vista.botones;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import modelo.jugador.YuGiOh;
import vista.ContenedorBase;
import vista.Controlador;

public class BotonCambiarTurno extends Button implements EventHandler<ActionEvent> {

        private Controlador controlador;

        public BotonCambiarTurno(Controlador controlador) {
            this.controlador = controlador;
        }

        @Override
        public void handle(ActionEvent actionEvent) {
            controlador.cambiarTurno();
        }
}

