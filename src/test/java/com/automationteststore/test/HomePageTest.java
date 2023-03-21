package com.automationteststore.test;

import com.automationteststore.setupTest.SetupTest;
import org.openqa.selenium.By;
import org.testng.annotations.*;

public class HomePageTest extends SetupTest {

    @Test
    void mainPageTest(){
        driver.get("https://automationteststore.com");
    }

    @Test
    void redirectToPageTest(){
        driver.get("https://automationteststore.com");
        driver.navigate().to("https://automationteststore.com/index.php?rt=product/special");
    }

    @Test
    void browseOnPageTest(){
        driver.get("https://automationteststore.com");
        // klikne do daneho ID a vlozi danou hodnotu
        driver.findElement(By.id("filter_keyword")).sendKeys("shampoo");
        // vyhleda selector podle class name a klikne na ikonu lupy v search baru
        driver.findElement(By.className("button-in-search")).click();
        // vyhleda selector podle name a vyplni email v prave dolni casti obrazkovy
        driver.findElement(By.name("email")).sendKeys("email@example.com");

    }

    @Test
    void navBarPageTest(){
        driver.get("https://automationteststore.com");
        driver.findElement(By.xpath("//div[@id=\"topnav\"]//span[@class=\"menu_text\" and text()=\"Specials\"]"));
        driver.findElement(By.xpath("//div[@id=\"topnav\"]//span[@class=\"menu_text\" and contains(text(),\"Acc\")]"));
        driver.findElement(By.xpath("//div[@id=\"topnav\"]//span[@class=\"menu_text\" and text()=\"Cart\"]"));
        driver.findElement(By.xpath("//div[@id=\"topnav\"]//span[@class=\"menu_text\" and text()=\"Checkout\"]"));
    }

}


