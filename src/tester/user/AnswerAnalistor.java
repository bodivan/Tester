package tester.user;

import tester.creator.Answer;
import tester.creator.Question;
import tester.creator.Test;

import java.lang.Integer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
        ArrayList<Question> lQ = test.getListOfQuestions();
        HashMap<Integer, Question> hQ = new HashMap<Integer, Question>();
        for(Question q : lQ){
            hQ.put(q.getId(), q);
        }
        for (Map.Entry<Integer, Integer> es : answers.entrySet()) {
            Question q = hQ.get(es.getKey());
            if (q.getAnswers().get(es.getValue()).isIsTrue()) {
                countOfUserRightAnswers++;
            }
        }
        return countOfUserRightAnswers;
    }

    private int findCountOfRightAnswers(Test test) {
        int countOfRightAnswers = 0;
        for (int i = 0; i < test.getListOfQuestions().size(); i++) {
            ArrayList<Question> q = test.getListOfQuestions();
            HashMap<Integer, Answer> answ = q.get(i).getAnswers();
            for (Map.Entry<Integer, Answer> es : answ.entrySet()) {
                if (es.getValue().isIsTrue()) {
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
