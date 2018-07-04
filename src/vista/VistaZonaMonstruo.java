package vista;
import javafx.scene.Node;
import javafx.scene.control.ContextMenu;
import modelo.cartas.cartasMonstruo.CartaMonstruo;
import modelo.excepciones.VictoriaException;
import modelo.tablero.ZonaMonstruo;
import vista.botones.BotonCarta;
import vista.botones.BotonCartaBocaAbajo;
import vista.botones.BotonCartaZonaMonstruo;
import vista.handler.VoltearHandler;

import java.util.ArrayList;
import java.util.List;

public class VistaZonaMonstruo {
    protected ZonaMonstruo zonaMonstruo;
    protected ContenedorBase contenedorBase;
    protected int fila;
    protected List<Node> elementos;

    public VistaZonaMonstruo (ZonaMonstruo zonaMonstruo, ContenedorBase contenedorBase) {
        this.zonaMonstruo = zonaMonstruo;
        this.contenedorBase = contenedorBase;
        this.elementos = new ArrayList<>();
    }

    public void activar(int fila) {
        this.fila = fila;
        actualizar();
    }

    private void actualizar() {
        for(Node node : elementos) {
            BotonCarta boton = (BotonCarta) node;
            boton.cambiarFila(fila);
            contenedorBase.getChildren().remove(boton);
            contenedorBase.ubicarObjeto(boton, fila, boton.obtenerColumna());
        }
    }

    public void colocarCartaModoDefensa(CartaMonstruo carta, int columna) {
        BotonCartaZonaMonstruo botonCartaBocaArriba = new BotonCartaZonaMonstruo(carta, fila, columna);
        botonCartaBocaArriba.setRotate(90);
        BotonCartaBocaAbajo botonCartaBocaAbajo = new BotonCartaBocaAbajo(fila, columna);
        VoltearHandler handle = new VoltearHandler(botonCartaBocaArriba, botonCartaBocaAbajo, this);
        botonCartaBocaAbajo.setOnAction(handle);
        botonCartaBocaAbajo.setRotate(90);
        elementos.add(botonCartaBocaAbajo);
        contenedorBase.ubicarObjeto(botonCartaBocaAbajo, fila, columna);
    }

    public void colocarCartaModoAtaque(CartaMonstruo carta, int columna) {
        BotonCartaZonaMonstruo botonCartaBocaArriba = new BotonCartaZonaMonstruo(carta, fila, columna);
        BotonCartaBocaAbajo botonCartaBocaAbajo = new BotonCartaBocaAbajo(fila, columna);
        VoltearHandler handle = new VoltearHandler(botonCartaBocaArriba, botonCartaBocaAbajo, this);
        botonCartaBocaAbajo.setOnAction(handle);
        elementos.add(botonCartaBocaAbajo);
        contenedorBase.ubicarObjeto(botonCartaBocaAbajo, fila, columna);
    }

    public void voltear(BotonCartaBocaAbajo botonCartaBocaAbajo, BotonCarta botonCartaBocaArriba, int fila, int columna) {
        elementos.add(botonCartaBocaArriba);
        elementos.remove(botonCartaBocaAbajo);
        contenedorBase.getChildren().remove(botonCartaBocaAbajo);
        contenedorBase.ubicarObjeto(botonCartaBocaArriba, fila, columna);
        try {
            botonCartaBocaArriba.actualizarEstado();
        } catch (VictoriaException e) {
        }
    }

    public void setOpcionAtacar(ContextMenu contextMenu) {
        for (Node botonCarta : elementos) {
            if (botonCarta instanceof BotonCartaZonaMonstruo) {
                BotonCartaZonaMonstruo boton = (BotonCartaZonaMonstruo) botonCarta;
                boton.setContextMenu(contextMenu);
            }
            else {
                BotonCartaBocaAbajo boton = (BotonCartaBocaAbajo) botonCarta;
                boton.setDisable(true);
            }
        }
    }
}
