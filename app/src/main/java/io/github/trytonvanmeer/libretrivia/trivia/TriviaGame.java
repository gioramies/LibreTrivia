package io.github.trytonvanmeer.libretrivia.trivia;

import java.util.List;

public class TriviaGame {
    private static final String TAG = "TriviaGame";

    private int currentQuestion;
    private boolean[] questionsAnsweredStatus;
    private List<TriviaQuestion> questions;

    public TriviaGame(List<TriviaQuestion> questions) {
        this.currentQuestion = 0;
        this.questions = questions;
        this.questionsAnsweredStatus = new boolean[questions.size()];
    }

    public TriviaQuestion getCurrentQuestion() {
        return this.questions.get(currentQuestion);
    }

    public int getCurrentQuestionCount() {
        return this.currentQuestion + 1;
    }

    public int getQuestionsCount() {
        return this.questions.size();
    }

    public boolean nextQuestion(String guess) {
        TriviaQuestion question = getCurrentQuestion();
        boolean answer = question.checkAnswer(guess);

        questionsAnsweredStatus[currentQuestion] = answer;
        currentQuestion++;

        return answer;
    }

    public boolean isDone() {
        return (this.currentQuestion == questions.size());
    }
}
