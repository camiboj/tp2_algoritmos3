package cartas.cartasMonstruo;

import cartas.cartasMonstruo.CartaMonstruo;
import estadosDeCartas.Modo;
import jugador.Punto;

public class EscorpionDemonio extends CartaMonstruo {
    private Modo modo;
    private Punto puntosAtaque;
    private Punto puntosDefensa;
    private Nivel nivel;
    //efecto

    public EscorpionDemonio() {
    super("Escorpion Demonio",  900, 200, 2);
        modo = null;
    }
}
