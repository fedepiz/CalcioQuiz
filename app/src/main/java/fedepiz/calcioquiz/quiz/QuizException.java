package fedepiz.calcioquiz.quiz;

/**
 * Created by Federico on 14/7/15.
 */
public class QuizException extends Exception {
    public QuizException(String str) {
        super(str);
    }

    public QuizException(Exception ex) {
        super(ex.getMessage());
    }
}
