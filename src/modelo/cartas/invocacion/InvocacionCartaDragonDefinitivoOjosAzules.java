package modelo.cartas.invocacion;

import modelo.Fase.Fase;
import modelo.Fase.FasePreparacion;
import modelo.cartas.Carta;
import modelo.cartas.cartasMonstruo.CartaMonstruo;
import modelo.cartas.cartasMonstruo.DragonDefinitivoDeOjosAzules;
import modelo.cartas.cartasMonstruo.cartasBasicas.DragonBlancoDeOjosAzules;
import modelo.excepciones.InvocacionExcepcion;
import modelo.tablero.Cementerio;
import modelo.tablero.ZonaMonstruo;

import java.util.List;

public class InvocacionCartaDragonDefinitivoOjosAzules extends InvocacionCartaMonstruo {
    List<DragonBlancoDeOjosAzules> sacrificios;

    public InvocacionCartaDragonDefinitivoOjosAzules(DragonDefinitivoDeOjosAzules unaCarta,
                                                     List<DragonBlancoDeOjosAzules> sacrificios, FasePreparacion fase) {
        super(unaCarta, sacrificios, fase);
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
    @Override
    public CartaMonstruo invocar() throws InvocacionExcepcion {

        if (this.validarSacrificios() && fase.validarMonstruo()) {
            return this.carta;
        } else {
            throw new InvocacionExcepcion("La carta no puede invocarse. Verifique que se puedan realizar los " +
                    "sacrificios en caso de ser necesarios y no estar tirando más de un monstruo en la Fase de " +
                    "Preparación");
        }
    }

    private boolean validarSacrificios() {
        boolean resultado = true;
        for (CartaMonstruo cartaMonstruo : sacrificios) {
            resultado = cartaMonstruo instanceof DragonBlancoDeOjosAzules;
            if (! resultado) { break; }
        }
        return sacrificios.size() == 3 && resultado;
    }
}

