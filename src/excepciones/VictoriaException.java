package excepciones;

public class VictoriaException extends Exception {
    private String motivo;
    public VictoriaException(String motivo) {
        this.motivo =motivo;
    }
    public String obtenerMotivo(){
        return motivo;
    }
}
