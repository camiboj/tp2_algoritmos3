package cartas.cartasMagicas;

import efectos.Efecto;
import excepciones.VictoriaException;
import jugador.Jugador;
import tablero.Tablero;

 public class OllaDeLaCodicia extends CartaMagica implements Efecto {
     Jugador jugador;

    public OllaDeLaCodicia(Jugador unJugador) {
        super("Olla De La Codicia");
        jugador = unJugador;
    }

    public void activarEfecto() throws VictoriaException {
        jugador.agarraCartas(2);
    }

     @Override
     public void activarEfectoDeVolteoAnteAtaque(Jugador jugadorPoseedor, Jugador jugadorEnemigo, Tablero tablero) {

     }


 }
