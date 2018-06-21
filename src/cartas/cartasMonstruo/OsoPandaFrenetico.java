package cartas.cartasMonstruo;

import estadosDeCartas.Modo;
import jugador.Punto;

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
