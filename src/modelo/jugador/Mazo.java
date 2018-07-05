package modelo.jugador;
import modelo.cartas.Carta;
import modelo.cartas.CreadoraDeCartas;
import modelo.tablero.Tablero;
import modelo.tablero.ZonaMonstruo;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Mazo {
    private Stack<Carta> cartas;
    int TOTAL_CARTAS_MONSTRUO = 53;
    int TOTAL_CARTAS_MAGICAS_TRAMPA = 5;
    int TOTAL_CARTAS_ESPECIALES = 7;

    public Mazo(String nombreDelMazo, Jugador jugador, Jugador jugadorContrario,
                ZonaMonstruo zonaMonstruoAtacante, ZonaMonstruo zonaMonstruoPropia, Tablero tablero){
        //Constructor creado para tests y debug
        cartas = new Stack();
        int contadorDeCartasMagicasTrampa = 0;
        int contadorDeCartasEspeciales = 0;
        List registroCartasEspeciales = new ArrayList();
        List registroCartasTrampaMonstruo = new ArrayList();
        String nombreDeCarta = null;

        try{

            while(cartas.size()<10){
                Scanner cartasMonstruo = new Scanner(new File("resources/Nombres Monstruos.txt"));
                Scanner cartasMagicasTrampa = new Scanner(new File("resources/Nombres Cartas Magicas Trampas.txt"));
                Scanner cartasEspeciales = new Scanner(new File("resources/Nombres Cartas Especiales.txt"));
                Random r = new Random();

                int numeroMonstruos = 0;

                int mazoNumero = r.nextInt(4-1) +1;
                Random numeroRandomCarta = new Random();
                int numeroElegido;
                switch (mazoNumero) {
                    case 1:
                        if(numeroMonstruos < 15){
                        numeroElegido = numeroRandomCarta.nextInt(TOTAL_CARTAS_MONSTRUO);
                        int numero = 0;
                        while (numero <= numeroElegido) {
                            nombreDeCarta = cartasMonstruo.nextLine();
                            numero++;
                        }
                        agregarCarta(nombreDeCarta, jugador, jugadorContrario, zonaMonstruoAtacante, zonaMonstruoPropia, tablero);
                        cartasMonstruo.reset();
                }break;

                    case 2:
                        //if (contadorDeCartasMagicasTrampa<TOTAL_CARTAS_MAGICAS_TRAMPA){
                        numeroElegido = numeroRandomCarta.nextInt(TOTAL_CARTAS_MAGICAS_TRAMPA);
                        int numeroMagico = 0;
                        while (numeroMagico <= numeroElegido){
                            nombreDeCarta = cartasMagicasTrampa.nextLine();
                            numeroMagico++; }
                        agregarCarta(nombreDeCarta, jugador, jugadorContrario, zonaMonstruoAtacante, zonaMonstruoPropia, tablero);
                        cartasMagicasTrampa.reset();
                        contadorDeCartasMagicasTrampa++;
                    break;
                //}
                    case 3:
                        //if(contadorDeCartasEspeciales < TOTAL_CARTAS_ESPECIALES) {
                        numeroElegido = numeroRandomCarta.nextInt(TOTAL_CARTAS_ESPECIALES);
                        int numeroEspecial = 0;
                        while (numeroEspecial <= numeroElegido) {
                            nombreDeCarta = cartasEspeciales.nextLine();
                            numeroEspecial++; }
                        //if (!registroCartasEspeciales.contains(nombreDeCarta)){
                        agregarCarta(nombreDeCarta, jugador, jugadorContrario, zonaMonstruoAtacante, zonaMonstruoPropia, tablero);
                        contadorDeCartasEspeciales++;
                        registroCartasEspeciales.add(nombreDeCarta);
                         //}
                         cartasEspeciales.reset();
                    //}
                        break;
                     default:
                         break;
                        }

                cartasEspeciales.close();
                cartasMagicasTrampa.close();
                cartasMonstruo.close();
            }

            agregarCarta("Sogen", jugador, jugadorContrario, zonaMonstruoAtacante, zonaMonstruoPropia, tablero);
            agregarCarta("Sogen", jugador, jugadorContrario, zonaMonstruoAtacante, zonaMonstruoPropia, tablero);
            agregarCarta("Wasteland", jugador, jugadorContrario, zonaMonstruoAtacante, zonaMonstruoPropia, tablero);
            agregarCarta("Wasteland", jugador, jugadorContrario, zonaMonstruoAtacante, zonaMonstruoPropia, tablero);agregarCarta("Sogen", jugador, jugadorContrario, zonaMonstruoAtacante, zonaMonstruoPropia, tablero);
            agregarCarta("Sogen", jugador, jugadorContrario, zonaMonstruoAtacante, zonaMonstruoPropia, tablero);
            agregarCarta("Wasteland", jugador, jugadorContrario, zonaMonstruoAtacante, zonaMonstruoPropia, tablero);
            agregarCarta("Wasteland", jugador, jugadorContrario, zonaMonstruoAtacante, zonaMonstruoPropia, tablero);agregarCarta("Sogen", jugador, jugadorContrario, zonaMonstruoAtacante, zonaMonstruoPropia, tablero);
            agregarCarta("Sogen", jugador, jugadorContrario, zonaMonstruoAtacante, zonaMonstruoPropia, tablero);
            agregarCarta("Wasteland", jugador, jugadorContrario, zonaMonstruoAtacante, zonaMonstruoPropia, tablero);
            agregarCarta("Wasteland", jugador, jugadorContrario, zonaMonstruoAtacante, zonaMonstruoPropia, tablero);agregarCarta("Sogen", jugador, jugadorContrario, zonaMonstruoAtacante, zonaMonstruoPropia, tablero);
            agregarCarta("Sogen", jugador, jugadorContrario, zonaMonstruoAtacante, zonaMonstruoPropia, tablero);
            agregarCarta("Wasteland", jugador, jugadorContrario, zonaMonstruoAtacante, zonaMonstruoPropia, tablero);

            agregarCarta("Wasteland", jugador, jugadorContrario, zonaMonstruoAtacante, zonaMonstruoPropia, tablero);agregarCarta("Sogen", jugador, jugadorContrario, zonaMonstruoAtacante, zonaMonstruoPropia, tablero);
            agregarCarta("Sogen", jugador, jugadorContrario, zonaMonstruoAtacante, zonaMonstruoPropia, tablero);

            agregarCarta("Huevo Monstruoso", jugador, jugadorContrario, zonaMonstruoAtacante, zonaMonstruoPropia, tablero);
            agregarCarta("Huevo Monstruoso", jugador, jugadorContrario, zonaMonstruoAtacante, zonaMonstruoPropia, tablero);
            agregarCarta("Huevo Monstruoso", jugador, jugadorContrario, zonaMonstruoAtacante, zonaMonstruoPropia, tablero);

        }

       /* try {
            Scanner mazoGuardado= new Scanner(new File("resources/"+nombreDelMazo));
            while (mazoGuardado.hasNext()) {
                nombreDeCarta = mazoGuardado.nextLine();
                agregarCarta(nombreDeCarta, jugador, jugadorContrario, zonaMonstruoAtacante, zonaMonstruoPropia, tablero);

            }
            mazoGuardado.close();
        }*/
        catch (Exception e){
            for(int i = 0; i<40; i++) {
                agregarCarta( "Huevo Monstruoso", jugador, jugadorContrario, zonaMonstruoAtacante, zonaMonstruoPropia, tablero);
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
                             ZonaMonstruo zonaMonstruoAtacante, ZonaMonstruo zonaMonstruoPropia, Tablero tablero) {

        if (cartas.size()<40) {
            cartas.push(CreadoraDeCartas.crearCarta(nombreDeCarta));
            }
        }
    }
