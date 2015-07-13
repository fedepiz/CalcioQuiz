package fedepiz.calcioquiz.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Federico on 13/7/15.
 */
public class Question {
    private int id;
    private String text;
    private List<Answer> answerList;
    private Integer score;

    public Question(int id, String text, List<Answer> answerList,Integer score) {
        this.id = id;
        this.text = text;
        this.answerList = answerList;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public List<Answer> getAnswerList() {
        return answerList;
    }

    public List<Answer> getCorrectAnswers() {
        List<Answer> resultList = new ArrayList<Answer>();
        for(Answer answer : getAnswerList()) if (answer.isCorrect()) resultList.add(answer);
        return resultList;
    }

    public Integer getScore() {
        return score;
    }
}
