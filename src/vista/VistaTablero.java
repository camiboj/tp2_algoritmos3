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

        List<List<Casillero>> casillerosMonstruos = tablero.mostrarCasillerosZonaMonstruo();
        List<List<Casillero>> casillerosTrampaMagica = tablero.mostrarCasillerosZonaTrampaMagica();
        List<List<Casillero>> casillerosCampo = tablero.mostrarCasillerosZonaCampo();

        dibujarMonstruos(casillerosMonstruos, 300, 225);
        dibujarTrampaMagica(casillerosTrampaMagica, 300, 80);

        dibujarCasillero(casillerosCampo, 300- 25 -80, 200 - 25 + 225, 300 + 440 + 25, 225+25,
                "Carta \n Campo", LIGHTGREEN);
        dibujarCasillero(casillerosCampo, 300-25-80, 225+25, 300+440+25, 200-25+225,
                "Cementerio", LIGHTGREY);
        dibujarCasillero(casillerosCampo, 300-25-80, 80-25, 300+440+25, 595,
                "Mazo", LIGHTPINK);
    }

    private void dibujarCementerio(List<List<Casillero>> casillerosCampo, int i, int i1, int i2, int i3) {
    }

    private void dibujarCasillero(List<List<Casillero>> casillerosCampo, int x, int y, int xfinal, int yfinal,
                                  String nombre, Color color) {
        for (List<Casillero> list : casillerosCampo) {
            for (Casillero casillero : list) {
                Rectangle rectangle = new Rectangle(80, 120);
                Text text = new Text(nombre);
                text.setTextAlignment(TextAlignment.CENTER);
                text.relocate(x, y);

                rectangle.setStroke(Color.BLACK);
                rectangle.setFill(color);
                rectangle.relocate(x, y);

                pane.getChildren().addAll(rectangle, text);
            }
            y = yfinal;
            x = xfinal;
        }
    }

    private void dibujarTrampaMagica(List<List<Casillero>> casillerosTrampaMagica, int x, int y) {

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

    private void dibujarMonstruos(List<List<Casillero>> casillerosMonstruos, int x, int y) {

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
    }

}