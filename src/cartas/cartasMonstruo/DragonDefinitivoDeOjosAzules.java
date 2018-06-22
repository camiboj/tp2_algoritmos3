package cartas.cartasMonstruo;

import cartas.cartasMonstruo.cartasBasicas.DragonBlancoDeOjosAzules;

import java.util.List;

public class DragonDefinitivoDeOjosAzules extends CartaMonstruo {

    public DragonDefinitivoDeOjosAzules() {
        super("Dragon Definitivo de Ojos Azules", 4500, 3800, 12);
    }

    public boolean puedeInvocarse(List<CartaMonstruo> cartasASacrificar) {
        int contador = 0;
        for (CartaMonstruo monstruo: cartasASacrificar) {
            if ((new DragonBlancoDeOjosAzules()).getClass() == monstruo.getClass())
                contador ++;
        }
        if (contador >= 3){
            return true;
        }
        return false;
    }
}
