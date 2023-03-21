package com.automationteststore.setupTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class SetupTest {

    protected static WebDriver driver;
    public static Properties config = new Properties();
    public static FileInputStream fis;

    @BeforeSuite
    protected void setupSuite(){
        System.out.println("Running Before Suite");
    }

    // Zde pouzivame vytah hodnoty ze souboru src/test/resources/Config.properties
    //
    @BeforeMethod
    protected void setupTest(){
        try {
            fis = new FileInputStream
                    (System.getProperty("user.dir") + "\\src\\test\\resources\\Config.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            config.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(config.getProperty("browser"));

        if(config.getProperty("browser").equals("chrome")){
            WebDriverManager.chromedriver().setup();

            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--remote-allow-origins=*");

            driver = new ChromeDriver(chromeOptions);
        }

        if(config.getProperty("browser").equals("edge")){
            WebDriverManager.edgedriver().setup();

            driver = new EdgeDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        System.out.println(config.getProperty("browser"));

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
