package modelo.cartas.cartasCampo;

import modelo.jugador.Punto;
import modelo.tablero.ZonaMonstruo;

public class Wasteland extends CartaCampo {

    public Wasteland() {
        super("Wasteland", new Punto(200),
                    new Punto(300));
        this.descripcionEfecto = "Aumenta el ATK y el DEF de todos los Dinosarios, Zombies y Rocosos " +
                "monstruos en 200 puntos ";
    }

    @Override
    public void activarEfecto() {
        this.zonaMonstruoPropia.aumentarAtaque(puntosAdicionalesAtaque);
        this.zonaMonstruoOponente.aumentarDefensa(puntosAdicionalesDefensa);
    }
}





