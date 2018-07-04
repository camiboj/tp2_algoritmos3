package vista.handler;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import vista.ContextMenuAtacante;
import vista.Controlador;
import vista.botones.BotonCartaZonaMonstruo;

import javax.naming.Context;

public class OpcionesAtacarHandler implements EventHandler<ActionEvent> {
    private final Controlador controlador;
    private final ContextMenuAtacante contextMenuAtacante;

    public OpcionesAtacarHandler(Controlador controlador, ContextMenuAtacante contextMenuAtacante) {
        this.controlador = controlador;
        this.contextMenuAtacante = contextMenuAtacante;
    }

    @Override
    public void handle(ActionEvent event) {
        controlador.generarOpcionesAtaque(contextMenuAtacante);
    }
}
