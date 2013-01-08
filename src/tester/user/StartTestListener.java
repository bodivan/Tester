package tester.user;

import tester.creator.Question;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan
 * Date: 08.01.13
 * Time: 1:57
 * To change this template use File | Settings | File Templates.
 */
public interface StartTestListener {

    public Question startTest(String testFileName, String userInformation);
}
