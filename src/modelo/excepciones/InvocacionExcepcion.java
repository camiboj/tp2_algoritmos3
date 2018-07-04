package modelo.excepciones;

public class InvocacionExcepcion extends Exception {
    private String motivo;

    public InvocacionExcepcion(String motivo) {
        this.motivo = motivo;
    }

    public String obtenerMotivo() {
            return motivo;
        }
}
