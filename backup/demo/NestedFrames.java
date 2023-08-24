package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NestedFrames {
    ChromeDriver driver;
    public NestedFrames(){
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void openURL(String URL){
        driver.get(URL);
    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    public void getBodyText(){
        String text;
        String name;
    //  Get the frames in the page, as a list of webElements Using Locator "XPath" //frameset//frame | list
    List<WebElement> frameElements = driver.findElements(By.xpath("//frameset//frame"));
    // For each element in the list, switch to the frame, get the text of the element "body" , print the text and switch back to parent Using Locator "XPath" //body | getText() method, inside the for each loop
    for(WebElement frameElement: frameElements){
        name = frameElement.getAttribute("name");
        
        if(!name.contains("top")){ 
            driver.switchTo().frame(frameElement);           
            text = driver.findElement(By.xpath("//body")).getText();
            System.out.println("Frame text is: "+text);
            driver.switchTo().defaultContent();
        }  
        else{
            driver.switchTo().frame(frameElement);
           List<WebElement> innerFrameElements = driver.findElements(By.xpath("//frameset//frame"));
           for(WebElement innerFrameElement: innerFrameElements){
            driver.switchTo().frame(innerFrameElement);
            text = driver.findElement(By.xpath("//body")).getText();
            System.out.println("Frame text is: "+text);
            driver.switchTo().parentFrame();
           }
           driver.switchTo().defaultContent();
        }      
    }
        
    }
    
}
