package vista.handler;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import vista.ContenedorBase;
import vista.VistaJugador;
import vista.VistaMano;
import vista.botones.BotonBotonera;

public class FinFasePreparacionHandler implements EventHandler {

    private final BotonBotonera botonFinAtaque;
    private final BotonBotonera botonFinPreparacion;
    private final ContenedorBase contenedorBase;
    private final VistaMano vistaMano;
    private final VistaJugador vistaJugador;

    public FinFasePreparacionHandler(BotonBotonera botonFinPreparacion, BotonBotonera botonFinAtaque,
                                     ContenedorBase contenedorBase, VistaMano vistaMano,
                                     VistaJugador vistaJugador){

        this.botonFinAtaque = botonFinAtaque;
        this.botonFinPreparacion = botonFinPreparacion;
        this.contenedorBase = contenedorBase;
        this.vistaMano = vistaMano;
        this.vistaJugador = vistaJugador;
     }

    @Override
    public void handle(Event event) {
        this.botonFinPreparacion.setDisable(true);
        this.botonFinAtaque.setDisable(false);
        contenedorBase.escribirEnConsola("Inicio Fase de Ataque: \n" +
                "Se pueden realizar tantos ataques como quiera, pero cada monstruo puede atacar una vez.");
        vistaMano.desactivarCartas();

        final ContextMenu contextMenu = new ContextMenu();

        MenuItem opcionAtacar = new MenuItem("Atacar!");
        opcionAtacar.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                //Handle
            }
        });

        contextMenu.getItems().addAll(opcionAtacar);
        vistaJugador.setOpcionAtacar(contextMenu);

        //Crear el menucontext de las cartas y pasarselo a vista zona monstruo
    }
}
