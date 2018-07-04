package vista.handler;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.excepciones.VictoriaException;
import modelo.jugador.Jugador;
import modelo.jugador.YuGiOh;
import vista.VistaMano;
import vista.botones.BotonBotonera;
import vista.botones.BotonCartaBocaAbajo;

public class MazoHandler implements EventHandler<ActionEvent> {
    private BotonBotonera botonFinPreparacion;
    private YuGiOh juego;
    private VistaMano vistaMano;
    private BotonCartaBocaAbajo botonMazo;
    private Jugador jugadorTurno;


    public MazoHandler(YuGiOh juego, VistaMano vistaMano, Jugador jugadorTurno, BotonCartaBocaAbajo boton,
                       BotonBotonera botonFinFaseDePreparacion) {
        this.juego = juego;
        this.vistaMano = vistaMano;
        this.jugadorTurno = jugadorTurno;
        this.botonMazo = boton;
        this.botonFinPreparacion = botonFinFaseDePreparacion;
    }

    @Override
    public void handle(ActionEvent event) {
        try {
            juego.ejecutarFaseInicial(jugadorTurno);
            vistaMano.reset();
            vistaMano.mostrar();
            vistaMano.activarCartas();
            botonMazo.setDisable(true);
            botonFinPreparacion.setDisable(false);
            juego.ejecutarFasePreparacion(jugadorTurno);
        } catch (VictoriaException e) {
        }
    }
}
