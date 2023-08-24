package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.asm.Advice.Enter;

public class LinkedIn {
    ChromeDriver driver;
    public LinkedIn(){
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
    public void signIn(String mailId, String Password){
        // Navigate to URL "https://in.linkedin.com" Using Locator "XPath" driver.get(URL)
        driver.get("https://in.linkedin.com");
        // Click on Sign In link Using Locator "Link Text" Sign In
        // boolean displayed = driver.findElement(By.xpath("//button[text()=' Sign in ']")).isDisplayed();
        // if(displayed) driver.findElement(By.xpath("//button[text()=' Sign in ']")).click();
        // Enter Email ID Using Locator "XPath" //input[@autocomplete='username'] | sendKeys(mailid)
        driver.findElement(By.xpath("//input[@autocomplete='username']")).sendKeys(mailId);
        // Enter Password Using Locator "XPath" //input[@autocomplete='current-password'] | sendKeys(password)
        driver.findElement(By.xpath("//input[@autocomplete='current-password']")).sendKeys(Password);
        // Click on Sign In button  //button[@data-id='sign-in-form__submit-btn'] | click()
        driver.findElement(By.xpath("//button[@data-id='sign-in-form__submit-btn']")).click();
    }

    public void printCount(){
        String text = "";        
        // On the home page, verify the text "Who's viewed your profile" is displayed Using Locator "XPath" //ul[@class='entity-list row']//li[1]//a[@href='/me/profile-views/']//span[1]  | use getText()
        text = driver.findElement(By.xpath("//ul[@class='entity-list row']//li[1]//a[@href='/me/profile-views/']//span[1]")).getText();
        System.out.println("Is the text Who's viewed your profile displayed? :"+ text.equals("Who's viewed your profile"));
        // On the home page, read the count next to "Who's viewed your profile"  Using Locator "XPath" //ul[@class='entity-list row']//li[1]//a[@href='/me/profile-views/']//span[2]  | use getText()
        text = driver.findElement(By.xpath("//ul[@class='entity-list row']//li[1]//a[@href='/me/profile-views/']")).getText();
        System.out.println("No. of people who's viewed your profile is: "+ text);
        // On the home page, verify the text "Impressions on your post" is displayed Using Locator "XPath" //ul[@class='entity-list row']//li[2]//a//span[1] | use getText()
        text = driver.findElement(By.xpath("//ul[@class='entity-list row']//li[2]//a")).getText();
        System.out.println("Is the text Impressions of your post displayed?: "+text.contains("Impressions of your post"));
        // On the 1home page, read the count next to "Impressions on your post"  Using Locator "XPath" //ul[@class='entity-list row']//li[2]//a//span[2] | use getText()
        text = driver.findElement(By.xpath("//ul[@class='entity-list row']//li[2]//a")).getText();
        System.out.println("Impressions on your post is : "+text);
    }

    public void createPost(String message) throws InterruptedException{
        // Click on Start a Post button Using Locator "Xpath" "//button[contains(@class,'share-box-feed-entry__trigger')]"
        WebElement StartPostButton = driver.findElement(By.xpath("//button[contains(@class,'share-box-feed-entry__trigger')]"));
        StartPostButton.click();
        Thread.sleep(500);
        // Select the drop down Using Locator "XPath" //button[@class='share-unified-settings-entry-button']
        driver.findElement(By.xpath("//button[@class='share-unified-settings-entry-button']")).click();
        Thread.sleep(500);
        // Select 'Connections Only' radio button Using Locator "XPath" //input[@id='sharing-shared-generic-list-radio-CONNECTIONS_ONLY']
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//input[@id='sharing-shared-generic-list-radio-CONNECTIONS_ONLY']"))).click().perform();
        // driver.findElement(By.xpath("//input[@id='sharing-shared-generic-list-radio-CONNECTIONS_ONLY']")).click();
        // Click on Done Using Locator "XPath" "//button[contains(@class,'share-box-footer__primary-btn')]"
        driver.findElement(By.xpath("//button[contains(@class,'share-box-footer__primary-btn')]")).click();
        // Enter the content of the post, in the text area "What do you want to talk about?" Using Locator "XPath" //div[@role='dialog']//div[@data-placeholder='What do you want to talk about?']
        driver.findElement(By.xpath("//div[@role='dialog']//div[@data-placeholder='What do you want to talk about?']")).sendKeys(message);
        Thread.sleep(500);
        // Click on Post button Using Locator "XPath" //button[contains(@class,'share-actions__primary-action')]
        // action.moveToElement(driver.findElement(By.xpath("//div[@class='share-creation-state__bottom']//button[contains(@class,'primary-action')]"))).click().perform();
        driver.findElement(By.xpath("//div[@class='share-creation-state__bottom']//button[contains(@class,'primary-action')]")).click();
        System.out.println("Clicked on Post button");
        Thread.sleep(15000);
        // driver.findElement(By.xpath("//button[contains(@class,'share-actions__primary-action')]")).click();
        // Verify 'Post successful' alert is coming Using Locator "XPath" //p[@role='alert']//span | use getText()
        System.out.println("Post successful alert is displayed? "+driver.findElement(By.xpath("//p[@role='alert']")).isDisplayed());
        String text = driver.findElement(By.xpath("//p[@role='alert']//span")).getText();
        System.out.println(text);
        System.out.println("Is the post successful? :"+ text.equals("Post successful."));
        // Close the alert Using Locator "XPath" //button[contains(@class,'item__dismiss artdeco-button')]
        driver.findElement(By.xpath("//button[contains(@class,'item__dismiss artdeco-button')]")).click();

    }

    public void postImage() throws InterruptedException{
         // Click on Start a Post button Using Locator "Xpath" "//button[contains(@class,'share-box-feed-entry__trigger')]"
        WebElement StartPostButton = driver.findElement(By.xpath("//button[contains(@class,'share-box-feed-entry__trigger')]"));
        StartPostButton.click();
        Thread.sleep(500);
        // Select the drop down Using Locator "XPath" //button[@class='share-unified-settings-entry-button']
        driver.findElement(By.xpath("//button[@class='share-unified-settings-entry-button']")).click();
        Thread.sleep(500);
        // Select 'Connections Only' radio button Using Locator "XPath" //input[@id='sharing-shared-generic-list-radio-CONNECTIONS_ONLY']
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//input[@id='sharing-shared-generic-list-radio-CONNECTIONS_ONLY']"))).click().perform();
        // driver.findElement(By.xpath("//input[@id='sharing-shared-generic-list-radio-CONNECTIONS_ONLY']")).click();
        // Click on Done Using Locator "XPath" "//button[contains(@class,'share-box-footer__primary-btn')]"
        driver.findElement(By.xpath("//button[contains(@class,'share-box-footer__primary-btn')]")).click();
        // Click on image icon to add photo Using Locator "XPath" //span//button[@aria-label='Add a photo']
        driver.findElement(By.xpath("//span//button[@aria-label='Add a photo']")).click();
        // Enter the path of the image file Using Locator "XPath" //input[@type='file'] | sendKeys(filepath)
        driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\Users\\Banumathy\\Pictures\\Saved Pictures\\Baby.JPG");
        Thread.sleep(30000);
        // Click on Done button Using Locator "XPath" //span[text()='Done']//parent::button
        driver.findElement(By.xpath("//span[text()='Done']//parent::button")).click();
        // Click on Post button Using Locator "XPath" //button[contains(@class,'share-actions__primary-action')]
        driver.findElement(By.xpath("//div[@class='share-creation-state__bottom']//button[contains(@class,'primary-action')]")).click();
        System.out.println("Clicked on Post button");
        Thread.sleep(10000);
        // driver.findElement(By.xpath("//button[contains(@class,'share-actions__primary-action')]")).click();
        // Verify 'Post successful' alert is coming Using Locator "XPath" //p[@role='alert']//span | use getText()
        System.out.println("Post successful alert is displayed? "+driver.findElement(By.xpath("//p[@role='alert']")).isDisplayed());
        String text = driver.findElement(By.xpath("//p[@role='alert']//span")).getText();
        System.out.println(text);
        System.out.println("Is the post successful? :"+ text.equals("Post successful."));
        // Close the alert Using Locator "XPath" //button[contains(@class,'item__dismiss artdeco-button')]
        driver.findElement(By.xpath("//button[contains(@class,'item__dismiss artdeco-button')]")).click();

    }


    
}
