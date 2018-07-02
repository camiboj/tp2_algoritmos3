package modelo.cartas.cartasMonstruo.cartasBasicas;

import modelo.cartas.cartasMonstruo.CartaMonstruo;
import modelo.cartas.cartasMonstruo.Nivel;
import modelo.estadosDeCartas.Modo;
import modelo.jugador.Punto;

public class Seiyaryu extends CartaMonstruo {
    private Modo modo;
    private Punto puntosAtaque;
    private Punto puntosDefensa;
    private Nivel nivel;
    //efecto

    public Seiyaryu() {
        super("Seiyaryu", 2500, 2300, 7);
        modo = null;
    }
}
