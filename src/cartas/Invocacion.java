package cartas;

public abstract class Invocacion {
    protected Carta carta;

    public Invocacion(Carta unaCarta) {
        carta = unaCarta;
    }

    public Carta invocar () { return carta; }
}
