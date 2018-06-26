package cartas.invocacion;

import cartas.Carta;
import cartas.cartasMonstruo.CartaMonstruo;
import tablero.Cementerio;
import tablero.ZonaMonstruo;

import java.util.List;

public abstract class InvocacionCartaMonstruo extends Invocacion {
    protected CartaMonstruo carta;
    protected List<CartaMonstruo> sacrificios;

    public InvocacionCartaMonstruo(CartaMonstruo unaCarta, List unosSacrificios){
        super(unaCarta);
        carta = unaCarta;
        this.sacrificios = unosSacrificios;
    }

    public Carta invocar() {
        if (carta.puedeInvocarse(sacrificios)) {
            return carta;
        } else {
            throw new RuntimeException("Los sacrificios");
        }
    }

    public abstract void sacrificar(Cementerio cementerio, ZonaMonstruo zonaMonstruo);
}
