package vista.botones;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.excepciones.VictoriaException;
import vista.VistaZonaMonstruo;

public class VoltearHandle implements EventHandler<ActionEvent> {

    private final BotonCartaZonaMonstruo botonCartaBocaArriba;
    private final BotonCartaBocaAbajo botonCartaBocaAbajo;
    private final VistaZonaMonstruo vistaZonaMonstruo;

    public VoltearHandle(BotonCartaZonaMonstruo botonCartaBocaArriba, BotonCartaBocaAbajo botonCartaBocaAbajo, VistaZonaMonstruo vistaZonaMonstruo) {
        this.botonCartaBocaArriba = botonCartaBocaArriba;
        this.botonCartaBocaAbajo = botonCartaBocaAbajo;
        this.vistaZonaMonstruo = vistaZonaMonstruo;
    }
        @Override
    public void handle(ActionEvent event) {
        vistaZonaMonstruo.voltear(botonCartaBocaAbajo, botonCartaBocaArriba, botonCartaBocaAbajo.obtenerFila(), botonCartaBocaAbajo.obtenerColumna());
    }
}
