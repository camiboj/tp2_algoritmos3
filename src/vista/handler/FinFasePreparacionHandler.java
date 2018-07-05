package vista.handler;

import javafx.event.Event;
import javafx.event.EventHandler;
import vista.ContenedorBase;
import vista.Controlador;
import vista.vistaZonas.VistaMano;
import vista.botones.BotonBotonera;

public class FinFasePreparacionHandler implements EventHandler {

    private final BotonBotonera botonFinAtaque;
    private final BotonBotonera botonFinPreparacion;
    private final ContenedorBase contenedorBase;
    private final VistaMano vistaMano;
    private final Controlador controlador;

    public FinFasePreparacionHandler(BotonBotonera botonFinPreparacion, BotonBotonera botonFinAtaque,
                                     ContenedorBase contenedorBase, VistaMano vistaMano,
                                     Controlador controlador){

        this.botonFinAtaque = botonFinAtaque;
        this.botonFinPreparacion = botonFinPreparacion;
        this.contenedorBase = contenedorBase;
        this.vistaMano = vistaMano;
        this.controlador = controlador;
     }

    @Override
    public void handle(Event event) {
        this.botonFinPreparacion.setDisable(true);
        this.botonFinAtaque.setDisable(false);
        contenedorBase.escribirEnConsola("Inicio Fase de Ataque: \n" +
                "Se pueden realizar tantos ataques como quiera, pero cada monstruo puede atacar una vez. " +
                "Para terminar la fase haz click en 'Fin Fase De Ataque'");
        vistaMano.desactivarCartas();

        controlador.setOpcionAtacar();
    }
}
