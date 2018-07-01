package vista.botones;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import jugador.Jugador;
import jugador.YuGiOh;
import tablero.LadoDelCampo;
import vista.ContenedorPrincipal;
import vista.VistaJugador;

public class BotonIniciarJuego extends Button implements EventHandler<ActionEvent> {

    private final Stage stage;
    private final YuGiOh yuGiOh;
    private String nombre1;
    private String nombre2;

    public BotonIniciarJuego(Stage stage, YuGiOh yuGiOh) {

        this.stage = stage;
        this.yuGiOh = yuGiOh;
    }

    public void guardarNombres(String nombre1, String nombre2){
        this.nombre1 = nombre1;
        this.nombre2 = nombre2;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(yuGiOh.mostrarTablero());
        Jugador jugador1 = yuGiOh.obtenerJugador1();
        Jugador jugador2 = yuGiOh.obtenerJugador2();
        LadoDelCampo ladoDelCampo1 = yuGiOh.mostrarTablero().mostrarLadoDelCampo(jugador1);
        LadoDelCampo ladoDelCampo2 = yuGiOh.mostrarTablero().mostrarLadoDelCampo(jugador2);

        VistaJugador vista1 = new VistaJugador(jugador1, ladoDelCampo1, nombre1);
        VistaJugador vista2 = new VistaJugador(jugador2, ladoDelCampo2, nombre2);

        /*Scene escenaJuego = new Scene(contenedorPrincipal, 640, 480);
        stage.setScene(escenaJuego);
        stage.setFullScreenExitHint("");
        stage.setFullScreen(true);*/
    }
}
