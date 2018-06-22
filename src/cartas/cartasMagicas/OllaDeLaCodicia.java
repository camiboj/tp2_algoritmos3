package cartas.cartasMagicas;

import cartas.cartasMagicas.CartaMagica;
import efectos.Efecto;
import jugador.Jugador;
import tablero.Tablero;

 public class OllaDeLaCodicia extends CartaMagica implements Efecto {
     Jugador jugador;

    public OllaDeLaCodicia(Jugador unJugador) {
        super("Olla De La Codicia");
        jugador = unJugador;
    }

    public void activarEfecto() {
        jugador.agarraCartas(2);
    }
}
