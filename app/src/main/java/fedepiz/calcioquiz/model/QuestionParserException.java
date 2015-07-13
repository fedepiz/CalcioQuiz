package fedepiz.calcioquiz.model;

/**
 * Created by Federico on 13/7/15.
 */
public class QuestionParserException extends  Exception {

    public QuestionParserException(String str) {
        super(str);
    }

    public QuestionParserException(Exception ex) {
        super(ex.getMessage());
    }
}
