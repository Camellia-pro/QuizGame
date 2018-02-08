package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class Main extends Application {
    @FXML
    Button Start;
    @FXML
    Button Back;
    @FXML
    Button Save;
    static public String file1 = "HarryPotter.mp3";
    static Media soundPotter = new Media(new File(file1).toURI().toString());
    static MediaPlayer mediaPotterPlayer = new MediaPlayer(soundPotter);

    static public String file2 = "Mister_dudec.mp3";
    static Media soundDudets = new Media(new File(file2).toURI().toString());
    static MediaPlayer mediaDudetsPlayer = new MediaPlayer(soundDudets);
    Group group = new Group();
    public static Stage primaryStageStatic;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
        mediaPotterPlayer.play();
        mediaPotterPlayer.setAutoPlay(true);
    }

    public void exitGame() {
        System.exit(1);
    }

    public void startGame() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Test.fxml"));
        Start.getScene().setRoot(root);
        mediaPotterPlayer.stop();
        mediaDudetsPlayer.play();
        mediaDudetsPlayer.setAutoPlay(true);
    }

    public void backMenu() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
        Back.getScene().setRoot(root);
    }

    public void saveImg() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Mosaic.fxml"));
        Save.getScene().setRoot(root);

    }
}

