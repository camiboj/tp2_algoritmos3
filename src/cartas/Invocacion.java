package cartas;

import java.util.List;

public interface Invocacion {
    Carta invocar();
    boolean debeSacrificar();
    List<CartaMonstruo> mostrarCartasASacrificar();
}
