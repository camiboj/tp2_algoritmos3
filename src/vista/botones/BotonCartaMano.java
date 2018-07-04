package vista.botones;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;


import modelo.Fase.FasePreparacion;
import modelo.cartas.cartasCampo.CartaCampo;
import modelo.cartas.cartasMagicas.CartaMagica;
import modelo.cartas.cartasMonstruo.CartaMonstruo;
import modelo.cartas.cartasTrampa.CartaTrampa;
import modelo.excepciones.ZonaMonstruoLlenaException;
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
                vista.ColocarCartaMonstruoEnAtaque(carta, boton, fase);
            }
        });

        MenuItem modoDefensa = new MenuItem("Colocar modo defensa");
        modoDefensa.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                vista.ColocarCartaMonstruoEnDefensa(carta, boton, fase);
            }
        }
        );

        contextMenu.getItems().addAll(modoAtaque,modoDefensa);

        this.setContextMenu(contextMenu);
    }

   public BotonCartaMano(CartaMagica carta, int fila, int columna){
       super(carta, fila, columna);
       this.settearTooltip("Efecto: " + carta.obtenerEfecto());
    }

    public BotonCartaMano(CartaTrampa carta, int fila, int columna){
        super(carta, fila, columna);
        this.settearTooltip("Efecto: " + carta.obtenerEfecto());
    }

    public BotonCartaMano(CartaCampo carta, int fila, int columna){
        super(carta, fila, columna);
        this.settearTooltip("Efecto: " + carta.obtenerEfecto());
    }
}
