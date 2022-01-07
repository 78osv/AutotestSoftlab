package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import pages.BasePage;
import pages.SoftLabHomePage;
import pages.SolutionsPage;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    public static BasePage basePage;
    public static SoftLabHomePage softLabHomePage;
    public static SolutionsPage solutionsPage;
    public static WebDriver driver;

    @BeforeTest
    public void setUp() {
        /* Запуск в графическом интерфейсе.
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        */
        // Запуск не в графическом интерфейсе.
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        driver = new ChromeDriver(options);

        basePage = new BasePage(driver);
        softLabHomePage = new SoftLabHomePage(driver);
        solutionsPage = new SolutionsPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
