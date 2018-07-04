package vista.handler;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import vista.ContenedorBase;
import vista.Controlador;
import vista.VistaJugador;
import vista.VistaMano;
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
                "Se pueden realizar tantos ataques como quiera, pero cada monstruo puede atacar una vez.");
        vistaMano.desactivarCartas();

        controlador.setOpcionAtacar();
    }
}
