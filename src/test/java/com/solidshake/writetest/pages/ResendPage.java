package com.solidshake.writetest.pages;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class ResendPage extends BasePage {

    public ResendPage (WebDriver driver) {
        super(driver);
    }

    //By acceptGoogleFormButton = By.xpath("/html/body/c-wiz/div/div/div[2]/div[4]/span[2]/div");

    String[] firstQuestionAns = {
            "/html/body/div[1]/main/div/div/div[2]/div/div[2]/div/form/div[1]/label[1]/button",
            "/html/body/div[1]/main/div/div/div[2]/div/div[2]/div/form/div[1]/label[2]/button"
    };

    String[] secondQuestionAns = {
            "/html/body/div[1]/main/div/div/div[2]/div/div[2]/div/form/div[2]/label[1]/button",
            "/html/body/div[1]/main/div/div/div[2]/div/div[2]/div/form/div[2]/label[2]/button",
            "/html/body/div[1]/main/div/div/div[2]/div/div[2]/div/form/div[2]/label[3]/button",
            "/html/body/div[1]/main/div/div/div[2]/div/div[2]/div/form/div[2]/label[4]/button",
            "/html/body/div[1]/main/div/div/div[2]/div/div[2]/div/form/div[2]/label[5]/button"
    };

    String[] thirdQuestionAns = {
            "/html/body/div[1]/main/div/div/div[2]/div/div[2]/div/form/div[3]/label[1]/button",
            "/html/body/div[1]/main/div/div/div[2]/div/div[2]/div/form/div[3]/label[2]/button",
            "/html/body/div[1]/main/div/div/div[2]/div/div[2]/div/form/div[3]/label[3]/button"
    };

    private static String chooseRandomAns(String[] questionAns) {
        return questionAns[rand.nextInt(questionAns.length)];
     }

    By firstQuestionAnsButton = By.xpath(chooseRandomAns(firstQuestionAns));
    By secondQuestionAnsButton = By.xpath(chooseRandomAns(secondQuestionAns));

    String thirdRandomAns = chooseRandomAns(thirdQuestionAns);
    By thirdQuestionAnsButton = By.xpath(thirdRandomAns);

    By submitQuestionsButton = By.xpath("/html/body/div[1]/main/div/div/div[2]/div/div[2]/div/form/button");

    By resendEmail = By.xpath("/html/body/div[1]/main/div/div/div[2]/div/div[1]/p[3]/button");

    private boolean checkThirdAns() {
        return thirdRandomAns == thirdQuestionAns[2];
    }

    public ResendPage acceptGoogleForm () {

        //Not Working
        driver.switchTo().frame(driver.findElement(By.cssSelector("#I0_1541978603525 > iframe")));
        driver.findElement(By.xpath("/html/body/c-wiz/div/div/div[2]/div[4]/span[1]/div")).click();
        driver.switchTo().defaultContent();

        return this;
    }

    public ResendPage chooseAns (){
        click(firstQuestionAnsButton);
        click(secondQuestionAnsButton);
        click(thirdQuestionAnsButton);
        if (checkThirdAns()) {
            writeText(thirdQuestionAnsButton, "random text");
        }
        click(submitQuestionsButton);
        return this;
    }

    public ResendPage resendEmail () {
        click(resendEmail);
        return this;
    }

    public ResendPage checkURL (String expectedPage) {
        waitVisibility(resendEmail);
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, expectedPage);
        return this;
    }

    public ResendPage checkQuestionsAccepted () {
        By success = By.xpath("/html/body/div[1]/main/div/div/div[2]/div/div[2]/div/div");
        waitVisibility(success);
        WebElement element = driver.findElement(success);
        Assert.assertTrue(element.isDisplayed());
        return this;
    }

    public ResendPage checkResendEmailAccepted () {
        By success = By.xpath("/html/body/div[1]/main/div/div/div[2]/div/div[1]/p[1]/span");
        waitVisibility(success);
        WebElement element = driver.findElement(success);
        Assert.assertTrue(element.isDisplayed());
        return this;
    }

    public ResendPage checkTwitterIcon () {
        By success = By.xpath("/html/body/div[1]/div/div[3]/div/div[1]/div/ul/li[1]/a");
        waitVisibility(success);
        WebElement element = driver.findElement(success);
        Assert.assertTrue(element.isDisplayed());

        Assert.assertEquals(element.getAttribute("href"), "https://twitter.com/wrike");

        //Not Working
//        By twitterSVG = By.id("twitter");
//        WebElement twitterElement = driver.findElement(twitterSVG);
//        Assert.assertTrue(twitterElement.isDisplayed());
        return this;
    }
}
