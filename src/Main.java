import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Esta es la clase principal de proyecto
 * donde se empieza a ejecutar toda la aplicacion
 *
 * @author Jose Corra
 * @version 1.0.0
 */

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("gui/vista/Inicio.fxml"));
        primaryStage.setTitle("Sistema Operativo");
        primaryStage.setScene(new Scene(root, 685, 490));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
