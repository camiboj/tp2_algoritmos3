package vista;
import modelo.excepciones.VictoriaException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import modelo.jugador.YuGiOh;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage stage) throws VictoriaException {

        stage.setTitle("YuGiOh");

        YuGiOh yugioh = new YuGiOh();

        ContenedorInicial contenedorInicial = new ContenedorInicial(stage,yugioh);
        Scene escenaInicial = new Scene(contenedorInicial, 640, 480);

        stage.setScene(escenaInicial);
        stage.setFullScreen(false);

        stage.show();
    }
}