package cartas;

import java.util.List;

public class InvocacionDefault extends Invocacion {

    private Carta carta;

    public InvocacionDefault(Carta unaCarta) {
        super(unaCarta);
        carta = unaCarta;
    }

    public Carta invocar() {
        return carta;
    }
}
