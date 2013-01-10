/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tester.creator;

import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author Myroslav
 */
public class Question implements Serializable {
    
    private int id;
    private String question;
    private HashMap<Integer, Answer> answers;
    private static final long serialVersionUID  = 2L;

    public Question(int id, String question, HashMap<Integer, Answer> answers) {
        this.id = id;
        this.question = question;
        this.answers = answers;
    }

    public Question() {
    }

    
    public HashMap<Integer, Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(HashMap<Integer, Answer> answers) {
        this.answers = answers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
    
    
    
}
