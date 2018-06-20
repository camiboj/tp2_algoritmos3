package jugador;
import cartas.Carta;
import cartas.CreadoraDeCartas;
import java.io.File;
import java.util.Scanner;
import java.util.Stack;
public class Mazo {
    private Stack<Carta> cartas;

    public Mazo() {
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
    }
    public Mazo(String nombreDelMazo){
        //Constructor creado para tests y debug
        cartas = new Stack();

        try {
            Scanner mazoGuardado= new Scanner(new File("resources/"+nombreDelMazo));
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
    }

    public Carta sacarCarta() {
        Carta carta = cartas.pop();

        return carta;
    }

    public int obtenerCantidad() {
        return cartas.size();
    }

    public void agregarCarta(String nombreDeCarta) {

        if (cartas.size()<40){
            cartas.push(CreadoraDeCartas.crearCarta(nombreDeCarta));
        }


    }
}