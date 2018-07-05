package vista.handler;

import javafx.event.Event;
import javafx.event.EventHandler;
import modelo.excepciones.AtacarMasDeUnoExcepcion;
import modelo.excepciones.CartaAtacanteInexistenteException;
import modelo.excepciones.CartaDefensoraInexistenteException;
import vista.CheckBoxCarta;
import vista.ContenedorBase;
import vista.ContextMenuAtacante;
import vista.Controlador;
import vista.botones.BotonCartaZonaMonstruo;

import java.util.ArrayList;

public class BotonAtacarHandler implements EventHandler {
    
    private final ArrayList<CheckBoxCarta> checks;
    private final ContenedorBase contenedorBase;
    private final Controlador controlador;
    private final BotonCartaZonaMonstruo botonMonstruoAtacante;

    public BotonAtacarHandler(ArrayList<CheckBoxCarta> checks, ContenedorBase contenedorBase, Controlador controlador,
                              ContextMenuAtacante contextMenuAtacante) {
        this.checks = checks;
        this.contenedorBase = contenedorBase;
        this.controlador = controlador;
        this.botonMonstruoAtacante = contextMenuAtacante.obtenerBotonAtacante();
    }

    @Override
    public void handle(Event event) {
        int contador = 0;
        CheckBoxCarta seleccionado = null;
        for (CheckBoxCarta box : checks) {
            if (box.isSelected()) {
                seleccionado = box;
                contador ++;}
        }
        if (contador == 1) {
            try {
                controlador.atacarMonstruos(botonMonstruoAtacante, seleccionado.obtenerBotonCarta());
            }
            catch (CartaAtacanteInexistenteException | CartaDefensoraInexistenteException e){
                contenedorBase.escribirEnConsola(e.obtenerMotivo());
                }


            botonMonstruoAtacante.setDisable(true);
            controlador.iniciarFaseTrampa();
        }
        if (contador != 1) {
            try {
                throw new AtacarMasDeUnoExcepcion("Se puede atacar únicamente un monstruo. Intentelo nuevamente");
            } catch (AtacarMasDeUnoExcepcion atacarMasDeUnoExcepcion) {
                contenedorBase.escribirEnConsola(atacarMasDeUnoExcepcion.obtenerMotivo());
            }
        }
        for (CheckBoxCarta box : checks) {
            contenedorBase.getChildren().remove(box);
        }


    }
}
