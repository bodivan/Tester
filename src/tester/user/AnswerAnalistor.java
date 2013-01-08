package tester.user;

import tester.creator.Answer;
import tester.creator.Question;
import tester.creator.Test;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan
 * Date: 08.01.13
 * Time: 0:38
 * To change this template use File | Settings | File Templates.
 */
public class AnswerAnalistor {

    private int countOfRightAnswers;
    private int countOfUserRightAnswers;
    private int testTimeInMinutes;
    private int questionsCount;

    /**
     *
     * @param answers - answers, that user gives in test
     * @param test - test, that user is goes
     * @return
     */
    public int analizeAnwers(HashMap<Integer, Integer> answers, Test test) {
        for (int i=0; i<=answers.size(); i++) {

        }
        return 0;
    }
}
