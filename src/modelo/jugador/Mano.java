package modelo.jugador;
import modelo.cartas.Carta;
import modelo.cartas.cartasMonstruo.exodia.CartaMonstruoExodia;
import modelo.excepciones.VictoriaException;

import java.util.*;

public class Mano {
    private List<Carta> cartas;

    public Mano() {
        cartas = new ArrayList<>();
    }

    public List<Carta> mostrarCartas() {
        return cartas;
    }

    public void agregarCarta(Carta carta) throws VictoriaException {
        cartas.add(carta);
        if(sonTodasExodia()){
            throw new VictoriaException(new String("Se Convoca a Exodia!!"));

        }
    }

    public int obtenerCantidad() {
        return cartas.size();
    }

    public void sacar(Carta carta) {
        cartas.remove(carta);
    }

    public boolean sonTodasExodia() {
        Set<CartaMonstruoExodia> piezasDeExodia= new HashSet<CartaMonstruoExodia>();
        for (Carta carta: cartas) {
           if( carta instanceof CartaMonstruoExodia){
                piezasDeExodia.add((CartaMonstruoExodia)carta);
           }

        }
        if (piezasDeExodia.size()==5)
        return true;
        else return false;
    }
}
