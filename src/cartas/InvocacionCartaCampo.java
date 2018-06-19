package cartas;
import jugador.Punto;
import java.util.List;

public class InvocacionCartaCampo extends Invocacion {

    private CartaCampo carta;

    public InvocacionCartaCampo(CartaCampo unaCarta, List<CartaMonstruo> monstruosAtaque,
                                   List<CartaMonstruo> monstruosDefensa) {
        super(unaCarta);
        carta = unaCarta;
    }

    public CartaCampo invocar() {
        return carta;
    }

}
