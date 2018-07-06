package vista.handler;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.cartas.cartasMagicas.CartaMagica;
import modelo.excepciones.VictoriaException;
import vista.ContenedorBase;
import vista.Controlador;
import vista.botones.BotonCartaZonaTrampaMagica;

public class ActivarMagicaBocaArribaHandler implements EventHandler<ActionEvent> {
    private Controlador controlador;
    private BotonCartaZonaTrampaMagica boton;
    CartaMagica cartaMagica;
    private ContenedorBase contenedorBase;

    public ActivarMagicaBocaArribaHandler(BotonCartaZonaTrampaMagica boton, Controlador controlador,
                                          ContenedorBase contenedorBase) {
        this.cartaMagica = (CartaMagica) boton.obtenerCarta();
        this.boton = boton;
        this.controlador = controlador;
        this.contenedorBase = contenedorBase;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        try {
            contenedorBase.escribirEnConsola("Has activado una Carta Mágica. Recuerda que en el siguiente turno" +
                    " va a desaparecer.");
            controlador.agregarCartaTrampaMagicaABorrar(boton);
            cartaMagica.colocarBocaArriba();
            controlador.actualizarZonaMonstruo();
            controlador.actualizarMano();
        } catch (VictoriaException e) {
            contenedorBase.escribirEnConsola("Ha terminado el juego. Felictaciones al ganador!");
        }
    }
}
