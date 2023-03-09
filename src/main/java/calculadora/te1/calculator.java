package calculadora.te1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class calculator extends Application { //Declaración de la clase principal que arranca el programa


    @Override
    public void start(Stage stage) throws IOException { //Declaración de la función que genera la interfaz
        FXMLLoader fxmlLoader = new FXMLLoader(calculator.class.getResource("view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 460, 440);
        stage.setTitle("Calculadora");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) { //Declaración de la función que ejecuta el programa

        launch();
    }
}