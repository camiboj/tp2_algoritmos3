package cartas.cartasMonstruo;
import cartas.Carta;
import efectos.Efecto;
import efectos.EfectoInsectoComeHombres;
import jugador.Jugador;
import jugador.Punto;
import tablero.InterrumpirAtaqueException;
import tablero.LadoDelCampo;

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
    public void activarEfectoDeVolteoAnteAtaque(Jugador jugadorPoseedor, Jugador jugadorEnemigo, LadoDelCampo ladoEnemigo) throws InterrumpirAtaqueException {
        efectoInsectoComeHombres.activarEfectoDeVolteoAnteAtaque(jugadorPoseedor,jugadorEnemigo,ladoEnemigo);
    }
}
