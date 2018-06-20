package tablero;
import cartas.Carta;
import cartas.Invocacion;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ZonaTrampaMagica implements Zona {
    private static final int CANT_CASILLEROS = 5;
    private List<Casillero> casilleros;

    public ZonaTrampaMagica() {
        casilleros = new ArrayList<>();
        for (int i = 0; i < CANT_CASILLEROS; i++) casilleros.add(new Casillero());
    }

    public void eliminarCarta(Carta carta) {
        return;
    }

    public boolean colocarCarta(Invocacion invocacion) {
        List<Casillero> vacios = casilleros.stream().filter(casillero -> casillero.estaVacio()).collect(Collectors.toList());
        if (vacios.size() == 0) return false; //No hay espacio
        try {
            Carta carta = invocacion.invocar();
            vacios.get(0).colocarCarta(carta);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
