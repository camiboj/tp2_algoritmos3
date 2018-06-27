package vista;

import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import tablero.Casillero;
import tablero.Tablero;
import vista.botones.BotonCartaBocaAbajo;


import javax.management.relation.RoleList;
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

        dibujarMonstruos(casillerosMonstruos, 330, 175);
        dibujarTrampaMagica(casillerosTrampaMagica, 330, 30);

        dibujarCasillero(casillerosCampo, 235, 325, 930, 30,
                "Carta \n Campo", LIGHTGREEN);
        dibujarCasillero(casillerosCampo, 235, 175, 930, 325,
                "Cementerio", LIGHTGREY);
        dibujarCasilleroMazo(casillerosCampo, 235, 30, 930, 470);
    }

    private void dibujarCasilleroMazo(List<List<Casillero>> casillerosCampo, int x, int y,
                                      int xfinal, int yfinal) {

        for (List<Casillero> list : casillerosCampo) {
            for (Casillero casillero : list) {

                BotonCartaBocaAbajo botonCartaBocaAbajo = new BotonCartaBocaAbajo();
                botonCartaBocaAbajo.setMaxSize(70,120);
                //botonCartaBocaAbajo.setPrefSize(70, 120);
                botonCartaBocaAbajo.setDisable(false);

                botonCartaBocaAbajo.relocate(x, y);

                pane.getChildren().addAll(botonCartaBocaAbajo);
                //Agregar cantidad de cartas

            }
            y = yfinal;
            x = xfinal;
        }
    }

    private void dibujarCasillero(List<List<Casillero>> casillerosCampo, int x, int y, int xfinal, int yfinal,
                                  String nombre, Color color) {
        for (List<Casillero> list : casillerosCampo) {
            for (Casillero casillero : list) {
                Rectangle rectangle = new Rectangle(70, 120);
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
                Rectangle rectangle = new Rectangle(70, 120);
                Text text = new Text("Carta \n Trampa \n Magica");
                text.setTextAlignment(TextAlignment.CENTER);
                text.relocate(x, y);

                rectangle.setStroke(Color.BLACK);
                rectangle.setFill(LIGHTBLUE);
                rectangle.relocate(x, y);

                pane.getChildren().addAll(rectangle, text);
                x += 70+(120-70);
            }
            y += 440;
            x = 330;
        }
    }

    private void dibujarMonstruos(List<List<Casillero>> casillerosMonstruos, int x, int y) {

        for (List<Casillero> list : casillerosMonstruos) {
            for (Casillero casillero : list) {
                Rectangle rectangle = new Rectangle(70, 120);
                Text text = new Text("Carta \n Monstruo");
                text.setTextAlignment(TextAlignment.CENTER);
                text.relocate(x, y);

                rectangle.setStroke(Color.BLACK);
                rectangle.setFill(ORANGERED);
                rectangle.relocate(x, y);

                pane.getChildren().addAll(rectangle, text);
                x += 70+(120-70); //la carta misma y el espacio de la otra acostada
            }
            y += 150;
            x = 330;
        }
    }

}