package cartas.invocacion;

import cartas.cartasMonstruo.CartaMonstruo;

import java.util.List;

public class InvocacionCartaDragonDefinitivoOjosAzules extends InvocacionCartaMonstruo {

    public InvocacionCartaDragonDefinitivoOjosAzules(CartaMonstruo unaCarta, List<CartaMonstruo> sacrificios) {
        super(unaCarta, sacrificios);
        carta = unaCarta;
        this.sacrificios = sacrificios;
    }

    public boolean debeSacrificar() { return true; }

    public List<CartaMonstruo> mostrarCartasASacrificar() {
        return sacrificios;
    }


}

