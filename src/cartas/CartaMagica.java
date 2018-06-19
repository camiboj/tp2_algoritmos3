package cartas;
import efectos.Efecto;

public abstract class CartaMagica extends Carta {
    protected Efecto efecto;

    public CartaMagica(String unNombre) {
        super(unNombre);
    }

    @Override
    public void activarEfecto() {
        super.activarEfecto();
    }
}
