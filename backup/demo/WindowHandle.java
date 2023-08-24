package demo;

import java.io.File;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.sql.Timestamp;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandle {
    ChromeDriver driver;
    public WindowHandle(){
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

    public void openURL(String URL){
        // Navigate to URL "https://www.w3schools.com/jsref/tryit.aspfilename=tryjsref_win_open" Using Locator "XPath" driver.get(URL)
        driver.get(URL);
        driver.get(driver.getCurrentUrl()); // to refresh the page
    }

    public void windowHandle(){
        // Get current window handle Using Locator "ID" String parentWindow = driver.getWindowHandle()
        String parentWindow = driver.getWindowHandle();
        String URL = driver.getCurrentUrl();
        // Click on Try it button Using Locator "XPath" //button[text()='Try it']
        driver.switchTo().frame("iframeResult");
        driver.findElement(By.xpath("//button[text()='Try it']")).click();
        // New page opens in new tab. And that becomes the current page. Get the current page URL Using Locator "ID" currentURL = driver.getCurrentUrl()
        driver.switchTo().defaultContent();
        
        // Get all window handles Using Locator "ID" driver.getWindowHandles()
        Set<String> handles = driver.getWindowHandles();
        // "Loop through the window handles. If not equal to parent window, then switch to that window and Get page title of current page Using Locator ""ID"" driver.switchTo().window(otherWindow)
        for(String handle: handles){
            if(!parentWindow.equals(handle)){
                driver.switchTo().window(handle);
                String currentURL = driver.getCurrentUrl();
                // Verify the current page URL is not same as the URL opened in step 2 Using Locator "ID" currentURL = driver.getCurrentUrl()
                boolean sameURL = URL.equals(currentURL);
                System.out.println("Is the current URL same as the URL before clicking Try it button? : "+sameURL);
                // driver.getTitle()
                String title = driver.getTitle();
                System.out.println("Page title: "+title);
                // Take screenshot Using Locator "ID" Call takeScreenShot method
                takeScreenshot(driver, "Test", "NewlyOpenedTab");
                // "Close the window and switch to parent window Using Locator ""ID"" driver.close()
                driver.close();
                // driver.switchTo().window(parentWindow)"
                driver.switchTo().window(parentWindow);

            }
        }    
    }

    public static void takeScreenshot(WebDriver driver, String screenshotType, String description) {
        try {
            File theDir = new File("/screenshots");
            if (!theDir.exists()) {
                theDir.mkdirs();
            }
            // String timestamp = String.valueOf(java.time.LocalDateTime.now());
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            String time_stamp = String.valueOf(timestamp.getTime());
            // System.out.println("timestamp: "+time_stamp);

            String fileName = String.format("screenshot_%s_%s_%s.png", time_stamp, screenshotType, description);
            TakesScreenshot scrShot = ((TakesScreenshot) driver);
            File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
            File DestFile = new File("screenshots/" + fileName);
            FileUtils.copyFile(SrcFile, DestFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
}
