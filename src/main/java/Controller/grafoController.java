package Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class grafoController {
    @FXML
    public Button botonDibujar;

    @FXML
    public void initialize() {
        botonDibujar.setOnAction(event -> {
            dibujarGrafo();
        });
    }

    public void dibujarGrafo() {
        try {
            // Crear el proceso
            ProcessBuilder pb = new ProcessBuilder("python3", "src/main/java/Python/dibujar.py");
            Process process = pb.start();

            // Obtener la salida estándar del proceso
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // Obtener la salida de error del proceso
            BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            String errorLine;
            while ((errorLine = errorReader.readLine()) != null) {
                System.err.println(errorLine);
            }

            // Esperar a que el proceso termine y obtener el código de salida
            int exitCode = process.waitFor();
            System.out.println("Código de salida: " + exitCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}