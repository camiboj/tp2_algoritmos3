package vista.botones;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import vista.Controlador;

public class HandlerCambiarTurno implements EventHandler {

    private final Controlador controlador;

    public HandlerCambiarTurno(Controlador controlador){
        this.controlador = controlador;
    }
    @Override
    public void handle(Event event) {
        controlador.cambiarTurno();
    }
}
