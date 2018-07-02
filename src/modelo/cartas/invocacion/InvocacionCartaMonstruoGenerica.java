package modelo.cartas.invocacion;

import modelo.cartas.cartasMonstruo.CartaMonstruo;
import modelo.tablero.Cementerio;
import modelo.tablero.ZonaMonstruo;

import java.util.ArrayList;
import java.util.List;

public class InvocacionCartaMonstruoGenerica extends InvocacionCartaMonstruo {

    public InvocacionCartaMonstruoGenerica(CartaMonstruo unaCarta, List<CartaMonstruo> sacrificios) {
        super(unaCarta, sacrificios);
        carta = unaCarta;
        this.sacrificios = sacrificios;
    }

    public InvocacionCartaMonstruoGenerica(CartaMonstruo unaCarta) {
        super(unaCarta, new ArrayList<>());
        carta = unaCarta;
    }
    //Le podemos pasar el cementerio y la zona monstruo para que esta opere
    public List<CartaMonstruo> mostrarCartasASacrificar() {
        return sacrificios;
    }

    public boolean debeSacrificar() {
        if (sacrificios== null) return false;
        return sacrificios.size()>0;
    }

    public void sacrificar(Cementerio cementerio, ZonaMonstruo zonaMonstruo) {
        if (sacrificios==null) return;
        for (CartaMonstruo carta : sacrificios) {
            zonaMonstruo.eliminarCarta(carta);
            cementerio.colocarCarta(carta);
        }
    }
}
