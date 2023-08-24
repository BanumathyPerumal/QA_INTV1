package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IMDB_Ratings {
    public static ChromeDriver driver;
    public IMDB_Ratings(){
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void openURL(String URL){
        driver.get(URL);
        // driver.navigate().refresh();
        driver.get(driver.getCurrentUrl()); // to refresh the page
    }
    
    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();
    }

    public void imdb_ratings(){
        String title;
        // Navigate to URL "https://www.imdb.com/chart/top" Using Locator "Name" driver.get(URL)
        // Get the title of the first movie in the list  Using Locator "XPath" //li[1]//div[@class='ipc-metadata-list-summary-item__c']//h3 | getText()
        title = getTitle();
        System.out.println("Title of the highest rated movie: "+title);
        // Get the total no. of movies listed in the table Using Locator "XPath" list | //ul[contains(@class,'compact-list-view')]//li | list.size()
        List<WebElement> list = driver.findElements(By.xpath("//ul[contains(@class,'compact-list-view')]//li"));
        System.out.println("Total number of movies listed in the table are : "+list.size());
        // "Select Release date in the Sort By drop down Using Locator ""ID"" 
        Select sortBy = new Select(driver.findElement(By.id("sort-by-selector")));
        sortBy.selectByVisibleText("Release date");
        // Click on the reverse sort order button (up and down arrows next to Sort By drop down) Using Locator "ID" swap-sort-order-button
        driver.findElement(By.id("swap-sort-order-button")).click();
        // Get the title of the first movie in the list, to get the oldest movie Using Locator "XPath" //li[1]//div[@class='ipc-metadata-list-summary-item__c']//h3 | getText()
        title = getTitle();
        System.out.println("Title of the oldest movie on the list: "+title);
        // Click on the reverse sort order button (up and down arrows next to Sort By drop down) Using Locator "ID" swap-sort-order-button
        driver.findElement(By.id("swap-sort-order-button")).click();
        // Get the title of the first movie in the list, to get the latest movie Using Locator "XPath" //li[1]//div[@class='ipc-metadata-list-summary-item__c']//h3 | getText()
        title = getTitle();
        System.out.println("Title of the most recent movie on the list: "+title);
        // "Select Number of ratings in the Sort By drop down Using Locator ""ID""         
        sortBy.selectByVisibleText("Number of ratings");
        // Get the title of the first movie in the list  Using Locator "XPath" //li[1]//div[@class='ipc-metadata-list-summary-item__c']//h3 | getText()
        title = getTitle();
        System.out.println("Title of the movie with most user ratings: "+title);
    }

    public static String getTitle(){
        String text = driver.findElement(By.xpath("//li[1]//div[@class='ipc-metadata-list-summary-item__c']//h3")).getText();
        String title = text.substring(text.indexOf(" "));
        return title;
    }

}
