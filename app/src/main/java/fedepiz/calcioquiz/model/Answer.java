package fedepiz.calcioquiz.model;

/**
 * Created by Federico on 13/7/15.
 */
public class Answer {
    private String answer;
    private boolean correct;

    public Answer(String answer, boolean correct) {
        this.answer = answer;
        this.correct = correct;
    }

    public String getAnswer() {
        return answer;
    }

    public boolean isCorrect() {
        return correct;
    }

    public String toString() {
        return (correct ? "!" : "") + answer;
    }
}
