public class PonerBocaArriba implements Estado {

    public void darVuelta(Carta carta) {
        System.out.println("La carta esta boca arriba");
        carta.setEstado(this);
    }
}
