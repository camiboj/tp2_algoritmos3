package vista.botones;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import modelo.jugador.YuGiOh;
import vista.ContenedorBase;

public class BotonCambiarTurno extends Button implements EventHandler<ActionEvent> {

        private final ContenedorBase contenedorBase;

        public BotonCambiarTurno(ContenedorBase contenedorBase) {
            this.contenedorBase = contenedorBase;
        }

        @Override
        public void handle(ActionEvent actionEvent) {
            contenedorBase.cambiarTurno();
        }
}

