package cartas.cartasMagicas;

import cartas.cartasMagicas.CartaMagica;
import efectos.Efecto;
import jugador.Jugador;
import tablero.InterrumpirAtaqueException;
import tablero.LadoDelCampo;
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

     @Override
     public void activarEfectoDeVolteoAnteAtaque(Jugador jugadorPoseedor, Jugador jugadorEnemigo, LadoDelCampo ladoEnemigo) throws InterrumpirAtaqueException {
         //no posee este efecto por lo que no hara nada si
     }
 }
