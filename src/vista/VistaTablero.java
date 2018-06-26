package vista;

import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import tablero.Casillero;
import tablero.Tablero;


import java.util.List;

import static javafx.scene.paint.Color.*;

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

        int x = 300;
        int y = 225;

        List<List<Casillero>> casillerosMonstruos = tablero.mostrarCasillerosZonaMonstruo();
        List<List<Casillero>> casillerosTrampaMagica = tablero.mostrarCasillerosZonaTrampaMagica();
        List<List<Casillero>> casillerosCampo = tablero.mostrarCasillerosZonaCampo();

        for (List<Casillero> list : casillerosMonstruos) {
            for (Casillero casillero : list) {
                Rectangle rectangle = new Rectangle(80, 120);
                Text text = new Text("Carta \n Monstruo");
                text.setTextAlignment(TextAlignment.CENTER);
                text.relocate(x, y);

                rectangle.setStroke(Color.BLACK);
                rectangle.setFill(ORANGERED);
                rectangle.relocate(x, y);

                pane.getChildren().addAll(rectangle, text);
                x += 90;
            }
            y += 200;
            x = 300;
        }

        x = 300;
        y = 80;

        for (List<Casillero> list : casillerosTrampaMagica) {
            for (Casillero casillero : list) {
                Rectangle rectangle = new Rectangle(80, 120);
                Text text = new Text("Carta \n Trampa \n Magica");
                text.setTextAlignment(TextAlignment.CENTER);
                text.relocate(x, y);

                rectangle.setStroke(Color.BLACK);
                rectangle.setFill(LIGHTBLUE);
                rectangle.relocate(x, y);

                pane.getChildren().addAll(rectangle, text);
                x += 90;
            }
            y += 490;
            x = 300;
        }

    }

}