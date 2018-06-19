package tablero;

import cartas.Carta;
import cartas.CartaMonstruo;
import cartas.Invocacion;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class ZonaMonstruo implements Zona {
    private static final int CANT_CASILLEROS = 5;

    private List<Casillero> casilleros;

    public ZonaMonstruo() {
        casilleros = new ArrayList<>();
        for (int i = 0; i < CANT_CASILLEROS; i++) casilleros.add(new Casillero());
    }

    public boolean colocarCarta(Invocacion invocacion) {
        List<Casillero> vacios = casilleros.stream().filter(casillero -> casillero.estaVacio()).collect(Collectors.toList());
        if (vacios.size() == 0) return false;

        //Devuelve true si pudo colocarla y false si la zona estaba completa}
        try {
            Carta carta = invocacion.invocar();
            vacios.get(0).colocarCarta(carta);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public void eliminarCarta(Carta carta) {
        for (int i = 0; i < 5; i += 1) {
            if (casilleros.get(i).comparar(carta)) {
                casilleros.get(i).borrarCarta();
            }
        }
    }

    public boolean existe(CartaMonstruo unaCarta) {
        for (int i = 0; i < 5; i += 1) {
            if (casilleros.get(i).comparar(unaCarta)) {
                return true;
            }
        }
        return false;
    }

    public void efectoAgujeroNegro(Cementerio unCementerio){
        for (int i = 0; i<5; i+=1) {
            if(!casilleros.get(i).estaVacio()){
                Carta unaCarta = casilleros.get(i).mostrarCarta();
                unCementerio.colocarCarta(unaCarta);
                casilleros.get(i).borrarCarta();
            }
        }

    }

    public boolean estaVacia() {
        for (int i = 0; i<5; i+=1){
            if(!casilleros.get(i).estaVacio()){
                return false;
            }
        }
        return true;
    }

    public List<Casillero> getCasilleros(){
        return this.casilleros;
    }
}