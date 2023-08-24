package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
//Selenium Imports
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
///


public class TestCases {
    ChromeDriver driver;
    public TestCases()
    {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();
    }

    
    public  void testCase01() throws InterruptedException {
        System.out.println("Start Test case: testCase01...");
        driver.get("https://www.google.com");
        System.out.println("Opened Google page");
        Thread.sleep(1000);
        // WebElement searchBox = driver.findElement(By.xpath("//textarea[@name='q']"));
        WebElement searchBox = driver.findElement(By.name("q"));
        System.out.println("Located searchbox? :"+searchBox.isDisplayed());
        searchBox.clear();
        searchBox.sendKeys("amazon");
        searchBox.sendKeys(Keys.RETURN);
        Thread.sleep(2000);
        List<WebElement> results= driver.findElements(By.xpath("//span[text()='Amazon.in' or text()='Amazon.com']"));
        boolean resultContainsAmazon = results.size()>0? true: false;
        if(resultContainsAmazon) System.out.println("Amazon.in or Amazon.com is present in the search result");
        else System.out.println("Amazon.in or Amazon.com is not present in the search result");
        System.out.println("end Test case: testCase01");
    }


}
