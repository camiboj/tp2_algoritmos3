package vista.botones;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;


import modelo.cartas.cartasCampo.CartaCampo;
import modelo.cartas.cartasMagicas.CartaMagica;
import modelo.cartas.cartasMonstruo.CartaMonstruo;
import modelo.cartas.cartasTrampa.CartaTrampa;
import vista.VistaJugador;


public class BotonCartaMano extends BotonCarta {

    private  BotonCartaMano boton;


    public BotonCartaMano(CartaMonstruo carta, VistaJugador vista){
        super(carta);
        this.boton = this;
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

   public BotonCartaMano(CartaMagica carta, int fila, int columna){
       super(carta, fila, columna); }

    public BotonCartaMano(CartaTrampa carta, int fila, int columna){
        super(carta, fila, columna);
    }

    public BotonCartaMano(CartaCampo carta, int fila, int columna){
        super(carta, fila, columna);
    }
}
