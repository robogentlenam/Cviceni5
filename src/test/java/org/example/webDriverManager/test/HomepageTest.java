package org.example.webDriverManager.test;

import org.example.webDriverManager.setupTest.SetupTest;
import org.testng.annotations.Test;

public class HomepageTest extends SetupTest {

    @Test (priority = 2, description = "Google test") // priority urcuje poradi testu zde v souboru, Desctiption zase popis.
    void googlePageTest(){
        driver.get("https://google.com");
    }

    @Test (priority = 1, description = "Yahoo test")
    void yahooPageTest(){
        driver.get("https://yahoo.com");
    }

    @Test (enabled = false) // enabled vypne beh testu. Test nebude ani zmineny v reportu.
    void seznamPageTest(){
        driver.get("https://seznam.cz");
    }
}
