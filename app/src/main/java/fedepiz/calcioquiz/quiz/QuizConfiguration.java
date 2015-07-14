package fedepiz.calcioquiz.quiz;

import java.io.Serializable;

/**
 * Created by Federico on 14/7/15.
 */
public class QuizConfiguration implements Serializable {
    private int numQuestions;
    private int minPoints;
    private int maxPoints;

    public QuizConfiguration(int numQuestions, int minPoints, int maxPoints) {
        this.numQuestions = numQuestions;
        this.minPoints = minPoints;
        this.maxPoints = maxPoints;
    }

    public int getNumQuestions() {
        return numQuestions;
    }

    public int getMinPoints() {
        return minPoints;
    }

    public int getMaxPoints() {
        return maxPoints;
    }
}
