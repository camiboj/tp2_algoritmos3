package vista.botones;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import vista.ContenedorInicial;

public class BotonInicializar implements EventHandler<ActionEvent> {

    private final ContenedorInicial contenedor;

    public BotonInicializar(ContenedorInicial unContenedor){
            contenedor = unContenedor;
    }

    @Override
    public void handle(ActionEvent arg0) {
        contenedor.habilitarJugarTrasAceptar();

    }
}
