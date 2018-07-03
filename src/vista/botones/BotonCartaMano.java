package vista.botones;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import modelo.cartas.Carta;

import modelo.cartas.cartasCampo.CartaCampo;
import modelo.cartas.cartasMagicas.CartaMagica;
import modelo.cartas.cartasMonstruo.CartaMonstruo;
import modelo.cartas.cartasTrampa.CartaTrampa;
import vista.VistaJugador;


public class BotonCartaMano extends Button implements EventHandler<ActionEvent> {

    private Carta carta;
    private  BotonCartaMano boton;


    public BotonCartaMano(String nombre, CartaMonstruo carta, VistaJugador vista) {
        this.settear(nombre, carta, vista);


        Tooltip tt = new Tooltip("Efecto: " + carta.obtenerEfecto());
        this.setTooltip(tt);
        final ContextMenu contextMenu = new ContextMenu();

        MenuItem modoAtaque = new MenuItem("Colocar modo ataque");
        modoAtaque.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                vista.ColocarCartaMonstruoEnAtaque(carta, boton);
            }
        });

        MenuItem modoDefensa = new MenuItem("Colocar modo defensa");
        modoDefensa.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                vista.ColocarCartaMonstruoEnDefensa(carta, boton);
            }
        });

        contextMenu.getItems().addAll(modoAtaque,modoDefensa);

        this.setContextMenu(contextMenu);


    }

/*    public BotonCartaMano(String nombre, CartaMagica carta, VistaJugador vista) {
        this.settear(nombre, carta, vista);
    }
    public BotonCartaMano(String nombre, CartaTrampa carta, VistaJugador vista) {
        this.settear(nombre, carta, vista);
    }
    public BotonCartaMano(String nombre, CartaCampo carta, VistaJugador vista) {
        this.settear(nombre, carta, vista);
    }*/

    private void settear(String nombre, Carta carta, VistaJugador vista) {
        String ruta = "/vista/imagenes/" + nombre + ".jpg";
        Image image = new Image(getClass().getResourceAsStream(ruta));
        this.boton = this;
        BackgroundSize size = new BackgroundSize(70, 120, true, true, true, false);

        BackgroundImage imagenBoton = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER, size);
        this.setBackground(new Background(imagenBoton));
        this.carta = carta;
        this.setPrefSize(70, 120);
    }

    @Override
    public void handle(ActionEvent event) {







        //stage.show();
    }
}
