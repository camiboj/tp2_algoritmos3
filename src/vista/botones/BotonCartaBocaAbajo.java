package vista.botones;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import modelo.cartas.Carta;

public class BotonCartaBocaAbajo extends BotonCarta {

    private BotonCartaZonaTrampaMagica botonCartaBocaArriba;

    public BotonCartaBocaAbajo(int fila, int columna, BotonCartaZonaTrampaMagica botonCartaBocaArriba) {
        super(fila, columna);
        this.graficar();
        this.botonCartaBocaArriba = botonCartaBocaArriba;
    }

    @Override
    public Carta obtenerCarta() {
        return botonCartaBocaArriba.obtenerCarta();
    }

    public BotonCartaBocaAbajo(int fila, int columna){
        super(fila, columna);
        this.graficar();
    }



    private void graficar() {
        Image image = new Image(getClass().getResourceAsStream("/vista/imagenes/cartaAtras.jpg"));
        BackgroundSize size = new BackgroundSize(70, 120, true, true, true, false);

        BackgroundImage imagenBoton = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER, size);
        this.setBackground(new Background(imagenBoton));
        this.setPrefSize(70, 120);
    }

    public BotonCartaZonaTrampaMagica obtenerBotonBocaArriba() {
        return botonCartaBocaArriba;
    }
}