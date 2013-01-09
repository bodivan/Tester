package tester.user;

import tester.creator.Question;
import tester.creator.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan
 * Date: 08.01.13
 * Time: 0:41
 * To change this template use File | Settings | File Templates.
 */
public class UIController implements StartTestListener {

    private TestTimer testTimer;
    private Test currentOpenTest;
    private HashMap<Integer, Integer> userAnswers;
    private HashMap<Integer, Question> questions;
    private double testResult;
    private int currTime;
    private int minutes;
    private int seconds;

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

    public void stopTest() {
        if (!questions.isEmpty()) {
            for (int j : questions.keySet()) {
                userAnswers.put(j, -1);
            }
        }
        AnswerAnalistor analisator = new AnswerAnalistor();
        testResult = analisator.calculateResult(userAnswers, currentOpenTest);
    }

    @Override
    public Question startTest(String testFileName, String userInformation) {
        openTest(testFileName);
        questions = new HashMap<Integer, Question>();
        Question q = null;
        for (int i = 0; i <= currentOpenTest.getMapOfQuestions().size(); i++) {
            q = currentOpenTest.getMapOfQuestions().get(new Random().nextInt(currentOpenTest.getTotalQuestionsCount()));
            questions.put(q.getId(), q);
        }
        this.startTimer();
        return questions.remove(new Random().nextInt(questions.size()));
    }

    public void startTimer() {
        currTime = (currentOpenTest.getTestTimeInMinutes())*60;
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                minutes = currTime / 60;
                seconds = minutes % 60;
                testTimer.update(minutes + ":" + seconds);
                currTime--;
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, 1000);

    }

    public void proceedAnswer(int questionId, int answerId) {
        userAnswers.put(questionId, answerId);
    }

    public void proceedSkipingAnswer(Question question) {
        questions.put(question.getId(), question);
    }

    public void proceedUserChoise() {

    }

    public void setCurrentOpenTest(Test currentOpenTest) {
        this.currentOpenTest = currentOpenTest;
    }

    public Test getCurrentOpenTest() {
        return currentOpenTest;
    }

    public HashMap<Integer, Integer> getUserAnswers() {
        return userAnswers;
    }

    public void setUserAnswers(HashMap<Integer, Integer> userAnswers) {
        this.userAnswers = userAnswers;
    }

    public double getTestResult() {
        return testResult;
    }

    public TestTimer getTestTimer() {
        return testTimer;
    }
}
