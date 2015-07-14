package fedepiz.calcioquiz.quiz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import fedepiz.calcioquiz.model.*;

/**
 * Created by Federico on 14/7/15.
 */
public class Quiz {

    private List<Question> questionList;
    private int currentQuestionIndex;

    private List<Pair<Question,Answer>> answerRecord;

    public Quiz(List<Question> questionList, int questionCount, int minPoints,int maxPoints) {
        List<Question> suitableQuestions = questionsInBounds(questionList,minPoints,maxPoints);
        suitableQuestions = selectRandomly(suitableQuestions,questionCount);
        Collections.shuffle(suitableQuestions);
        this.questionList = suitableQuestions;
        this.currentQuestionIndex = 0;
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

    private  boolean isEndOfQuiz() {
        return this.currentQuestionIndex < questionList.size();
    }

    public Question getCurrentQuestion() {
        if (!isEndOfQuiz()) {
            return questionList.get(currentQuestionIndex);
        } else {
            return null;
        }
    }
}
