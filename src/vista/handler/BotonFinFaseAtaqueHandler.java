package vista.handler;

import javafx.event.Event;
import javafx.event.EventHandler;
import vista.ContenedorBase;
import vista.Controlador;

public class BotonFinFaseAtaqueHandler implements EventHandler {
    private ContenedorBase contenedorBase;
    private Controlador controlador;

    public BotonFinFaseAtaqueHandler(ContenedorBase contenedorBase, Controlador controlador) {
        this.contenedorBase = contenedorBase;
        this.controlador = controlador;

    }

    @Override
    public void handle(Event event) {
        contenedorBase.escribirEnConsola("Inicio de la Fase Final. Haz click para voltear las Cartas Mágicas " +
                "que desees del tablero " +
                "así activan su efecto. Cuando desees cambiar de turno haz click en 'Fin de Turno'");
        controlador.activarFaseFinal(); //Desactivar cartas que no sean mágicas
        controlador.activarFinTurno();
    }
}
