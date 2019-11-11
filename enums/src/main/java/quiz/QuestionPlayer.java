package quiz;

import java.util.Scanner;

public class QuestionPlayer {
    private Question[] questions;

    public void play() {
        int points = 0;
        for (int i = 0; i < questions.length; i++) {
            System.out.println("Frage " + (i + 1) + ": " + questions[i].getQuestionText());
            Answer[] answers = questions[i].getAnswers();
            for (int j = 0; j < answers.length; j++) {
                System.out.println("" + (j + 1) + ": " + answers[j].getAnswerText());
            }
            int answerPosition = getValidUserInputForQuestion(questions[i]);
            if (isCorrectAnswer(answerPosition - 1, answers)) {
                System.out.println("Korrekt");
                points++;
            } else {
                System.out.println("Falsch");
            }
            System.out.println();

        }

        System.out.println();
        System.out.println("Erreichte Punkte: " + points);
    }

    public Question[] getQuestions() {
        return questions;
    }

    public void setQuestions(Question[] questions) {
        this.questions = questions;
    }

    private static int getValidUserInputForQuestion(Question question) {
        boolean isValidUserInput = false;
        int answerPosition = -1;
        while (!isValidUserInput) {
            answerPosition = getIntFromStdInput();
            if (isValidAnswerPosition(answerPosition, question)) {
                isValidUserInput = true;
            } else {
                System.out.println("Gebe eine gültige Zahl ein.");
            }
        }
        return answerPosition;
    }

    private static boolean isValidAnswerPosition(int answerPosition, Question question) {
        return answerPosition >= 1 && answerPosition <= question.getAnswers().length;
    }

    private static int getIntFromStdInput() {
        Scanner scanner = new Scanner(System.in);
        while(!scanner.hasNextInt()) {
            System.out.println("Gebe eine gültige Zahl ein.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static boolean isCorrectAnswer(int answerIndex, Answer[] possibleAnswers) {
        return possibleAnswers[answerIndex].isCorrect();
    }


}
