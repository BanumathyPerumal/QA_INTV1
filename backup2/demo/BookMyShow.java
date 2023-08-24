package demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class BookMyShow {
    public ChromeDriver driver;
    public BookMyShow(ChromeDriver driver){        
       this.driver = driver;
    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }
    
    public void countHyperlinks(){        
        // Get all the links in the landing page, as a list of webElements Using Locator "Tag Name" a 
        List<WebElement> list = driver.findElements(By.tagName("a"));
        // Get the count of the links Using Locator "Tag Name" a | list.size
        System.out.println("No. of links in the Book My Show landing page: "+ list.size());
        
    }
    public void imageURLs(){
        String URL;
    // Find the image URLs for all the “Recommended Movies”  Using Locator "XPath" //h2[text()='Recommended Movies']/../../../following-sibling::div//a//img
    List<WebElement> image_URLs = driver.findElements(By.xpath("//h2[text()='Recommended Movies']/../../../following-sibling::div//div[contains(@class,'YeNog')]/div"));
    System.out.println("No. of image URLs: "+ image_URLs.size());
    // Print the URLs Using Locator "XPath" //h2[text()='Recommended Movies']/../../../following-sibling::div//a | .getAtttribute("href")
    for(WebElement image_URL: image_URLs){
      URL = image_URL.findElement(By.xpath("//a//img")).getAttribute("src");
      System.out.println(URL);  
    }   
    
    }
    public void premiere(){
    // Print the name of the second item under Premieres Using Locator "XPath" //h2[text()='Premieres']/../../../following-sibling::div/div/div/div[2]//div/div[3]/div/div | using getText()
    String name = driver.findElement(By.xpath("//h2[text()='Premieres']/../../../following-sibling::div/div/div/div[2]//div/div[3]/div/div")).getText();
    System.out.println("Name of the second item under Premieres: "+ name);
    // Print the language of the second item under Premieres Using Locator "XPath" //h2[text()='Premieres']/../../../following-sibling::div/div/div/div[2]//div/div[3]/div[2]/div | using getText() method
    String language = driver.findElement(By.xpath("//h2[text()='Premieres']/../../../following-sibling::div/div/div/div[2]//div/div[3]/div[2]/div")).getText();
    System.out.println("Language of the second item under Premieres: "+ language);

    }
}
