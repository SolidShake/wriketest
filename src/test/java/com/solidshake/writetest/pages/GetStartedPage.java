package com.solidshake.writetest.pages;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.nio.charset.Charset;
import java.util.Random;

public class GetStartedPage extends BasePage {

    public GetStartedPage (WebDriver driver) {
        super(driver);
    }

    public static String baseURL = "http://www.wrike.com/";

    By getStartedButton = By.xpath("/html/body/div[1]/header/div[3]/div[2]/div/div/div[2]/div/form/button");
    By importEmail = By.xpath("//*[@id=\"modal-pro\"]/form/label[1]/input");
    By createAccountButton = By.xpath("//*[@id=\"modal-pro\"]/form/label[2]/button");

    private String generateRandomEmail() {
        String generatedString = RandomStringUtils.randomAlphanumeric(7);
        generatedString += "+wpt@wriketask.qaa";
        return generatedString;
    }

    public GetStartedPage goToWrike (){
        driver.get(baseURL);
        return this;
    }

    public ResendPage goToResendPage (){
        click(getStartedButton);
        writeText(importEmail, generateRandomEmail());
        click(createAccountButton);
        return new ResendPage(driver);
    }
}
