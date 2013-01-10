/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tester.creator;

import java.io.*;
import java.util.*;

/**
 * @author Myroslav
 */
public class UIController implements Serializable {

    private Test currentOpenTest;
    private String fileNameToSave;

    public Test openTest(String testFileName) {
        this.fileNameToSave = testFileName;
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

    public void saveAsTest(String fileNameToSave, String fileName, Test test) {
        this.fileNameToSave = fileNameToSave;
        ObjectOutputStream o = null;
        try {
            o = new ObjectOutputStream(new FileOutputStream(fileNameToSave));
            test.setTestName(fileName);
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

    public void saveTest(Test test) {
        if (fileNameToSave == null) {
            fileNameToSave = "./" + test.getTestName();
        }
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


    public Question getCurrentQuestion() {
        ArrayList<Question> qws = currentOpenTest.getListOfQuestions();
        if (qws.size() > 0) {
            return qws.get(currentOpenTest.getCursor());
        } else {
            return null;
        }
    }

    public Test createTest(String testFileName) {
        Test test = new Test();
        test.setTestName(testFileName);
        test.setCursor(0);
        test.setTestTimeInMinutes(1);
        test.setTotalQuestionsCount(0);       
        test.setListOfQuestions(new ArrayList<Question>());
        setCurrentOpenTest(test);
        addQuestion();
        test.setQuestionToUserCount(1);
        return currentOpenTest;
    }

    public Test addQuestion() {
        ArrayList<Question> qws = currentOpenTest.getListOfQuestions();
        int position = qws.size();
        HashMap<Integer, Answer> answ = new HashMap<Integer, Answer>(8);
        qws.add(position, new Question(new Random().nextInt(), "", answ));
        currentOpenTest.setCursor(position);
        currentOpenTest.setTotalQuestionsCount(qws.size());
        return currentOpenTest;
    }

    public Test removeQuestion() {
        ArrayList<Question> qws = currentOpenTest.getListOfQuestions();
        if (qws.size() > 0) {
            qws.remove(currentOpenTest.getCursor());
            currentOpenTest.setCursor(qws.size() - 1);
            currentOpenTest.setTotalQuestionsCount(qws.size());
        } else {

        }
        return currentOpenTest;
    }

    public Test addAnswerToQuestion() {
        Question q = currentOpenTest.getListOfQuestions().get(currentOpenTest.getCursor());

        HashMap<Integer, Answer> answ = q.getAnswers();
        int id = answ.size();
        answ.put(id, new Answer(id, "", false));
        return currentOpenTest;

    }

    public Test removeAnswerFromQuestion() {
        Question q = currentOpenTest.getListOfQuestions().get(currentOpenTest.getCursor());

        HashMap<Integer, Answer> answ = q.getAnswers();
        int id = answ.size();
        answ.remove(id);
        return currentOpenTest;

    }


    public Test increaseCurrentQuestionIndex() {
        int n = currentOpenTest.getCursor() + 1;
        currentOpenTest.setCursor(n >= currentOpenTest.getListOfQuestions().size() ? n - 1 : n);
        return currentOpenTest;
    }

    public Test decreaseCurrentQuestionIndex() {
        int p = currentOpenTest.getCursor() - 1;
        currentOpenTest.setCursor(p < 0 ? (currentOpenTest.getListOfQuestions().isEmpty() ? -1 : 0) : p);
        return currentOpenTest;
    }

    public Test getCurrentOpenTest() {
        return currentOpenTest;
    }

    public void setCurrentOpenTest(Test currentOpenTest) {
        this.currentOpenTest = currentOpenTest;
    }
}
