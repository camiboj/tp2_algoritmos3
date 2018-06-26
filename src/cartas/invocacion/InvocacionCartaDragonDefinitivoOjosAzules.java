package cartas.invocacion;

import cartas.cartasMonstruo.CartaMonstruo;
import cartas.cartasMonstruo.DragonDefinitivoDeOjosAzules;
import cartas.cartasMonstruo.cartasBasicas.DragonBlancoDeOjosAzules;
import tablero.Cementerio;
import tablero.ZonaMonstruo;

import java.util.List;

public class InvocacionCartaDragonDefinitivoOjosAzules extends InvocacionCartaMonstruo {
    List<DragonBlancoDeOjosAzules> sacrificios;

    public InvocacionCartaDragonDefinitivoOjosAzules(DragonDefinitivoDeOjosAzules unaCarta, List<DragonBlancoDeOjosAzules> sacrificios) {
        super(unaCarta, sacrificios);
        carta = unaCarta;
        this.sacrificios = sacrificios;
    }

    public void sacrificar(Cementerio cementerio, ZonaMonstruo zonaMonstruo) {
        if (sacrificios==null) return;
        for (DragonBlancoDeOjosAzules carta : sacrificios) {
            zonaMonstruo.eliminarCarta(carta);
            cementerio.colocarCarta(carta);
        }
    }
}

