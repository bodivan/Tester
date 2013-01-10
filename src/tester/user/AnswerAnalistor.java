package tester.user;

import tester.creator.Answer;
import tester.creator.Question;
import tester.creator.Test;

import java.lang.Integer;
import java.util.*;

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

    private void findCountOfUserRightAnwers(HashMap<Integer, List<Integer>> answers, LinkedList<Question> lQ) {
        countOfUserRightAnswers = 0;
        HashMap<Integer, Question> hQ = new HashMap<Integer, Question>();
        for(Question q : lQ){
            hQ.put(q.getId(), q);
        }
        for (Map.Entry<Integer, List<Integer>> es : answers.entrySet()) {
            Question q = hQ.get(es.getKey());
            List<Integer> listAnswers = es.getValue();
            for (int j = 0; j < listAnswers.size(); j++) {
                int answer = listAnswers.get(j);
                if (q.getAnswers().get(answer).isIsTrue()) {
                    countOfUserRightAnswers++;
                } else {
                    countOfUserWrongAnswers++;
                }
            }
        }
    }

    private void findCountOfRightAnswers(LinkedList<Question> q) {
        countOfRightAnswers = 0;
        for (int i = 0; i < q.size(); i++) {
            HashMap<Integer, Answer> answ = q.get(i).getAnswers();
            for (Map.Entry<Integer, Answer> es : answ.entrySet()) {
                if (es.getValue().isIsTrue()) {
                    countOfRightAnswers++;
                }
            }
        }
    }


    public double calculateResult(HashMap<Integer, List<Integer>> answers, LinkedList<Question> q) {
        findCountOfRightAnswers(q);
        findCountOfUserRightAnwers(answers, q);
        return ((countOfUserRightAnswers - countOfUserWrongAnswers) * 100)/countOfRightAnswers;
    }
}
