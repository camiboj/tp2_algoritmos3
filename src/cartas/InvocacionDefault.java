package cartas;

import java.util.List;

public class InvocacionDefault implements Invocacion {

    private Carta carta;

    public InvocacionDefault(Carta carta) {
        this.carta = carta;
    }

    @Override
    public Carta invocar() {
        return carta;
    }

    public boolean debeSacrificar() { return false; }

    public List<CartaMonstruo> mostrarCartasASacrificar() {
        return null;
    }
}
