package vista.botones;
import modelo.cartas.cartasCampo.CartaCampo;

public class BotonCartaZonaCampo extends BotonCarta {

    public BotonCartaZonaCampo(CartaCampo carta, int fila, int columna){
        super(carta, fila, columna);
        this.settearTooltip("Efecto: " + carta.obtenerEfecto());
    }
}
