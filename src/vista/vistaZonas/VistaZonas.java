package vista.vistaZonas;

import javafx.scene.Node;
import modelo.excepciones.VictoriaException;
import vista.ContenedorBase;
import vista.botones.BotonCarta;
import vista.botones.BotonCartaBocaAbajo;
import vista.botones.BotonCartaZonaCampo;

import java.util.ArrayList;
import java.util.List;

public abstract class VistaZonas {
    protected ContenedorBase contenedorBase;
    protected List<BotonCarta> elementos;
    protected int fila;

    public VistaZonas(ContenedorBase contenedorBase) {
        this.contenedorBase = contenedorBase;
        elementos = new ArrayList<>();
    }

    public void activar(int fila) {
        this.fila = fila;
        actualizar();
    }

    public void actualizar() {
        for (Node node : elementos) {
            BotonCarta boton = (BotonCarta) node;
            boton.setDisable(false);
            boton.cambiarFila(fila);
            contenedorBase.getChildren().remove(boton);
            contenedorBase.ubicarObjeto(boton, fila, boton.obtenerColumna());
        }
    }

    public void desactivarCartas() {
        for (Node elemento : elementos) {
            BotonCarta botonADesactivar;
            botonADesactivar = (BotonCarta) elemento;
            botonADesactivar.setDisable(true);        }
    }

    public void voltear(BotonCartaBocaAbajo botonCartaBocaAbajo, BotonCarta botonCartaBocaArriba, int i, int columna) {
         elementos.add(botonCartaBocaArriba);
         elementos.remove(botonCartaBocaAbajo);
         contenedorBase.getChildren().remove(botonCartaBocaAbajo);
         contenedorBase.ubicarObjeto(botonCartaBocaArriba, fila, columna);
         try {
             botonCartaBocaArriba.actualizarEstado();
         }
         catch (VictoriaException e) { }
    }
}

