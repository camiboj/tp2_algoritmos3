package vista.botones;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class BotonCartaBocaAbajo extends BotonCarta {

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

}