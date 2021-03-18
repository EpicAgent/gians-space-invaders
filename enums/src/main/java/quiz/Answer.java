package quiz;

public class Answer {
    private String answerText;
    private boolean isCorrect;

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    public void isCorrect(boolean correct) {
        isCorrect = correct;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

}
