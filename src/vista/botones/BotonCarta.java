package vista.botones;

import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import modelo.cartas.Carta;
import modelo.cartas.cartasMonstruo.CartaMonstruo;
import modelo.excepciones.VictoriaException;
import vista.ContenedorBase;

public abstract class BotonCarta extends Button {

    protected int fila;
    protected int columna;
    protected Carta carta;

    public BotonCarta (Carta carta, int fila, int columna) {
        this.settear(carta);
        this.fila = fila;
        this.columna = columna;
    }

    public void settearTooltip(String info){
        Tooltip tt = new Tooltip(info);
        this.setTooltip(tt);
    }

    public BotonCarta(Carta carta) {
        this.settear(carta);
    }

    public BotonCarta(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }

    public void settear(Carta carta) {
        System.out.println(carta.getNombre());
        String ruta = "/vista/imagenes/" + carta.getNombre() + ".jpg";
        Image image = new Image(getClass().getResourceAsStream(ruta));
        BackgroundSize size = new BackgroundSize(70, 120, true, true, true, false);

        BackgroundImage imagenBoton = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER, size);
        this.setBackground(new Background(imagenBoton));
        this.carta = carta;
        this.setPrefSize(70, 120);
    }

    public void actualizarEstado() throws VictoriaException {
        carta.colocarBocaArriba();
    }

    public void cambiarFila(int fila) {
        this.fila = fila;
    }

    public int obtenerColumna() {
        return columna;
    }

    public int obtenerFila(){
        return  fila;
    }

    public Carta obtenerCarta() {
        return carta;
    }
}
