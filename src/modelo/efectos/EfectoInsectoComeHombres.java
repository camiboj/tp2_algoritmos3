package modelo.efectos;
import modelo.cartas.Carta;
import modelo.jugador.Jugador;
import modelo.tablero.LadoDelCampo;
import modelo.tablero.Tablero;

import java.util.ArrayList;
import java.util.List;

public class EfectoInsectoComeHombres implements Efecto {

    @Override
    public void activarEfecto() {
    }

    @Override
    public void activarEfectoDeVolteoAnteAtaque(Jugador jugadorPoseedor, Jugador jugadorEnemigo, Tablero tablero) {
        LadoDelCampo ladoEnemigo= tablero.get(jugadorEnemigo);
        List<modelo.cartas.cartasMonstruo.CartaMonstruo> monstruos=ladoEnemigo.obtenerMonstruos();
        List<Carta> cartaDestruidasDelAtacantePorElEfecto= new ArrayList<Carta>();
        if (monstruos.size()>0){
            cartaDestruidasDelAtacantePorElEfecto.add( monstruos.get(0));
        }
        for (Carta destruida: cartaDestruidasDelAtacantePorElEfecto){
            tablero.colocarCementerio(destruida,jugadorEnemigo);
            if (destruida instanceof modelo.cartas.cartasMonstruo.CartaMonstruo)
                tablero.get(jugadorEnemigo).eliminarDeZonaMonstruo((modelo.cartas.cartasMonstruo.CartaMonstruo) destruida);
        }
    }


}