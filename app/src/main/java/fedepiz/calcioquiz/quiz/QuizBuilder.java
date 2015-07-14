package fedepiz.calcioquiz.quiz;

import java.util.List;

import fedepiz.calcioquiz.model.Question;

/**
 * Created by Federico on 14/7/15.
 */
public interface QuizBuilder {
    Quiz buildQuiz();
    List<Question> buildQuestionList();
}
