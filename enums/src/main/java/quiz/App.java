package quiz;

public class App {
    public static void main(String[] args) {
        Question[] questions = QuestionGenerator.generateQuestions(10, Difficulty.EASY);
        QuestionPlayer player = new QuestionPlayer();
        player.setQuestions(questions);
        player.play();
    }
}
