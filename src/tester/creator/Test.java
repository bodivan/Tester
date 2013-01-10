/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tester.creator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.TreeMap;

/**
 *
 * @author Myroslav
 */
public class Test implements Serializable {
    
    private int id;
    private String testName;
    private int testTimeInMinutes;
    private ArrayList<Question> listOfQuestions;

    private int totalQuestionsCount;
    private int questionToUserCount;
    private int cursor;

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public ArrayList<Question> getListOfQuestions() {
        return listOfQuestions;
    }

    public void setListOfQuestions(ArrayList<Question> listOfQuestions) {
        this.listOfQuestions = listOfQuestions;
    }

    public int getCursor() {
        return cursor;
    }

    public void setCursor(int cursor) {
        this.cursor = cursor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
