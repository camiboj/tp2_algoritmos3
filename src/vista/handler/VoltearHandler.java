package vista.handler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import vista.vistaZonas.VistaZonas;
import vista.botones.BotonCarta;
import vista.botones.BotonCartaBocaAbajo;

public class VoltearHandler implements EventHandler<ActionEvent> {

    private final BotonCarta botonCartaBocaArriba;
    private final BotonCartaBocaAbajo botonCartaBocaAbajo;
    private final VistaZonas vista;

    public VoltearHandler(BotonCarta botonCartaBocaArriba, BotonCartaBocaAbajo botonCartaBocaAbajo,
                          VistaZonas vista) {
        this.botonCartaBocaArriba = botonCartaBocaArriba;
        this.botonCartaBocaAbajo = botonCartaBocaAbajo;
        this.vista = vista;
    }

    @Override
    public void handle(ActionEvent event) {
        vista.voltear(botonCartaBocaAbajo, botonCartaBocaArriba, botonCartaBocaAbajo.obtenerFila(),
                botonCartaBocaAbajo.obtenerColumna());
    }
}