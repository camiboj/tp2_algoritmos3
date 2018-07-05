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
import vista.vistaZonas.VistaTrampaMagica;

public class ActivarMagicaBocaAbajoHandler implements EventHandler<ActionEvent> {
    private Controlador controlador;
    protected VistaTrampaMagica vistaTrampaMagica;
    protected BotonCartaBocaAbajo botonCartaBocaAbajo;
    protected BotonCartaZonaTrampaMagica botonCartaBocaArriba;
    protected CartaMagica cartaMagica;
    protected ContenedorBase contenedorBase;

    public ActivarMagicaBocaAbajoHandler(Controlador controlador,
                                         VistaTrampaMagica vistaTrampaMagica, BotonCartaBocaAbajo botonCartaBocaAbajo,
                                         BotonCartaZonaTrampaMagica botonBocaArriba, ContenedorBase contenedorBase) {

        this.botonCartaBocaAbajo = botonCartaBocaAbajo;
        this.botonCartaBocaArriba = botonBocaArriba;
        this.vistaTrampaMagica = vistaTrampaMagica;
        this.cartaMagica = (CartaMagica) botonBocaArriba.obtenerCarta();
        this.contenedorBase = contenedorBase;
        this.controlador = controlador;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        contenedorBase.escribirEnConsola("Has activado una Carta Mágica. Recuerda que en el siguiente turno" +
                " va a desaparecer.");
        vistaTrampaMagica.eliminarBoton(botonCartaBocaAbajo);
        contenedorBase.getChildren().remove(botonCartaBocaAbajo);
        vistaTrampaMagica.agregarBoton(botonCartaBocaArriba);
        contenedorBase.ubicarObjeto(botonCartaBocaArriba, botonCartaBocaAbajo.obtenerFila(), botonCartaBocaAbajo.obtenerColumna());
        controlador.agregarCartaTrampaMagicaABorrar(botonCartaBocaArriba);
        try {
            cartaMagica.colocarBocaArriba();
            controlador.actualizarZonaMonstruo();
            controlador.actualizarMano();
        } catch (VictoriaException ignored) {
        }
    }
}
