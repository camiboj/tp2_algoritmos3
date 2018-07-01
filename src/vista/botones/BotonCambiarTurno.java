package vista.botones;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import jugador.YuGiOh;

public class BotonCambiarTurno extends Button implements EventHandler<ActionEvent> {

        private final Stage stage;
        private final YuGiOh yuGiOh;

        public BotonCambiarTurno(Stage stage, YuGiOh yuGiOh) {

            this.stage = stage;
            this.yuGiOh = yuGiOh;
        }

        @Override
        public void handle(ActionEvent actionEvent) {
           //
        }
}

