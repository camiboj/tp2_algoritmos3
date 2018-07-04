package vista.handler;

import javafx.event.Event;
import javafx.event.EventHandler;
import vista.Controlador;

public class CambiarTurnoHandler implements EventHandler {

    private final Controlador controlador;

    public CambiarTurnoHandler(Controlador controlador){
        this.controlador = controlador;
    }
    @Override
    public void handle(Event event) {
        controlador.cambiarTurno();
    }
}
