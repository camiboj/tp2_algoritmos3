package cartas.cartasMonstruo.cartasBasicas;

import cartas.cartasMonstruo.CartaMonstruo;
import cartas.cartasMonstruo.Nivel;
import estadosDeCartas.Modo;
import jugador.Punto;

public class DragonNegroDeOjosRojos extends CartaMonstruo {
    private Modo modo;
    private Punto puntosAtaque;
    private Punto puntosDefensa;
    private Nivel nivel;
    //efecto

    public DragonNegroDeOjosRojos() {
        super("Dragon Negro De Ojos Rojos", 2400, 2000, 7);
        modo = null;
    }
}
