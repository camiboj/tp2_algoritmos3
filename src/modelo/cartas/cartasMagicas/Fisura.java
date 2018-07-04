package modelo.cartas.cartasMagicas;

import modelo.efectos.Efecto;
import modelo.jugador.Jugador;
import modelo.tablero.LadoDelCampo;
import modelo.tablero.Tablero;

public class Fisura extends CartaMagica implements Efecto {
    private LadoDelCampo ladoDelCampoOponente;
    private Jugador jugadorPoseedor;
    private  Tablero tablero;
    public Fisura() {
        super("Fisura");
        this.descripcionEfecto = "Destruye el monstruo boca arriba con ATK mas bajo que controle tu adversario";
    }

    public void activarEfecto(){
        ladoDelCampoOponente.eliminarMonstruoDebil();
    }

    @Override
    public void asignarJugador(Jugador jugador){
        jugadorPoseedor=jugador;
        if (tablero!=null){
            ladoDelCampoOponente=tablero.get(tablero.obtenerJugadorOponente(jugadorPoseedor));
        }
    }
    @Override
    public void asignarTablero(Tablero tablero){
        this.tablero=tablero;
        if (jugadorPoseedor!=null){
            ladoDelCampoOponente=tablero.get(tablero.obtenerJugadorOponente(jugadorPoseedor));
        }
    }
    @Override
    public void activarEfectoDeVolteoAnteAtaque(Jugador jugadorPoseedor, Jugador jugadorEnemigo, Tablero tablero) {

    }


}
