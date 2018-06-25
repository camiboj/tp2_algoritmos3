package efectos;
import cartas.Carta;
import cartas.cartasMonstruo.CartaMonstruo;
import jugador.Jugador;
import tablero.InterrumpirAtaqueException;
import tablero.LadoDelCampo;

import java.util.ArrayList;
import java.util.List;

public class EfectoInsectoComeHombres implements Efecto {

    @Override
    public void activarEfecto() {
    }

    @Override
    public void activarEfectoDeVolteoAnteAtaque(Jugador jugadorPoseedor, Jugador jugadorEnemigo,
                                                LadoDelCampo ladoEnemigo) throws InterrumpirAtaqueException {
        List<CartaMonstruo> monstruos=ladoEnemigo.obtenerMonstruos();
        List<Carta> cartaDestruidasDelAtacantePorElEfecto= new ArrayList<Carta>();
        if (monstruos.size()>0){
            cartaDestruidasDelAtacantePorElEfecto.add( monstruos.get(0));
        }

        throw new InterrumpirAtaqueException(jugadorPoseedor, jugadorEnemigo, cartaDestruidasDelAtacantePorElEfecto);
    }
}