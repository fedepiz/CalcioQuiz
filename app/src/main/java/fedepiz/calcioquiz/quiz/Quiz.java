package fedepiz.calcioquiz.quiz;


import java.util.List;

import fedepiz.calcioquiz.model.*;

/**
 * Created by Federico on 14/7/15.
 */
public class Quiz {

    private List<Question> questionList;
    private int currentQuestionIndex;
    private int score;
    private int possibleScore;

    private List<Pair<Question,Answer>> answerRecord;

    public List<Pair<Question,Answer>> getAnswerRecord() {
        return this.answerRecord;
    }

    public int getScore() {
        return this.score;
    }

    public int getMaxPossibleScore() {
        return this.possibleScore;
    }

    public Quiz(List<Question> questionLis) {
        this.questionList = questionLis;
        this.currentQuestionIndex = 0;
        this.score = 0;
        this.possibleScore = 0;
    }


    public   boolean isEndOfQuiz() {
        return this.currentQuestionIndex < questionList.size();
    }

    public Question getCurrentQuestion() throws QuizException{
        if (!isEndOfQuiz()) {
            return questionList.get(currentQuestionIndex);
        } else {
            throw new QuizException("Quiz is over, but current question requested!");
        }
    }

    public  void answerCurrentQuestion(Answer answer) throws  QuizException{
        if(isEndOfQuiz()) {
            throw new  QuizException("Unable to answer question in Quiz: quiz is over!");
        }
        Question currentQuestion = getCurrentQuestion();
        if(!currentQuestion.getAnswerList().contains(answer))
            throw  new QuizException("Unable to answer question in Quiz: the proposed answer is not" +
                                     "one of the eligible ones");

        this.answerRecord.add(new Pair<>(currentQuestion,answer));
        this.currentQuestionIndex++;
        this.possibleScore += this.getCurrentQuestion().getScore();
        if(answer.isCorrect())
            this.score += currentQuestion.getScore();
    }
}
