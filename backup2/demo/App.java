/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package demo;
import java.net.MalformedURLException;


public class App {
    public void getGreeting() throws InterruptedException, MalformedURLException {
        TestCases tests = new TestCases(); // Initialize your test class

        //TODO: call your test case functions one after other here
        tests.createDriver();
        tests.testCase01();
        tests.endTest();

        tests.createDriver(); 
        tests.testCase02();
        tests.endTest();

        tests.createDriver(); 
        tests.testCase03();
        tests.endTest();
        
        tests.createDriver(); 
        tests.testCase05();
        tests.endTest();

        tests.createDriver(); 
        tests.testCase06();
        tests.endTest();

        tests.createDriver(); 
        tests.testCase07();
        tests.endTest();

        tests.createDriver(); 
        tests.testCase09();
        tests.endTest();

        tests.createDriver(); 
        tests.testCase10();
        tests.endTest();
    }

    public static void main(String[] args) throws InterruptedException, MalformedURLException {
        new App().getGreeting();
    }
}
