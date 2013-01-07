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
public class Test implements Serializable {
    
    private int id;
    private int testTimeInMinutes;
    private HashMap<Integer, Question> mapOfQuestions;
    private int totalQuestionsCount;
    private int questionToUserCount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public HashMap<Integer, Question> getMapOfQuestions() {
        return mapOfQuestions;
    }

    public void setMapOfQuestions(HashMap<Integer, Question> mapOfQuestions) {
        this.mapOfQuestions = mapOfQuestions;
    }

    public int getQuestionToUserCount() {
        return questionToUserCount;
    }

    public void setQuestionToUserCount(int questionToUserCount) {
        this.questionToUserCount = questionToUserCount;
    }

    public int getTestTimeInMinutes() {
        return testTimeInMinutes;
    }

    public void setTestTimeInMinutes(int testTimeInMinutes) {
        this.testTimeInMinutes = testTimeInMinutes;
    }

    public int getTotalQuestionsCount() {
        return totalQuestionsCount;
    }

    public void setTotalQuestionsCount(int totalQuestionsCount) {
        this.totalQuestionsCount = totalQuestionsCount;
    }
    
    
    
}
