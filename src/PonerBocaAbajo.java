public class PonerBocaAbajo implements Estado {

    public void darVuelta(Carta carta) {
        System.out.println("La carta esta boca abajo");
        carta.setEstado(this);

    }
}
