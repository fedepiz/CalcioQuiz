package fedepiz.calcioquiz.quiz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import fedepiz.calcioquiz.model.Question;

/**
 * Created by Federico on 14/7/15.
 */
public class QuizBuilder {
    private List<Question> questionList;
    int questionCount;
    int minPoints;
    int maxPoints;

    public QuizBuilder(List<Question> questionList, int questionCount, int minPoints, int maxPoints) {
        this.questionList = questionList;
        this.questionCount = questionCount;
        this.minPoints = minPoints;
        this.maxPoints = maxPoints;
    }

    public  Quiz buildQuiz() {
        return  new Quiz(buildQuestionList());
    }

    public List<Question> buildQuestionList() {
        List<Question> suitableQuestions = questionsInBounds(questionList,minPoints,maxPoints);
        Collections.shuffle(suitableQuestions);
        return suitableQuestions.subList(0,questionCount);
    }

    private List<Question> questionsInBounds(List<Question> original,int low,int high) {
        List<Question> questionList = new ArrayList<>();
        for(Question question:original) {
            if (question.getScore() >= low && question.getScore() <= high)
                questionList.add(question);
        }
        return questionList;
    }

}
