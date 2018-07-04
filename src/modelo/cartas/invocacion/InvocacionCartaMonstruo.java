package modelo.cartas.invocacion;

import modelo.Fase.Fase;
import modelo.Fase.FasePreparacion;
import modelo.cartas.Carta;
import modelo.cartas.cartasMonstruo.CartaMonstruo;
import modelo.cartas.cartasMonstruo.cartasBasicas.HuevoMonstruoso;
import modelo.excepciones.InvocacionExcepcion;
import modelo.tablero.Cementerio;
import modelo.tablero.ZonaMonstruo;

import java.util.List;

public abstract class InvocacionCartaMonstruo extends Invocacion {
    protected FasePreparacion fase;
    protected CartaMonstruo carta;
    protected List<CartaMonstruo> sacrificios;

    public InvocacionCartaMonstruo(CartaMonstruo unaCarta, List unosSacrificios, FasePreparacion fase){
        super(unaCarta);
        carta = unaCarta;
        this.fase = fase;
        this.sacrificios = unosSacrificios;
    }

    public Carta invocar() throws InvocacionExcepcion {
        if (carta.puedeInvocarse(sacrificios, fase)) {
            return carta;
        }
        else {
            throw new InvocacionExcepcion("La carta no puede invocarse. Verifique que se puedan realizar los" +
                    "sacrificios en caso de ser necesarios y no estar tirando más de un monstruo en la Fase de " +
                    "Preparación");
        }
    }

    public abstract void sacrificar(Cementerio cementerio, ZonaMonstruo zonaMonstruo);
}
