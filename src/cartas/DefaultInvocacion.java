package cartas;

public class DefaultInvocacion implements Invocacion {

    private Carta carta;

    public DefaultInvocacion(Carta carta) {
        this.carta = carta;
    }

    @Override
    public Carta invocar() {
        return carta;
    }
}
