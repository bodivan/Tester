package tester.user;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan
 * Date: 08.01.13
 * Time: 1:54
 * To change this template use File | Settings | File Templates.
 */
public interface TestTimer {

    public long update(String currTime, String totalTime);

    public void stopTest(UIController controller);
}
