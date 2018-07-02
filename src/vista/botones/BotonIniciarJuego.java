package vista.botones;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelo.jugador.Jugador;
import modelo.jugador.YuGiOh;
import modelo.tablero.LadoDelCampo;
import vista.ContenedorBase;

public class BotonIniciarJuego extends Button implements EventHandler<ActionEvent> {

    private final Stage stage;
    private final YuGiOh yuGiOh;
    private final TextField nombreJugador1;
    private final TextField nombreJugador2;

    public BotonIniciarJuego(Stage stage, YuGiOh yuGiOh, TextField nombreJugador1, TextField nombreJugador2) {

        this.stage = stage;
        this.yuGiOh = yuGiOh;
        this.nombreJugador1 = nombreJugador1;
        this.nombreJugador2 = nombreJugador2;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        yuGiOh.obtenerJugador1().guardarNombre(nombreJugador1.getText());
        yuGiOh.obtenerJugador2().guardarNombre(nombreJugador2.getText());
        ContenedorBase contenedorBase = new ContenedorBase(stage, yuGiOh, yuGiOh.mostrarTablero());
        //ContenedorTurno contenedorTurno = new ContenedorTurno(stage, yuGiOh, contenedorBase);
        Jugador jugador1 = yuGiOh.obtenerJugador1();
        Jugador jugador2 = yuGiOh.obtenerJugador2();
        LadoDelCampo ladoDelCampo1 = yuGiOh.mostrarTablero().mostrarLadoDelCampo(jugador1);
        LadoDelCampo ladoDelCampo2 = yuGiOh.mostrarTablero().mostrarLadoDelCampo(jugador2);

        //VistaJugador vista1 = new VistaJugador(jugador1, ladoDelCampo1);
        //VistaJugador vista2 = new VistaJugador(jugador2, ladoDelCampo2, nombre2);

        Scene escenaJuego = new Scene(contenedorBase, 640, 480);
        stage.setScene(escenaJuego);
        stage.setFullScreenExitHint("");
        stage.setFullScreen(true);
    }
}
