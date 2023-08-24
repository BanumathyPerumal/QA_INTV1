package demo;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class NestedFrames {
    public ChromeDriver driver;
    public NestedFrames(ChromeDriver driver){
        this.driver = driver;
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
