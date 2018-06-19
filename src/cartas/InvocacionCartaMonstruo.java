package cartas;

import java.util.List;

public class InvocacionCartaMonstruo extends Invocacion {

    private CartaMonstruo carta;
    private List<CartaMonstruo> sacrificios;

    public InvocacionCartaMonstruo(CartaMonstruo unaCarta, List<CartaMonstruo> sacrificios) {
        super(unaCarta);
        carta = unaCarta;
        this.sacrificios = sacrificios;
    }

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
        if (sacrificios== null) return false;
        return sacrificios.size()>0;
    }
}
