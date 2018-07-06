package vista.handler;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.Fase.FasePreparacion;
import modelo.excepciones.VictoriaException;
import modelo.jugador.Jugador;
import modelo.jugador.YuGiOh;
import vista.ContenedorBase;
import vista.Controlador;
import vista.vistaZonas.VistaMano;
import vista.botones.BotonBotonera;
import vista.botones.BotonCartaBocaAbajo;

public class MazoHandler implements EventHandler<ActionEvent> {
    private Controlador controlador;
    private ContenedorBase contenedorBase;
    private FasePreparacion fasePreparacion;
    private BotonBotonera botonFinPreparacion;
    private YuGiOh juego;
    private VistaMano vistaMano;
    private BotonCartaBocaAbajo botonMazo;
    private Jugador jugadorTurno;


    public MazoHandler(YuGiOh juego, VistaMano vistaMano, Jugador jugadorTurno, BotonCartaBocaAbajo boton,
                       BotonBotonera botonFinFaseDePreparacion, FasePreparacion fasePreparacion,
                       ContenedorBase contenedorBase, Controlador controlador) {

        this.fasePreparacion = fasePreparacion;
        this.juego = juego;
        this.controlador = controlador;
        this.contenedorBase = contenedorBase;
        this.vistaMano = vistaMano;
        this.jugadorTurno = jugadorTurno;
        this.botonMazo = boton;
        this.botonFinPreparacion = botonFinFaseDePreparacion;
    }

    @Override
    public void handle(ActionEvent event) {
        try {
            juego.ejecutarFaseInicial(jugadorTurno);
            vistaMano.esconder();
            vistaMano.mostrar(fasePreparacion, controlador);
            vistaMano.activarCartas();
            botonMazo.setDisable(true);
            botonFinPreparacion.setDisable(false);
            juego.ejecutarFasePreparacion(jugadorTurno);
            contenedorBase.escribirEnConsola("Inicio Fase de preparación: \n" +
                    "Se pueden colocar tantas cartas de magia y trampa como se quiera, pero solo una invocación de monstruo ");
        } catch (VictoriaException e) {
            contenedorBase.escribirEnConsola("Ha terminado el juego. Felictaciones al ganador!");
        }
    }
}
