package modelo.excepciones;

public class ZonaMonstruoLlenaException extends Exception {
    private String motivo;
    public ZonaMonstruoLlenaException(String motivo) {
        this.motivo = motivo;
    }
    public String obtenerMotivo(){
        return motivo;
    }
}
