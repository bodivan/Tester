package tester.user;

import tester.creator.Answer;
import tester.creator.Question;
import tester.creator.Test;

import java.lang.Integer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private int countOfUserWrongAnswers;

    private void findCountOfUserRightAnwers(HashMap<Integer, List> answers, Test test) {
        countOfUserRightAnswers = 0;
        ArrayList<Question> lQ = test.getListOfQuestions();
        HashMap<Integer, Question> hQ = new HashMap<Integer, Question>();
        for(Question q : lQ){
            hQ.put(q.getId(), q);
        }
        for (Map.Entry<Integer, List> es : answers.entrySet()) {
            Question q = hQ.get(es.getKey());
            for (int j = 0; j < q.getAnswers().size(); j++) {
                if (q.getAnswers().get(es.getValue().get(j)).isIsTrue()) {
                    countOfUserRightAnswers++;
                } else {
                    countOfUserWrongAnswers++;
                }
            }
        }
    }

    private void findCountOfRightAnswers(Test test) {
        countOfRightAnswers = 0;
        ArrayList<Question> q = test.getListOfQuestions();
        for (int i = 0; i < q.size(); i++) {
            HashMap<Integer, Answer> answ = q.get(i).getAnswers();
            for (Map.Entry<Integer, Answer> es : answ.entrySet()) {
                if (es.getValue().isIsTrue()) {
                    countOfRightAnswers++;
                }
            }
        }
    }

    /**
     *
     * @param answers - answers, that user gives in test
     * @param test - test, that user is goes
     * @return
     */
    public double calculateResult(HashMap<Integer, List> answers, Test test) {
        findCountOfRightAnswers(test);
        findCountOfUserRightAnwers(answers, test);
        return ((countOfUserRightAnswers - countOfUserWrongAnswers) * 100)/countOfRightAnswers;
    }
}
