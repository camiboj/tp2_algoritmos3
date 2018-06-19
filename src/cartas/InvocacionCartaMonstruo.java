package cartas;

import java.util.List;

public class InvocacionCartaMonstruo implements Invocacion {

    private CartaMonstruo carta;
    private List<CartaMonstruo> sacrificios;

    public InvocacionCartaMonstruo(CartaMonstruo carta, List<CartaMonstruo> sacrificios) {
        this.carta = carta;
        this.sacrificios = sacrificios;
    }

    @Override
    public Carta invocar() {
        if (carta.puedeInvocarse(sacrificios)) {
            return carta;
        } else {
            throw new RuntimeException("Los sacrificios");
        }
    }

    public List<CartaMonstruo> mostrarCartasASacrificar() {
        return sacrificios;
    }

    public boolean debeSacrificar() {
        return sacrificios.size()>0;
    }
}
