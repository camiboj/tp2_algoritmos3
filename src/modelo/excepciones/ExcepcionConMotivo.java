package modelo.excepciones;

public class ExcepcionConMotivo extends Exception{
    private final String motivo;

    public ExcepcionConMotivo(String motivo){
        this.motivo = motivo;
    }
    public String obtenerMotivo() {
        return motivo;
    }
}
