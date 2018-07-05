package vista.handler;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.cartas.cartasMagicas.CartaMagica;
import modelo.excepciones.VictoriaException;
import vista.ContenedorBase;
import vista.Controlador;
import vista.VistaJugador;
import vista.botones.BotonCartaBocaAbajo;
import vista.botones.BotonCartaZonaTrampaMagica;

public class ActivarMagicaBocaAbajoHandler implements EventHandler<ActionEvent> {
    private Controlador controlador;
    protected VistaJugador vistaJugador;
    protected BotonCartaBocaAbajo botonCartaBocaAbajo;
    protected BotonCartaZonaTrampaMagica botonCartaBocaArriba;
    protected CartaMagica cartaMagica;
    protected ContenedorBase contenedorBase;

    public ActivarMagicaBocaAbajoHandler(Controlador controlador,
                                         VistaJugador vistaJugador, BotonCartaBocaAbajo botonCartaBocaAbajo,
                                         BotonCartaZonaTrampaMagica botonBocaArriba, ContenedorBase contenedorBase) {

        this.botonCartaBocaAbajo = botonCartaBocaAbajo;
        this.botonCartaBocaArriba = botonBocaArriba;
        this.vistaJugador = vistaJugador;
        this.cartaMagica = (CartaMagica) botonBocaArriba.obtenerCarta();
        this.contenedorBase = contenedorBase;
        this.controlador = controlador;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        contenedorBase.escribirEnConsola("Has activado una Carta Mágica. Recuerda que en el siguiente turno" +
                " va a desaparecer.");
        vistaJugador.eliminarElemento(botonCartaBocaAbajo);
        contenedorBase.getChildren().remove(botonCartaBocaAbajo);
        vistaJugador.agregarElemento(botonCartaBocaArriba);
        contenedorBase.ubicarObjeto(botonCartaBocaArriba, botonCartaBocaAbajo.obtenerFila(), botonCartaBocaAbajo.obtenerColumna());
        controlador.agregarCartaTrampaMagicaABorrar(botonCartaBocaArriba);
        try {
            cartaMagica.activarEfecto();
        } catch (VictoriaException ignored) {
        }
    }
}
