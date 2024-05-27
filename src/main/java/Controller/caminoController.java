package Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class caminoController {
    @FXML
    public Button botonEncontrar;

    @FXML
    public void initialize() {
        botonEncontrar.setOnAction(event -> {
            hallarCamino();
        });
    }

    private void hallarCamino() {
        try {
            // Ruta del intérprete de Python y del script
            String pythonPath = "python3"; // O "python" dependiendo de cómo esté configurado en tu sistema
            String scriptPath = "src/main/java/Python/caminoCorto.py";

            // Crear el proceso
            ProcessBuilder processBuilder = new ProcessBuilder(pythonPath, scriptPath);
            processBuilder.redirectErrorStream(true);
            Process process = processBuilder.start();

            // Leer la salida del proceso
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            StringBuilder output = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }

            // Esperar a que el proceso termine
            int exitCode = process.waitFor();
            if (exitCode == 0) {
                String outputStr = output.toString();
                JOptionPane.showMessageDialog(null, outputStr.strip(), "Camino mas corto", JOptionPane.INFORMATION_MESSAGE);
            } else {
                System.err.println("Python script exited with code: " + exitCode);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
