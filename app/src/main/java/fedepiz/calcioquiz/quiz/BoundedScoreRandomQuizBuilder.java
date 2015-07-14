package fedepiz.calcioquiz.quiz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import fedepiz.calcioquiz.model.Question;

/**
 * Created by Federico on 14/7/15.
 */
public class BoundedScoreRandomQuizBuilder implements  QuizBuilder {
    private List<Question> questionList;
    int questionCount;
    int minPoints;
    int maxPoints;

    public BoundedScoreRandomQuizBuilder(List<Question> questionList,  int questionCount, int minPoints, int maxPoints) {
        this.questionList = questionList;
        this.questionCount = questionCount;
        this.minPoints = minPoints;
        this.maxPoints = maxPoints;
    }


    public  Quiz buildQuiz() {
        List<Question> suitableQuestions = questionsInBounds(questionList,minPoints,maxPoints);
        suitableQuestions = selectRandomly(suitableQuestions,questionCount);
        Collections.shuffle(suitableQuestions);
        return new Quiz(suitableQuestions);
    }

    private List<Question> questionsInBounds(List<Question> original,int low,int high) {
        List<Question> questionList = new ArrayList<>();
        for(Question question:original) {
            if (question.getScore() >= low && question.getScore() <= high)
                questionList.add(question);
        }
        return questionList;
    }

    private List<Question> selectRandomly(List<Question> ls,int count) {
        Random rand = new Random();
        List<Question> newList = new ArrayList<>(ls);
        while(ls.size() > count) {
            int toDropIndex = rand.nextInt(ls.size());
            newList.remove(toDropIndex);
        }
        return newList;
    }
}
