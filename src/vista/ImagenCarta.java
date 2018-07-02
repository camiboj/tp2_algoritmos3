package vista;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modelo.cartas.Carta;

public class ImagenCarta {
    private final ImageView imageView;
    Carta carta;

    public ImagenCarta(String ruta, Carta carta) {
        String rutaFinal = "vista/imagenes/" + ruta + ".jpg";
        Image imagen = new Image(rutaFinal);
        this.imageView = new ImageView(imagen);
        this.carta = carta;
    }

    public ImageView obtenerVistaImagen() {
        return imageView;
    }

}
