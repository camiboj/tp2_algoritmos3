package vista.botones;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import jugador.Jugador;
import jugador.YuGiOh;
import tablero.LadoDelCampo;
import vista.ContenedorBase;
import vista.ContenedorTurno;
import vista.VistaJugador;

public class BotonIniciarJuego extends Button implements EventHandler<ActionEvent> {

    private final Stage stage;
    private final YuGiOh yuGiOh;

    public BotonIniciarJuego(Stage stage, YuGiOh yuGiOh) {

        this.stage = stage;
        this.yuGiOh = yuGiOh;
    }

    public void guardarNombres(String nombre1, String nombre2) {
        yuGiOh.obtenerJugador1().guardarNombre(nombre1);
        yuGiOh.obtenerJugador2().guardarNombre(nombre2);

    }

    @Override
    public void handle(ActionEvent actionEvent) {

        ContenedorBase contenedorBase = new ContenedorBase(yuGiOh.mostrarTablero());
        ContenedorTurno contenedorTurno = new ContenedorTurno(stage, yuGiOh, contenedorBase);
        Jugador jugador1 = yuGiOh.obtenerJugador1();
        Jugador jugador2 = yuGiOh.obtenerJugador2();
        LadoDelCampo ladoDelCampo1 = yuGiOh.mostrarTablero().mostrarLadoDelCampo(jugador1);
        LadoDelCampo ladoDelCampo2 = yuGiOh.mostrarTablero().mostrarLadoDelCampo(jugador2);

        //VistaJugador vista1 = new VistaJugador(jugador1, ladoDelCampo1);
        //VistaJugador vista2 = new VistaJugador(jugador2, ladoDelCampo2, nombre2);

        Scene escenaJuego = new Scene(contenedorTurno, 640, 480);
        stage.setScene(escenaJuego);
        stage.setFullScreenExitHint("");
        stage.setFullScreen(true);
    }
}
