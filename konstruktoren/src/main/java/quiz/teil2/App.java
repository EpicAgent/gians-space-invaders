package quiz.teil2;

public class App {
    public static void main(String[] args) {
        Question[] questions = QuestionGenerator.generateQuestions(10, "easy");
        QuestionPlayer player = new QuestionPlayer();
        player.setQuestions(questions);
        player.play();
    }
}
