package com.solidshake.writetest.tests;

import com.solidshake.writetest.pages.GetStartedPage;
import org.junit.Test;

public class WrikeTest extends com.solidshake.writetest.tests.BaseTest {
    @Test
    public void fullGetStartedTest () {

        GetStartedPage getStarted = new GetStartedPage(driver);

        getStarted.goToWrike()
                .goToResendPage()
                .checkURL("https://www.wrike.com/resend/")
                .acceptGoogleForm()
                .chooseAns()
                .checkQuestionsAccepted()
                .resendEmail()
                .checkResendEmailAccepted()
                .checkTwitterIcon();
    }
}
