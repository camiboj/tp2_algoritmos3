public abstract class Carta {
    protected char nombre;

    public Carta(char unNombre) {
        this.nombre = unNombre;
    }

    public Carta crearCarta(char unNombre) {
        Carta resultado = new Carta(unNombre);
        return resultado;
    }
}
