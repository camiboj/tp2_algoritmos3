package modelo.cartas.cartasMonstruo;
import modelo.efectos.Efecto;
import modelo.efectos.EfectoInsectoComeHombres;
import modelo.jugador.Jugador;
import modelo.tablero.Tablero;

public class InsectoComeHombres extends CartaMonstruo implements Efecto {
    EfectoInsectoComeHombres efectoInsectoComeHombres;
    public InsectoComeHombres() {
        super("Insecto Come-Hombres", 450, 600, 2);
        efectoInsectoComeHombres= new EfectoInsectoComeHombres();
    }

    @Override
    public void activarEfecto() {


    }

    @Override
    public void activarEfectoDeVolteoAnteAtaque(Jugador jugadorPoseedor, Jugador jugadorEnemigo, Tablero tablero) {
        efectoInsectoComeHombres.activarEfectoDeVolteoAnteAtaque(jugadorPoseedor,jugadorEnemigo,tablero);
    }


}
