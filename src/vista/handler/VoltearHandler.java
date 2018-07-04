package vista.handler;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import vista.VistaZonaMonstruo;
import vista.botones.BotonCartaBocaAbajo;
import vista.botones.BotonCartaZonaMonstruo;

public class VoltearHandler implements EventHandler<ActionEvent> {

    private final BotonCartaZonaMonstruo botonCartaBocaArriba;
    private final BotonCartaBocaAbajo botonCartaBocaAbajo;
    private final VistaZonaMonstruo vistaZonaMonstruo;

    public VoltearHandler(BotonCartaZonaMonstruo botonCartaBocaArriba, BotonCartaBocaAbajo botonCartaBocaAbajo, VistaZonaMonstruo vistaZonaMonstruo) {
        this.botonCartaBocaArriba = botonCartaBocaArriba;
        this.botonCartaBocaAbajo = botonCartaBocaAbajo;
        this.vistaZonaMonstruo = vistaZonaMonstruo;
    }
        @Override
    public void handle(ActionEvent event) {
        vistaZonaMonstruo.voltear(botonCartaBocaAbajo, botonCartaBocaArriba, botonCartaBocaAbajo.obtenerFila(), botonCartaBocaAbajo.obtenerColumna());
    }
}
