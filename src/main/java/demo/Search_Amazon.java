package demo;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;



public class Search_Amazon {
    public ChromeDriver driver;
    public Search_Amazon(ChromeDriver driver){
        this.driver = driver;        
    }      

    public void searchAmazon(){       
        
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
