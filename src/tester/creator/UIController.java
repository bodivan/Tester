/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tester.creator;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.GZIPOutputStream;

/**
 * @author Myroslav
 */
public class UIController implements Serializable {

    private Test currentOpenTest;
    private String destinatedTestDirectory;
    private String testFileName;


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

    public void createTest(String destinatedTestDirectory, String testFileName) {

    }

    public void saveTest(String fileNameToSave, Test test) {
        ObjectOutputStream o = null;
        try {
            o = new ObjectOutputStream(new FileOutputStream(fileNameToSave));
            o.writeObject(test);
            o.close();
        } catch (IOException ex) {
        } finally {
            try {
                o.close();
            } catch (IOException ex) {
            }
        }
    }

    public Test getCurrentOpenTest() {
        return currentOpenTest;
    }

    public void setCurrentOpenTest(Test currentOpenTest) {
        this.currentOpenTest = currentOpenTest;
    }

    public String getDestinatedTestDirectory() {
        return destinatedTestDirectory;
    }

    public void setDestinatedTestDirectory(String destinatedTestDirectory) {
        this.destinatedTestDirectory = destinatedTestDirectory;
    }

    public String getTestFileName() {
        return testFileName;
    }

    public void setTestFileName(String testFileName) {
        this.testFileName = testFileName;
    }


}
