package quiz.teil1;

public class App {
    /*
    dsafsaf
     */
    public static void main(String[] args) {
        Question[] questions = QuestionGenerator.generateQuestions(10, "easy");
        QuestionPlayer player = new QuestionPlayer();
        player.setQuestions(questions);
        player.play();

    }
}
