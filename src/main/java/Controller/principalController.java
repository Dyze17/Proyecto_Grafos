package Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import java.io.IOException;

public class principalController {
    @FXML
    private Pane panelContenido;
    @FXML
    private Button botonGrafo;
    @FXML
    private Button botonMatriz;
    @FXML
    private Button botonCamino;

    @FXML
    public void initialize() {
        botonGrafo.setOnAction(event -> cargarContenido("/View/Grafo.fxml"));
        botonMatriz.setOnAction(event -> cargarContenido("/View/Matriz.fxml"));
        botonCamino.setOnAction(event -> cargarContenido("/View/Camino.fxml"));
    }

    private void cargarContenido(String rutaFXML) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(rutaFXML));
            Parent nuevoContenido = loader.load();
            panelContenido.getChildren().setAll(nuevoContenido);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
