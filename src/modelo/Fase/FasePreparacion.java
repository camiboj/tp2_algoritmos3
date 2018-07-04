package modelo.Fase;

import modelo.cartas.cartasMonstruo.CartaMonstruo;
import modelo.excepciones.VictoriaException;
import modelo.jugador.Jugador;

public class FasePreparacion implements Fase {
    private boolean invocacion;

    public FasePreparacion() {
        invocacion = true;
    }

    @Override
    public void finFase() {
        //Puede colocar cartasTrampa y de magia pero 1 monstruo. Como hacer esto? modelo.Fase conoce a Tablero?
    }

    @Override
    public void ejecutarFase() throws VictoriaException {

    }

    public boolean validarMonstruo() {
        boolean aux = invocacion;
        invocacion = false;
        return aux;
    }
}
