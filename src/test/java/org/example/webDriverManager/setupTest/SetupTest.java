package org.example.webDriverManager.setupTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;

public class SetupTest {

    protected static WebDriver driver;

    @BeforeMethod
    @Parameters ({"browser"}) // parameter pouziva danou value z TestNG souboru pro vyber prohlizece.
    protected void setupSuite(String browser){
        System.out.println("Selected browser: " + browser);

        switch(browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                System.out.println("ChromeDriver Set up");
                break;

            case "edge":
                WebDriverManager.edgedriver().setup();
                System.out.println("EdgeDriver Set up");
                break;
            default:
                throw new IllegalArgumentException("Invalid browser specified: " + browser);
        }
    }

    @BeforeMethod
    @Parameters ({"browser"})
    protected void setupTest(String browser){

        System.out.println("Browser: " + browser);
        if (browser.equalsIgnoreCase("chrome")) {

            // pridani argumentu pro chrome na povoleni vsech origins
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--remote-allow-origins=*");

            driver = new ChromeDriver(chromeOptions);
            System.out.println("chromedriver set");
        }
        if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
            System.out.println("edge set");
        }
    }

    @AfterSuite
    protected void tearDowAfterSuite() {
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterMethod
    protected void tearDownAfterMethod(){
        if (driver != null) {
            driver.close();
        }
    }

}
