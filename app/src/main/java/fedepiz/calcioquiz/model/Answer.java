package fedepiz.calcioquiz.model;

import java.io.Serializable;

/**
 * Created by Federico on 13/7/15.
 */
public class Answer implements  Serializable{
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
    @Override
    public  boolean equals(Object other){
        if(other instanceof Answer) {
            Answer otherAnswer = (Answer)other;
            return otherAnswer.getAnswer().equals(this.getAnswer()) &&
                   otherAnswer.isCorrect() == this.isCorrect();
        }
        return false;
    }
}
