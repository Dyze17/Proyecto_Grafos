package App;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.concurrent.atomic.AtomicReference;

public class Aplicacion extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        AtomicReference<FXMLLoader> loader = new AtomicReference<>(new FXMLLoader(Aplicacion.class.getResource("/View/Inicio.fxml")));
        Parent parent = loader.get().load();

        primaryStage.setScene(parent.getScene());
        primaryStage.setResizable(false);
        primaryStage.show();

        new Thread(() -> {
            try {
                Thread.sleep(1);
                loader.set(new FXMLLoader(Aplicacion.class.getResource("/View/Inicio.fxml")));
                Parent mainRoot = loader.get().load();
                Scene mainScene = new Scene(mainRoot);

                javafx.application.Platform.runLater(() -> {
                    primaryStage.setScene(mainScene);
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                Thread.sleep(5000);
                loader.set(new FXMLLoader(Aplicacion.class.getResource("/View/Principal.fxml")));
                Parent mainRoot = loader.get().load();
                Scene mainScene = new Scene(mainRoot);
                javafx.application.Platform.runLater(() -> {
                    primaryStage.setScene(mainScene);
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
