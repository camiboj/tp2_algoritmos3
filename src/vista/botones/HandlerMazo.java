package vista.botones;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.excepciones.VictoriaException;
import modelo.jugador.Jugador;
import modelo.jugador.YuGiOh;
import vista.VistaMano;

public class HandlerMazo implements EventHandler<ActionEvent> {
    private final YuGiOh juego;
    private final VistaMano vistaMano;
    private final BotonCartaBocaAbajo boton;
    private Jugador jugadorTurno;

    public HandlerMazo(YuGiOh juego, VistaMano vistaMano, Jugador jugadorTurno, BotonCartaBocaAbajo boton) {
        this.juego = juego;
        this.vistaMano = vistaMano;
        this.jugadorTurno = jugadorTurno;
        this.boton = boton;

    }

    @Override
    public void handle(ActionEvent event) {
        try {
            juego.ejecutarFaseInicial(jugadorTurno);
            vistaMano.reset();
            vistaMano.mostrar();
            boton.setDisable(true);
        } catch (VictoriaException e) {
            e.printStackTrace();
        }
    }
}
