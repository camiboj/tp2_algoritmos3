package modelo.cartas.cartasMagicas;

import modelo.efectos.Efecto;
import modelo.excepciones.VictoriaException;
import modelo.jugador.Jugador;
import modelo.tablero.Tablero;

 public class OllaDeLaCodicia extends CartaMagica implements Efecto {
     Jugador jugador;

    public OllaDeLaCodicia() {
        super("Olla De La Codicia");

    }
    @Override
    public void asignarJugador(Jugador jugador) {
        this.jugador = jugador;
    }
    public void activarEfecto() throws VictoriaException {
        jugador.agarraCartas(2);
    }

     @Override
     public void activarEfectoDeVolteoAnteAtaque(Jugador jugadorPoseedor, Jugador jugadorEnemigo, Tablero tablero) {

     }


 }
