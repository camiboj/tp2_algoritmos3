package modelo.cartas.invocacion;

import modelo.Fase.Fase;
import modelo.Fase.FasePreparacion;
import modelo.cartas.cartasMonstruo.CartaMonstruo;
import modelo.tablero.Cementerio;
import modelo.tablero.ZonaMonstruo;

import java.util.ArrayList;
import java.util.List;

public class InvocacionCartaMonstruoGenerica extends InvocacionCartaMonstruo {

    public InvocacionCartaMonstruoGenerica(CartaMonstruo unaCarta, List<CartaMonstruo> sacrificios, FasePreparacion fase) {
        super(unaCarta, sacrificios, fase);
        carta = unaCarta;
        this.sacrificios = sacrificios;
    }

    public InvocacionCartaMonstruoGenerica(CartaMonstruo unaCarta, FasePreparacion fase) {
        super(unaCarta, new ArrayList<>(), fase);
        carta = unaCarta;
    }

    public void sacrificar(Cementerio cementerio, ZonaMonstruo zonaMonstruo) {
        if (sacrificios==null) return;
        for (CartaMonstruo carta : sacrificios) {
            zonaMonstruo.eliminarCarta(carta);
            cementerio.colocarCarta(carta);
        }
    }
}
