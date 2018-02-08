package sample;

public class Question {
    protected String question;
    private String[] answersChoice;
    private String correctAnswer;

    public Question(String question, String[] answersChoice, String correctAnswer) {
        this.answersChoice = answersChoice;
        this.correctAnswer = correctAnswer;
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }


    public String[] getAnswersChoice() {
        return answersChoice;
    }

    public String getCorrectAnswer() {
        return correctAnswer;

    }
}
