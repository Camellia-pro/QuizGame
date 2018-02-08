package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ScoreLoader implements Initializable {
    private int score = QuestionController.getCorrectChoise();
    @FXML
    javafx.scene.control.Label Rate;
    @FXML
    javafx.scene.control.Button picture;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Rate.setText("Ваш результат: " + String.valueOf(score));
    }

    public void startPaint() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Mosaic.fxml"));
        picture.getScene().setRoot(root);
    }
}
