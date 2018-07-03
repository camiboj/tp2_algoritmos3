package modelo.cartas.cartasCampo;

import modelo.jugador.Punto;
import modelo.tablero.ZonaMonstruo;

public class Sogen extends CartaCampo {

    public Sogen(ZonaMonstruo unaZonaMonstruoAtacante, ZonaMonstruo unaZonaMonstruoPropia) {
        super("Sogen", unaZonaMonstruoPropia, unaZonaMonstruoAtacante, new Punto(200),
                new Punto(500));
        this.descripcionEfecto = "Aumenta el ATK y el DEF de todos los monstruos. " +
                "Tipo Guerrero y Guerrero Bestia en 200 puntos";
    }

    @Override
    public void activarEfecto() {
        this.zonaMonstruoPropia.aumentarDefensa(puntosAdicionalesDefensa);
        this.zonaMonstruoOponente.aumentarAtaque(puntosAdicionalesAtaque);
    }
}
