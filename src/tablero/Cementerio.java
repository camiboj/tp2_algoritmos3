package tablero;
import java.util.Stack;
public class Cementerio {
    private Stack cartas;

    public Cementerio () {
        cartas = new Stack();
    }

    @Override
    public boolean equals(Object object){return this.getClass().equals(object.getClass());}
}
