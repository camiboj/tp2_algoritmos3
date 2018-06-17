public abstract class Carta {
    protected String nombre;
    private Estado estado;

    public Carta(String unNombre) {
        this.nombre = unNombre;
        this.estado = null;
    }

    public void setEstado(Estado nuevoEstado){
        this.estado = nuevoEstado;
    }


    /*public Carta crearCarta(char unNombre) {
        Carta resultado = new Carta(unNombre);
        return resultado;
    }*/
}
