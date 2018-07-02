package modelo.cartas.cartasMonstruo.cartasBasicas;

import modelo.cartas.cartasMonstruo.CartaMonstruo;
import modelo.cartas.cartasMonstruo.Nivel;
import modelo.estadosDeCartas.Modo;
import modelo.jugador.Punto;

public class OsoPandaFrenetico extends CartaMonstruo {
    private Modo modo;
    private Punto puntosAtaque;
    private Punto puntosDefensa;
    private Nivel nivel;
    //efecto

    public OsoPandaFrenetico() {
        super("Oso Panda Frenetico", 1200, 1000, 4);
        modo = null;
    }
}
