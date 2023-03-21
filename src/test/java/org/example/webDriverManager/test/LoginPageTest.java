package org.example.webDriverManager.test;

import org.example.webDriverManager.setupTest.SetupTest;
import org.testng.annotations.Test;

public class LoginPageTest extends SetupTest {

    @Test
    void googlePageTest(){
        driver.get("https://google.com");
    }

    @Test
    void yahooPageTest(){
        driver.get("https://yahoo.com");
    }

    @Test
    void seznamPageTest(){
        driver.get("https://seznam.cz"); // tanhle stranka ceka dele, kvuli nacitani nejakeho elementu
    }


}
