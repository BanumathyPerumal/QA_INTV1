package demo;

import java.util.concurrent.TimeUnit;
import java.sql.Timestamp;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;


public class TestCases {
    static ChromeDriver driver;
    
    public void createDriver(){
        System.out.println("Test suite starts - Create Driver happening....");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public static void openURL(String URL){
        driver.get(URL);
        // driver.navigate().refresh();
        driver.get(driver.getCurrentUrl()); // to refresh the page
    }
    
    public void endTest()
    {
        System.out.println("End Test: TestCases\n");
        driver.close();
        driver.quit();
    }
    
    public  void testCase01() throws InterruptedException {
        System.out.println("\nStart Test case: testCase01");
        // Navigate to URL "https://www.google.com" Using Locator "ID" driver.get(URL)
        openURL("https://www.google.com");
        Thread.sleep(300);
        Search_Amazon search = new Search_Amazon(driver);
        search.searchAmazon();
    }

    public  void testCase02() throws InterruptedException {
        System.out.println("\nStart Test case: testCase02");
        // Navigate to URL "https://in.bookmyshow.com/explore/home/chennai" 
        openURL("https://in.bookmyshow.com/explore/home/chennai");
        Thread.sleep(300);
        BookMyShow bookMyShow = new BookMyShow(driver);
        bookMyShow.countHyperlinks();
    }

    public  void testCase03() throws InterruptedException {
        System.out.println("\nStart Test case: testCase03");
         // Navigate to URL "https://in.linkedin.com"
        openURL("https://in.linkedin.com");
        Thread.sleep(300);
        LinkedIn linkedIn = new LinkedIn(driver);
        linkedIn.signIn("mailid@gmail.com", "password");
        linkedIn.printCount();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String time = String.valueOf(timestamp);
        linkedIn.createPost("Test Message "+time);
    }

    public  void testCase04() throws InterruptedException {
        System.out.println("\nStart Test case: testCase04");
    }

    public  void testCase05() throws InterruptedException {
        System.out.println("\nStart Test case: testCase05");
        // Navigate to URL "https://in.bookmyshow.com/explore/home/chennai" 
        openURL("https://in.bookmyshow.com/explore/home/chennai");
        Thread.sleep(300);
        BookMyShow bookMyShow = new BookMyShow(driver);
        bookMyShow.imageURLs();
        // bookMyShow.premiere(); 
    }

    public  void testCase06() throws InterruptedException {
        System.out.println("\nStart Test case: testCase06");
        // Navigate to URL "https://in.linkedin.com"
        openURL("https://in.linkedin.com");
        Thread.sleep(300);
        LinkedIn linkedIn = new LinkedIn(driver);
        linkedIn.signIn("mailid@gmail.com", "password");
        linkedIn.postImage();
    }

    public  void testCase07() throws InterruptedException {
        System.out.println("\nStart Test case: testCase07");
        //Navigate to URL "https://the-internet.herokuapp.com/nested_frames"
        openURL("https://the-internet.herokuapp.com/nested_frames");
        Thread.sleep(300);
        NestedFrames frameObj = new NestedFrames(driver);
        frameObj.getBodyText();
    }

    public  void testCase08() throws InterruptedException {
        System.out.println("\nStart Test case: testCase08");
    }

    public  void testCase09() throws InterruptedException {
        System.out.println("\nStart Test case: testCase09");
        //Navigate to URL "https://www.imdb.com/chart/top"
        openURL("https://www.imdb.com/chart/top");
        Thread.sleep(300);
        IMDB_Ratings IMDBTest = new IMDB_Ratings(driver);
        IMDBTest.imdb_ratings();
    }

    public  void testCase10() throws InterruptedException {
        System.out.println("\nStart Test case: testCase10");
         // Navigate to URL "https://www.w3schools.com/jsref/tryit.aspfilename=tryjsref_win_open"
         openURL("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");
         Thread.sleep(300);
         WindowHandle windowHandleTest = new WindowHandle(driver);
         windowHandleTest.windowHandle();
    }

}
