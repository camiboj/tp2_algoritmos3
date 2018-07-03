package modelo.cartas.cartasMagicas;

import modelo.efectos.Efecto;
import modelo.excepciones.VictoriaException;
import modelo.jugador.Jugador;
import modelo.tablero.Tablero;

 public class OllaDeLaCodicia extends CartaMagica implements Efecto {
     Jugador jugador;

    public OllaDeLaCodicia(Jugador unJugador) {
        super("Olla De La Codicia");
        jugador = unJugador;
        this.descripcionEfecto = "Roba dos cartas";
    }

    public void activarEfecto() throws VictoriaException {
        jugador.agarraCartas(2);
    }

     @Override
     public void activarEfectoDeVolteoAnteAtaque(Jugador jugadorPoseedor, Jugador jugadorEnemigo, Tablero tablero) {

     }


 }
