package vista;

import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import tablero.Casillero;
import tablero.Tablero;


import java.util.List;

import static javafx.scene.paint.Color.GREEN;

public class VistaTablero {

    Tablero tablero;
    Pane pane;
    Canvas canvas;

    VistaTablero(Tablero tablero, Pane pane, Canvas canvas){
        this.tablero = tablero;
        this.pane = pane;
        this.canvas = canvas;
    }


    public void dibujar() {

        int x = 200;
        int y = 400;

        List<List<Casillero>> casillerosMonstruos = tablero.mostrarCasillerosZonaMonstruo();
        List<List<Casillero>> casillerosTrampaMagica = tablero.mostrarCasillerosZonaTrampaMagica();
        List<List<Casillero>> casillerosCampo = tablero.mostrarCasillerosZonaCampo();

        for (List<Casillero> list : casillerosMonstruos) {
            for (Casillero casillero : list) {
                Rectangle rectangle = new Rectangle(120, 70);
                Text text = new Text("Carta Monstruo");
                text.relocate(x, y);

                rectangle.setStroke(Color.BLACK);
                rectangle.setFill(GREEN);
                rectangle.relocate(x, y);

                pane.getChildren().addAll(rectangle, text);
                x += 120;
            }
            y += 200;
            x = 200;
        }

    }

}