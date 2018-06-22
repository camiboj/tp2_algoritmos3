package cartas.cartasMonstruo.cartasBasicas;

import cartas.cartasMonstruo.CartaMonstruo;
import cartas.cartasMonstruo.Nivel;
import estadosDeCartas.Modo;
import jugador.Punto;

public class SirvienteDeLaCalavera extends CartaMonstruo {
    private Modo modo;
    private Punto puntosAtaque;
    private Punto puntosDefensa;
    private Nivel nivel;
    //efecto

    public SirvienteDeLaCalavera() {
        super("Sirviente De La Calavera", 300, 200, 1);
        modo = null;
    }
}
