package tester.user;

import tester.creator.Test;

import java.lang.Integer;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan
 * Date: 08.01.13
 * Time: 0:38
 * To change this template use File | Settings | File Templates.
 */
public class AnswerAnalistor {

    public int findCountOfUserRightAnwers(HashMap<Integer, Integer> answers, Test test) {
        int countOfUserRightAnswers = 0;
        for (int i=0; i<=answers.size(); i++) {
            if (test.getMapOfQuestions().get(i).getAnswers().get(answers.get(i)).isIsTrue()) {
                countOfUserRightAnswers++;
            }
        }
        return countOfUserRightAnswers;
    }

    private int findCountOfRightAnswers(Test test) {
        int countOfRightAnswers = 0;
        for (int j = 0; j <= test.getMapOfQuestions().size(); j++) {
            for (int h = 0; h <= test.getMapOfQuestions().get(j).getAnswers().size(); h++) {
                if (test.getMapOfQuestions().get(j).getAnswers().get(h).isIsTrue()) {
                    countOfRightAnswers++;
                }
            }
        }
        return countOfRightAnswers;
    }

    /**
     *
     * @param answers - answers, that user gives in test
     * @param test - test, that user is goes
     * @return
     */
    public double calculateResult(HashMap<Integer, Integer> answers, Test test) {
        return (findCountOfUserRightAnwers(answers, test) * 100)/findCountOfRightAnswers(test);
    }
}
