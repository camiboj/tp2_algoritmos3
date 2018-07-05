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

    public ActivarMagicaBocaArribaHandler(BotonCartaZonaTrampaMagica boton, Controlador controlador) {
        this.cartaMagica = (CartaMagica) boton.obtenerCarta();
        this.boton = boton;
        this.controlador = controlador;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        try {
            controlador.agregarCartaMagicaABorrar(boton);
            cartaMagica.activarEfecto();
        } catch (VictoriaException e) {

        }
    }
}
