package org.example.webDriverManager.test;

import org.example.webDriverManager.setupTest.SetupTest;
import org.testng.annotations.Test;

public class LogoutPageTest extends SetupTest {

    @Test
    void googlePageTest(){
        driver.get("https://google.com");
    }

    @Test
    void yahooPageTest(){
        driver.get("https://yahoo.com");
    }

    @Test (enabled = false)
    void seznamPageTest(){
        driver.get("https://seznam.cz");
    }


}
