package cartas.cartasMagicas;

import cartas.cartasMagicas.CartaMagica;
import efectos.Efecto;
import jugador.Jugador;
import tablero.LadoDelCampo;
import tablero.Tablero;

public class Fisura extends CartaMagica implements Efecto {
    private final LadoDelCampo ladoDelCampoOponente;

    public Fisura(LadoDelCampo unLadoDelCampoOponente) {
        super("Fisura");
        ladoDelCampoOponente = unLadoDelCampoOponente;
    }

    public void activarEfecto(){
        ladoDelCampoOponente.eliminarMonstruoDebil();
    }

}
