/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tester.creator;

import java.io.*;
import java.util.HashMap;

/**
 * @author Myroslav
 */
public class UIController implements Serializable {

    private Test currentOpenTest;
    private String destinatedTestDirectory;
    private String testFileName;

    public Test openTest(String testFileName) {
        ObjectInputStream in = null;
        Test test = null;
        try {
            in = new ObjectInputStream(new FileInputStream(testFileName));

            test = (Test) in.readObject();
        } catch (Exception ex) {
        } finally {
            try {
                in.close();
            } catch (IOException ex) {
            }
        }
        setCurrentOpenTest(test);
        return currentOpenTest;
    }

    public Test createTest(String destinatedTestDirectory, String testFileName) {
        Test test = new Test();
        test.setCurrentQuestionIndex(0);
        test.setTestTimeInMinutes(0);
        test.setTotalQuestionsCount(0);
        test.setQuestionToUserCount(0);
        test.setMapOfQuestions(new HashMap<Integer, Question>());
        setCurrentOpenTest(test);
        
        return currentOpenTest;
    }

    public Test addQuestion() {
        HashMap<Integer, Question> qws = currentOpenTest.getMapOfQuestions();
        int id = qws.size() + 1;
        HashMap<Integer, Answer> answ = new HashMap<Integer, Answer>(8);
        qws.put(id, new Question(id, "", answ));
        currentOpenTest.setCurrentQuestionIndex(id);
        currentOpenTest.setTotalQuestionsCount(id);
        return currentOpenTest;
    }

    public Test removeQuestion() {
        HashMap<Integer, Question> qws = currentOpenTest.getMapOfQuestions();
        qws.remove(currentOpenTest.getCurrentQuestionIndex());
        currentOpenTest.setCurrentQuestionIndex(qws.size());
        currentOpenTest.setTotalQuestionsCount(qws.size());
        return currentOpenTest;
    }

    public Test addAnswerToQuestion() {
        Question q = currentOpenTest.getMapOfQuestions().get(currentOpenTest.getCurrentQuestionIndex());

        HashMap<Integer, Answer> answ = q.getAnswers();
        int id = answ.size() + 1;
        answ.put(id, new Answer(id, "", false));
        return currentOpenTest;

    }

    public Test removeAnswerFromQuestion() {
        Question q = currentOpenTest.getMapOfQuestions().get(currentOpenTest.getCurrentQuestionIndex());

        HashMap<Integer, Answer> answ = q.getAnswers();
        int id = answ.size();
        answ.remove(id);
        return currentOpenTest;

    }

    public void saveTest(String fileNameToSave, Test test) {
        ObjectOutputStream o = null;
        try {
            o = new ObjectOutputStream(new FileOutputStream(fileNameToSave));
            o.writeObject(test);
            o.close();
        } catch (IOException ex) {
        } finally {
            try {
                o.close();
            } catch (IOException ex) {
            }
        }
    }

    public Test increaseCurrentQuestionIndex() {
        int val = currentOpenTest.getCurrentQuestionIndex();
        currentOpenTest.setCurrentQuestionIndex((val + 1) > currentOpenTest.getTotalQuestionsCount() ? currentOpenTest.getTotalQuestionsCount() : val + 1);
        return currentOpenTest;
    }

    public Test decreaseCurrentQuestionIndex() {
        int val = currentOpenTest.getCurrentQuestionIndex();
        currentOpenTest.setCurrentQuestionIndex(((val - 1) < 1) ? 1 : val - 1);
        return currentOpenTest;
    }

    public Test getCurrentOpenTest() {
        return currentOpenTest;
    }

    public void setCurrentOpenTest(Test currentOpenTest) {
        this.currentOpenTest = currentOpenTest;
    }

    public String getDestinatedTestDirectory() {
        return destinatedTestDirectory;
    }

    public void setDestinatedTestDirectory(String destinatedTestDirectory) {
        this.destinatedTestDirectory = destinatedTestDirectory;
    }

    public String getTestFileName() {
        return testFileName;
    }

    public void setTestFileName(String testFileName) {
        this.testFileName = testFileName;
    }
}
