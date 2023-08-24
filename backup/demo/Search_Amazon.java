package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Search_Amazon {
    WebDriver driver;
    public Search_Amazon(){
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

    public void searchAmazon(){
        // Navigate to URL "https://www.google.com" Using Locator "ID" driver.get(URL)
        driver.get("https://www.google.com");
        // Enter "amazon" in Search text box Using Locator "Name" q | sendKeys("amazon")
        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("amazon");

        // Press enter key in the search text box Using Locator "Name" q | sendKeys(Keys.RETURN)
        driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
        // Verify whether amazon.in or amazon.com is present in the search results Using Locator "XPath" //span[text()='Amazon.in' or text()='Amazon.com']
        boolean result = driver.findElement(By.xpath("//span[text()='Amazon.in' or text()='Amazon.com']")).isDisplayed();
        System.out.println("Is Amazon present in results? :" + result);        

    }
}
