package fedepiz.calcioquiz.model;

import android.content.Context;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/**
 * Created by Federico on 13/7/15.
 */
public class QuestionParser  {
    private Context context;

    public QuestionParser(Context context) {
        this.context = context;
    }

    public List<Question> questionsFromXML(InputStream inputSource) throws QuestionParserException {
        Document document = this.parseDocument(inputSource);
        return questionsFromNode(document);
    }

    private Document parseDocument(InputStream inputSource) throws QuestionParserException {
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            return documentBuilder.parse(inputSource);
        } catch (ParserConfigurationException ex) {
            throw new QuestionParserException(ex.getMessage());
        } catch (SAXException ex) {
            throw new QuestionParserException(ex.getMessage());
        } catch (IOException ex) {
            throw new QuestionParserException(ex.getMessage());
        }
    }

    private List<Node> getNodesWithName(NodeList nls,String name) {
        List<Node> ls = new ArrayList<Node>();
        for(int i = 0; i < nls.getLength();i++) {
            Node node = nls.item(i);
            if (node.getNodeName().equals(name))
                ls.add(node);
        }
        return ls;
    }


    private List<Question> questionsFromNode(Node node) throws QuestionParserException {
        List<Node> questionNodes = getNodesWithName(node.getChildNodes(),"domanda");
        List<Question> questionList = new ArrayList<>();
        for(Node n:questionNodes) {
            questionList.add(questionFromNode(n));
        }
        return questionList;
    }

    private  Question questionFromNode(Node questionNode) throws QuestionParserException {
        Integer id = questionID(questionNode);
        if(id == null) {
            throw new QuestionParserException("Failed parsing question id");
        }
        String text = questionText(questionNode);
        if(text == null)
            throw new QuestionParserException("Failed parsing text for question number " + id);
        List<Answer> answers = questionAnswers(questionNode);
        if(answers.size() == 0)
            throw new QuestionParserException(("No answers found for question number " + id));
        Integer score = questionScore(questionNode);
        if(score == null)
            throw new QuestionParserException("Failed parsing score for question number " + id);
        return new Question(id,text,answers,score);
    }

    private String questionText(Node questionNode) {
        return questionNode.getNodeValue();
    }

    private Integer questionID(Node questionNode) throws QuestionParserException {
        String attr = questionNode.getAttributes().getNamedItem("id").getNodeValue();
        try {
            return Integer.parseInt(attr);
        } catch (Exception ex) {
            return null;
        }
    }

    private Integer questionScore(Node questionNode) throws QuestionParserException  {
       String attr = questionNode.getAttributes().getNamedItem("punti").getNodeValue();
        try {
            return Integer.parseInt(attr);
        } catch (Exception ex) {
           return null;
        }
    }

    private List<Answer> questionAnswers(Node questionNode) {
        List<Node> answerNodes = getNodesWithName(questionNode.getChildNodes(), "risposta");
        List<Answer> answerList = new ArrayList<>();
        for(Node node : answerNodes){
            answerList.add(answerFromNode(node));
        }
        return answerList;
    }

    private Answer answerFromNode(Node answerNode) {
        boolean isCorrect = answerIsCorrect(answerNode);
        String text = answerText(answerNode);
        return new Answer(text,isCorrect);
    }

    private String answerText(Node node) {
        return node.getNodeValue();
    }

    private boolean answerIsCorrect(Node node) {
        String s =  node.getAttributes().getNamedItem("corretta").getNodeValue();
        return s != null && s.equals("ok");
    }
}
