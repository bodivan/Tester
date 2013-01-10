package tester.user;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan
 * Date: 08.01.13
 * Time: 1:54
 * To change this template use File | Settings | File Templates.
 */
public interface TestTimer {

    public void update(String timeRemaining, int totalCountOfQuestions, int countAnsweredQuestions);

    public void stopTest(String result);
}
