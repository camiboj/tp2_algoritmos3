package vista.vistaZonas;
import javafx.scene.Node;
import modelo.cartas.cartasCampo.CartaCampo;
import modelo.tablero.ZonaCampo;
import vista.botones.BotonCarta;
import vista.botones.BotonCartaZonaCampo;
import vista.ContenedorBase;

import java.util.ArrayList;
import java.util.List;

public class VistaCampo {
    protected List<BotonCarta> elementos;
    protected ZonaCampo zonaCampo;
     protected ContenedorBase contenedorBase;
     private int fila;
    private int columna;

    public VistaCampo(ZonaCampo zonaCampo, ContenedorBase contenedorBase) {
         this.zonaCampo = zonaCampo;
         this.contenedorBase = contenedorBase;
         elementos = new ArrayList<>();
     }

    public void activar(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
        actualizar();
    }

    public void actualizar() {
        for (Node node : elementos) {
            BotonCarta boton = (BotonCarta) node;
            boton.cambiarFila(fila);
            contenedorBase.getChildren().remove(boton);
            contenedorBase.ubicarObjeto(boton, fila, columna);
        }
    }

     public void colocarCarta(CartaCampo carta) {
         BotonCartaZonaCampo botonCartaZonaCampo = new BotonCartaZonaCampo(carta, fila, columna);
         elementos.add(botonCartaZonaCampo);
         contenedorBase.ubicarObjeto(botonCartaZonaCampo, fila, columna);
    }


    public void desactivarCartas() {
        for (Node elemento : elementos) {
            BotonCartaZonaCampo botonADesactivar;
            botonADesactivar = (BotonCartaZonaCampo) elemento;
            botonADesactivar.setDisable(true);
        }
    }

}
