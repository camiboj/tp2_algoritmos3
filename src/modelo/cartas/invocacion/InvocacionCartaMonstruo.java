package modelo.cartas.invocacion;

import modelo.cartas.Carta;
import modelo.tablero.Cementerio;
import modelo.tablero.ZonaMonstruo;

import java.util.List;

public abstract class InvocacionCartaMonstruo extends Invocacion {
    protected modelo.cartas.cartasMonstruo.CartaMonstruo carta;
    protected List<modelo.cartas.cartasMonstruo.CartaMonstruo> sacrificios;

    public InvocacionCartaMonstruo(modelo.cartas.cartasMonstruo.CartaMonstruo unaCarta, List unosSacrificios){
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
