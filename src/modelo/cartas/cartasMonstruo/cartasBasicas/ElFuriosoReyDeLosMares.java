package modelo.cartas.cartasMonstruo.cartasBasicas;

import modelo.cartas.cartasMonstruo.CartaMonstruo;
import modelo.cartas.cartasMonstruo.Nivel;
import modelo.estadosDeCartas.Modo;
import modelo.jugador.Punto;

public class ElFuriosoReyDeLosMares extends CartaMonstruo {
    private Modo modo;
    private Punto puntosAtaque;
    private Punto puntosDefensa;
    private Nivel nivel;
    //efecto

    public ElFuriosoReyDeLosMares() {
        super("El Furioso Rey De Los Mares", 800, 700, 3);
        modo = null;
    }
}
