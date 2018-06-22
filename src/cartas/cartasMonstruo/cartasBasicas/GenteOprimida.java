package cartas.cartasMonstruo.cartasBasicas;

import cartas.cartasMonstruo.CartaMonstruo;
import cartas.cartasMonstruo.Nivel;
import estadosDeCartas.Modo;
import jugador.Punto;

public class GenteOprimida extends CartaMonstruo {
    private Modo modo;
    private Punto puntosAtaque;
    private Punto puntosDefensa;
    private Nivel nivel;
    //efecto

    public GenteOprimida() {
        super("Gente Oprimida", 400, 2000, 1);
        modo = null;
    }
}
