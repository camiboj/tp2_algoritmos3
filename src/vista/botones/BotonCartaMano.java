package vista.botones;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.control.MenuItem;


import modelo.Fase.FasePreparacion;
import modelo.cartas.Carta;
import modelo.cartas.cartasCampo.CartaCampo;
import modelo.cartas.cartasMagicas.CartaMagica;
import modelo.cartas.cartasMonstruo.CartaMonstruo;
import modelo.cartas.cartasTrampa.CartaTrampa;
import vista.VistaJugador;

public class BotonCartaMano extends BotonCarta {

    private  BotonCartaMano boton;
    private FasePreparacion fase;

    public BotonCartaMano(CartaMonstruo carta, VistaJugador vista, FasePreparacion fase){
        super(carta);
        this.fase = fase;
        this.boton = this;
        this.settearTooltip("Efecto: " + carta.obtenerEfecto() +
                            "\n ATK: " + String.valueOf(carta.obtenerPuntosAtaque().obtenerNumero()) +
                            "\n DEF: " + String.valueOf(carta.obtenerPuntosDefensa().obtenerNumero()));

        final ContextMenu contextMenu = new ContextMenu();

        MenuItem modoAtaque = new MenuItem("Colocar modo ataque");
        modoAtaque.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                vista.colocarCartaMonstruoEnAtaque(carta, boton, fase);
            }
        });

        MenuItem modoDefensa = new MenuItem("Colocar modo defensa");
        modoDefensa.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                vista.colocarCartaMonstruoEnDefensa(carta, boton, fase);
            }
        }
        );

        contextMenu.getItems().addAll(modoAtaque,modoDefensa);

        this.setContextMenu(contextMenu);
    }

   public BotonCartaMano(Carta carta){
       super(carta);
       this.settearTooltip("Efecto: " + carta.obtenerEfecto());
    }

    public BotonCartaMano(CartaTrampa carta, VistaJugador vista){
        super(carta);this.settearTooltip("Efecto: " + carta.obtenerEfecto());
        final ContextMenu contextMenu = new ContextMenu();

        MenuItem colocarCarta= new MenuItem("Colocar carta trampa boca abajo");
        colocarCarta.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                vista.colocarCartaTrampaMagica(carta, boton);
            }
        });
    }

    public BotonCartaMano(CartaMagica carta, VistaJugador vista){
        super(carta);
        this.settearTooltip("Efecto: " + carta.obtenerEfecto());
        final ContextMenu contextMenu = new ContextMenu();

        MenuItem colocarCarta= new MenuItem("Colocar carta mágica boca abajo");
        colocarCarta.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                vista.colocarCartaTrampaMagica(carta, boton);
            }
        });
    }

    public BotonCartaMano(CartaCampo carta, VistaJugador vista){
        super(carta);
        this.settearTooltip("Efecto: " + carta.obtenerEfecto());
        final ContextMenu contextMenu = new ContextMenu();

        MenuItem colocarCarta= new MenuItem("Colocar carta campo boca abajo");
        colocarCarta.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                vista.colocarCartaCampo(carta, boton);
            }
        });
    }

}
