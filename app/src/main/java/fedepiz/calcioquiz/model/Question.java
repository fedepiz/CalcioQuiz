package fedepiz.calcioquiz.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by Federico on 13/7/15.
 */
@SuppressWarnings("ALL")
public class Question implements Serializable {
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

    public String toString() {
        String head = id + " " + text + " " + score;
        StringBuilder sb = new StringBuilder("");
        for(Answer ans:getAnswerList()) {
            sb.append(ans.toString());
            sb.append("\n");
        }
        return head + "\n" + sb.toString();
    }

    @Override
    public boolean equals(Object other) {
        if(other instanceof  Question) {
            Question otherQuestion = (Question)other;
            return  otherQuestion.getId() == this.getId() &&
                    otherQuestion.getScore() == this.getScore() &&
                    otherQuestion.getText().equals(this.getText()) &&
                    otherQuestion.getAnswerList().equals(this.getAnswerList());
        }
        return false;
    }
}
