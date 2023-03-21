package org.example.localWebDriver;

// Importovane knihovny pro konkretni funkce WebDriveru a TestNG
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.time.Duration;

public class LocalSetupWithTest {

    static WebDriver driver;

    // pri spousteni TestNG souboru ve stejne slozce jako tento test, hleda testNG v teto tride anotace,
    // ktere obsahuji groups = {"regression"}, pokud takove nenajde, metoda se ignoruje
    @BeforeSuite (groups = {"regression"})
    void setupSuite(){
        // rikame co a kde (webdriver pro chrome, cesta/kde/je/soubor)
        System.setProperty("webdriver.chrome.driver", "C:/Users/mykola.poliwcuk/Downloads/chromedriver_win32/chromedriver.exe");
    }

    @BeforeMethod (groups = {"regression"})
    void setupTest(){
        // pridani argumentu pro chrome na povoleni vsech origins
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");

        // prirazeni chrome driveru do webdriveru
        driver = new ChromeDriver(chromeOptions);

        // tez muzeme hnedka na zacatku nastavit i napriklad zvetseni okno prohlizece nebo treba i implicitni wait atd...
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test (groups = {"regression"})
    void googlePageTest(){
        driver.get("https://google.com");
    }

    @Test
    void yahooPageTest(){
        driver.get("https://yahoo.com");
    }

    @Test (enabled = false, groups = {"regression"})
    void seznamPageTest(){
        driver.get("https://seznam.cz");
    }

    @AfterSuite (groups = {"regression"})
    void tearDowAfterSuite() {
        // cistka driveru, prohlizec se zavre
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterMethod (groups = {"regression"})
    void tearDownAfterMethod(){
        // cistka driveru, driver se vypne
        if (driver != null) {
            driver.close();
        }
    }
}
