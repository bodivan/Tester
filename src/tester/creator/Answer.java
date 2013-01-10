/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tester.creator;

import java.io.Serializable;

/**
 *
 * @author Myroslav
 */
public class Answer implements Serializable {
    
    private int id;
    private String answer;
    private boolean isTrue;
    private static final long serialVersionUID  = 1L;

    public Answer(int id, String answer, boolean isTrue) {
        this.id = id;
        this.answer = answer;
        this.isTrue = isTrue;
    }

    
    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isIsTrue() {
        return isTrue;
    }

    public void setIsTrue(boolean isTrue) {
        this.isTrue = isTrue;
    }
    
    
}
