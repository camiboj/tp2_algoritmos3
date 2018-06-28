package jugador;
import cartas.Carta;
import cartas.CreadoraDeCartas;
import tablero.ZonaMonstruo;

import java.io.File;
import java.util.Scanner;
import java.util.Stack;
public class Mazo {
    private Stack<Carta> cartas;

   /* public Mazo() {
        cartas = new Stack();

        try {
            Scanner mazoGuardado= new Scanner(new File("resources/mazoJugador1"));
            String nombreDeCarta;
            while (mazoGuardado.hasNext()) {
                nombreDeCarta = mazoGuardado.nextLine();
                agregarCarta(nombreDeCarta);
            }
            mazoGuardado.close();
        }
        catch (Exception e){
            for(int i = 0; i<40; i++) {
                agregarCarta( "Huevo Monstruoso");
            }
        }
    }*/
    public Mazo(String nombreDelMazo, Jugador jugador, Jugador jugadorContrario,
                ZonaMonstruo zonaMonstruoAtacante, ZonaMonstruo zonaMonstruoPropia){
        //Constructor creado para tests y debug
        cartas = new Stack();

        try {
            Scanner mazoGuardado= new Scanner(new File("resources/"+nombreDelMazo));
            String nombreDeCarta;
            while (mazoGuardado.hasNext()) {
                nombreDeCarta = mazoGuardado.nextLine();
                agregarCarta(nombreDeCarta, jugador, jugadorContrario, zonaMonstruoAtacante, zonaMonstruoPropia);

            }
            mazoGuardado.close();
        }
        catch (Exception e){
            for(int i = 0; i<40; i++) {
                agregarCarta( "Huevo Monstruoso", jugador, jugadorContrario, zonaMonstruoAtacante, zonaMonstruoPropia);
            }
        }
    }

    public boolean estaVacio() {
        return cartas.empty();
    }

    public Carta sacarCarta() {
        Carta carta = cartas.pop();

        return carta;
    }

    public int obtenerCantidad() {
        return cartas.size();
    }

    public void agregarCarta(String nombreDeCarta, Jugador jugador, Jugador jugadorContrario,
                             ZonaMonstruo zonaMonstruoAtacante, ZonaMonstruo zonaMonstruoPropia) {

        if (cartas.size()<40) {
            cartas.push(CreadoraDeCartas.crearCarta(nombreDeCarta, jugador, jugadorContrario, zonaMonstruoAtacante, zonaMonstruoPropia));
        }
    }
}