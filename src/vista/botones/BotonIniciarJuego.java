package vista.botones;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import modelo.jugador.YuGiOh;
import vista.Controlador;

public class BotonIniciarJuego extends Button implements EventHandler<ActionEvent> {

    private final Stage stage;
    private final YuGiOh yuGiOh;
    private final TextField nombreJugador1;
    private final TextField nombreJugador2;
    private final MediaPlayer mediaPlayer;

    public BotonIniciarJuego(Stage stage, YuGiOh yuGiOh, TextField nombreJugador1, TextField nombreJugador2, MediaPlayer mediaPlayer) {

        this.stage = stage;
        this.yuGiOh = yuGiOh;
        this.nombreJugador1 = nombreJugador1;
        this.nombreJugador2 = nombreJugador2;
        this.mediaPlayer = mediaPlayer;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        yuGiOh.obtenerJugador1().guardarNombre(nombreJugador1.getText());
        yuGiOh.obtenerJugador2().guardarNombre(nombreJugador2.getText());

        mediaPlayer.stop();
        Controlador controlador = new Controlador(stage, yuGiOh, yuGiOh.mostrarTablero());
        controlador.mostrar(stage);
    }
}
