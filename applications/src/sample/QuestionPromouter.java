package sample;

import java.io.*;
import java.util.Scanner;

public class QuestionPromouter {
    private static int counter = 0;
    private int currentQuestion = 0;
    private Question[] questions = new Question[25];

    public QuestionPromouter() throws FileNotFoundException {
        this.currentQuestion = counter;
        counter++;
        Scanner test = new Scanner(new File("test.txt"));
        for (int questCount = 0; questCount < questions.length; questCount++) {
            questions[questCount] = new Question(test.nextLine(), test.nextLine().split(";"),
                    test.nextLine());
        }
        test.close();
    }

    public Question nextQuestion() {
        return this.questions[currentQuestion];
    }
}
