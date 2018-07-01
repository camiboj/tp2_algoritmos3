package efectos;
import cartas.Carta;
import cartas.cartasMonstruo.CartaMonstruo;
import jugador.Jugador;
import tablero.LadoDelCampo;
import tablero.Tablero;

import java.util.ArrayList;
import java.util.List;

public class EfectoInsectoComeHombres implements Efecto {

    @Override
    public void activarEfecto() {
    }

    @Override
    public void activarEfectoDeVolteoAnteAtaque(Jugador jugadorPoseedor, Jugador jugadorEnemigo, Tablero tablero) {
        LadoDelCampo ladoEnemigo= tablero.get(jugadorEnemigo);
        List<CartaMonstruo> monstruos=ladoEnemigo.obtenerMonstruos();
        List<Carta> cartaDestruidasDelAtacantePorElEfecto= new ArrayList<Carta>();
        if (monstruos.size()>0){
            cartaDestruidasDelAtacantePorElEfecto.add( monstruos.get(0));
        }
        for (Carta destruida: cartaDestruidasDelAtacantePorElEfecto){
            tablero.colocarCementerio(destruida,jugadorEnemigo);
            if (destruida instanceof CartaMonstruo)
                tablero.get(jugadorEnemigo).eliminarDeZonaMonstruo((CartaMonstruo) destruida);
        }
    }


}