package tablero;
import cartas.*;
import cartas.cartasCampo.CartaCampo;
import cartas.cartasMonstruo.CartaMonstruo;
import cartas.invocacion.Invocacion;
import cartas.invocacion.InvocacionCartaCampo;

import java.util.ArrayList;
import java.util.List;

public class ZonaCampo implements Zona{ //Le saque la interfaz porque no coloca una carta cualquiera, esa carta activa efecto
    private Casillero casillero; //Ceci: entiendo que hay una carta en el tablero

    public ZonaCampo() {
        casillero = new Casillero();
    }

        public boolean colocarCarta(Invocacion invocacion) {
        //Devuelve true si pudo colocarla y false si la zona estaba completa
        if (casillero.estaVacio()) {
            Carta carta = invocacion.invocar();
            carta.activarEfecto();
            casillero.colocarCarta(carta);
            return true;
        }
        return false;
    }

    public List<Casillero> obtenerCasilleros() {
        List<Casillero> casilleros = new ArrayList<>();
        casilleros.add(casillero);
        return casilleros;
    }

    public void eliminarCarta(Carta carta) {
        return;
    }
}
