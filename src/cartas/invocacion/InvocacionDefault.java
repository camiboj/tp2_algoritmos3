package cartas.invocacion;

import cartas.Carta;

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
