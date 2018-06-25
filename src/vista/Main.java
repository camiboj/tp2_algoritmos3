package vista;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import jugador.YuGiOh;
import vista.ContenedorInicial;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage stage)  {

        stage.setTitle("YuGiOh");

        YuGiOh yugioh = new YuGiOh();

        ContenedorInicial contenedorInicial = new ContenedorInicial(stage,yugioh);
        Scene escenaInicial = new Scene(contenedorInicial, 640, 480);

        stage.setScene(escenaInicial);
        stage.setFullScreen(true);

        stage.show();
    }
}