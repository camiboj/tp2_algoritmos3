package modelo.cartas.invocacion;

import modelo.cartas.cartasMonstruo.DragonDefinitivoDeOjosAzules;
import modelo.cartas.cartasMonstruo.cartasBasicas.DragonBlancoDeOjosAzules;
import modelo.tablero.Cementerio;
import modelo.tablero.ZonaMonstruo;

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

