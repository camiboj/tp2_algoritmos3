package vista.botones;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import jugador.YuGiOh;
import vista.ContenedorPrincipal;

public class BotonJugar implements EventHandler<ActionEvent> {

    private final Stage stage;
    private final YuGiOh yuGiOh;
    private final MediaPlayer mediaplayer;

    public BotonJugar(Stage stage, YuGiOh yuGiOh, MediaPlayer mediaplayer) {
        this.stage = stage;
        this.yuGiOh = yuGiOh;
        this.mediaplayer = mediaplayer;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(yuGiOh.mostrarTablero());
        mediaplayer.stop();
        Scene escenaJuego = new Scene(contenedorPrincipal, 640, 480);
        stage.setScene(escenaJuego);
        stage.setFullScreenExitHint("");
        stage.setFullScreen(true);
    }
}
