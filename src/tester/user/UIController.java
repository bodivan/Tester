package tester.user;

import tester.creator.Question;
import tester.creator.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan
 * Date: 08.01.13
 * Time: 0:41
 * To change this template use File | Settings | File Templates.
 */
public class UIController implements StartTestListener {

    private Timer timer;
    private TestTimer testTimer;
    private Test currentOpenTest;
    private HashMap<Integer, List<Integer>> userAnswers;
    private LinkedList<Question> questions;
    private LinkedList<Question> initQuestions;
    private double testResult;
    private int currTime;
    private int minutes;
    private int seconds;
    private Question currentQuestion;
    private String userInformation;

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
            for (int j = 0; j <= questions.size(); j++) {
                userAnswers.put(j, null);
            }
        }
        timer.cancel();
        AnswerAnalistor analisator = new AnswerAnalistor();
        testResult = analisator.calculateResult(userAnswers, initQuestions);
    }

    @Override
    public Question startTest(String testFileName, String userInformation) {
        openTest(testFileName);
        setUserInformation(userInformation);
        userAnswers = new HashMap<Integer, List<Integer>>();
        questions = new LinkedList<Question>();

        Question q = null;
        ArrayList<Question> list = new ArrayList<Question>();
        initQuestions = new LinkedList<Question>();
        list.addAll(currentOpenTest.getListOfQuestions());
        for (int i = 0; i < currentOpenTest.getQuestionToUserCount(); i++) {
            q = list.remove(new Random().nextInt(list.size()));
            questions.add(i, q);
        }
        initQuestions.addAll(questions);
        this.startTimer();
        currentQuestion = questions.removeLast();
        return currentQuestion;
    }

    public Question proceedAnswer(List<Integer> answerIds) {
        userAnswers.put(currentQuestion.getId(), answerIds);
        if (questions.size() == 0) {
            stopTest();
            testTimer.stopTest(userInformation + ": " + testResult);
            return null;
        }
        currentQuestion = questions.removeLast();
        return currentQuestion;
    }

    public Question proceedSkipingAnswer() {
        questions.add(0, currentQuestion);
        currentQuestion = questions.removeLast();
        return currentQuestion;
    }

    public void startTimer() {
        currTime = (currentOpenTest.getTestTimeInMinutes())*60;
        timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                minutes = currTime / 60;
                seconds = currTime % 60;
                testTimer.update(minutes + ":" + seconds, questions.size(), userAnswers.size());
                if (currTime-- == 0) {
                    stopTest();
                    testTimer.stopTest(userInformation + ": " + testResult);
                }
            }
        };
        timer.scheduleAtFixedRate(task, 0, 1000);
    }

    public void setCurrentOpenTest(Test currentOpenTest) {
        this.currentOpenTest = currentOpenTest;
    }

    public Test getCurrentOpenTest() {
        return currentOpenTest;
    }

    public HashMap<Integer, List<Integer>> getUserAnswers() {
        return userAnswers;
    }

    public void setUserAnswers(HashMap<Integer, List<Integer>> userAnswers) {
        this.userAnswers = userAnswers;
    }

    public double getTestResult() {
        return testResult;
    }

    public TestTimer getTestTimer() {
        return testTimer;
    }

    public void setTestTimer(TestTimer testTimer) {
        this.testTimer = testTimer;
    }

    public void setUserInformation(String userInformation) {
        this.userInformation = userInformation;
    }
}
