package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class QuestionController implements Initializable {
    @FXML
    javafx.scene.control.Label question;

    @FXML
    javafx.scene.control.Button answer1;
    @FXML
    javafx.scene.control.Button answer2;
    @FXML
    javafx.scene.control.Button answer3;
    @FXML
    javafx.scene.control.Button answer4;
    @FXML
    javafx.scene.control.Button End;
    @FXML
    javafx.scene.control.Label number;

    QuestionPromouter promouter = new QuestionPromouter();

    static int currentQuestion=0;
    static int currentAnswer=currentQuestion+1;
    String currentQuestionstring=String.valueOf(currentAnswer)+"/25";
    static String correctAnswer;
    static int correctChoise=0;

    public QuestionController() throws FileNotFoundException {
    }

    public void init(){
        correctAnswer=promouter.nextQuestion().getCorrectAnswer();
        question.setText(promouter.nextQuestion().getQuestion());
        answer1.setText(promouter.nextQuestion().getAnswersChoice()[0]);
        answer2.setText(promouter.nextQuestion().getAnswersChoice()[1]);
        answer3.setText(promouter.nextQuestion().getAnswersChoice()[2]);
        answer4.setText(promouter.nextQuestion().getAnswersChoice()[3]);
        number.setText(currentQuestionstring);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for (int count = 0; count < currentQuestion +1; count++ ) {
            init();
        }
    }

    @FXML
    public void nextAnswer1() throws IOException {
        if(currentAnswer<25) {
            if(answer1.getText().equals(correctAnswer)){
                correctChoise++;
            }
            currentAnswer++;
            Parent root = FXMLLoader.load(getClass().getResource("Test.fxml"));
            answer1.getScene().setRoot(root);
        }
        else {
            Parent root =FXMLLoader.load(getClass().getResource("rezultat.fxml"));
            answer1.getScene().setRoot(root);
        }
    }
    public void nextAnswer3() throws IOException {
        if(currentAnswer<25) {
            if(answer3.getText().equals(correctAnswer)){
                correctChoise++;
            }
            currentAnswer++;
            Parent root = FXMLLoader.load(getClass().getResource("Test.fxml"));
            answer3.getScene().setRoot(root);
        }
        else {
            correctChoise++;
            Parent root =FXMLLoader.load(getClass().getResource("rezultat.fxml"));
            answer3.getScene().setRoot(root);
        }
    }

    public void nextAnswer2() throws IOException {
        if(currentAnswer<25) {
            if(answer2.getText().equals(correctAnswer)){
                correctChoise++;
            }
            currentAnswer++;
            Parent root = FXMLLoader.load(getClass().getResource("Test.fxml"));
            answer2.getScene().setRoot(root);
        }
        else {
            correctChoise++;
            Parent root =FXMLLoader.load(getClass().getResource("rezultat.fxml"));
            answer2.getScene().setRoot(root);
        }
    }

    public void nextAnswer4() throws IOException {
        if(currentAnswer<25) {
            if(answer4.getText().equals(correctAnswer)){
                correctChoise++;
            }
            currentAnswer++;
            Parent root = FXMLLoader.load(getClass().getResource("Test.fxml"));
            answer4.getScene().setRoot(root);
        }
        else {
            Parent root =FXMLLoader.load(getClass().getResource("rezultat.fxml"));
            answer4.getScene().setRoot(root);
        }
    }

    public static int getCorrectChoise() {
        return correctChoise;
    }

    public void goEnd() throws IOException {
        Parent root=FXMLLoader.load(getClass().getResource("rezultat.fxml"));
        End.getScene().setRoot(root);
    }
}
