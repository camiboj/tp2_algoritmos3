package tablero;
public class ZonaTrampaMagica extends Zona {
    private Casillero[] casilleros;

    public ZonaTrampaMagica () {
        casilleros = new Casillero[5];
        for (int i = 0; i < 5; i += 1) {
            casilleros[i] = new Casillero();
        }
    }
}
