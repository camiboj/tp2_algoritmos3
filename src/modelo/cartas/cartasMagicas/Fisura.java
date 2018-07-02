package modelo.cartas.cartasMagicas;

import modelo.efectos.Efecto;
import modelo.jugador.Jugador;
import modelo.tablero.LadoDelCampo;
import modelo.tablero.Tablero;

public class Fisura extends CartaMagica implements Efecto {
    private final LadoDelCampo ladoDelCampoOponente;

    public Fisura(LadoDelCampo unLadoDelCampoOponente) {
        super("Fisura");
        ladoDelCampoOponente = unLadoDelCampoOponente;
    }

    public void activarEfecto(){
        ladoDelCampoOponente.eliminarMonstruoDebil();
    }

    @Override
    public void activarEfectoDeVolteoAnteAtaque(Jugador jugadorPoseedor, Jugador jugadorEnemigo, Tablero tablero) {

    }


}
