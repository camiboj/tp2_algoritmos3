package vista.handler;

import javafx.event.Event;
import javafx.event.EventHandler;
import modelo.cartas.cartasMagicas.CartaMagica;
import vista.Controlador;
import vista.botones.BotonCartaZonaTrampaMagica;
import vista.botones.Botonera;

import java.util.List;

public class CambiarTurnoHandler implements EventHandler {
    private final Controlador controlador;

    public CambiarTurnoHandler(Controlador controlador){
        this.controlador = controlador;
    }


    @Override
    public void handle(Event event) {
        controlador.eliminarMagicasActivadas();
        controlador.cambiarTurno();
    }
}
