package tests.firefox;

import org.junit.After;
import org.junit.Assert;
import webpages.HomePage;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import webpages.NewMember;
import webpages.NewMemberWelcome;
import java.util.concurrent.TimeUnit;

public class ApplyAsNewMember {
    WebDriver driver;

    @Before
    public void setup(){
        System.setProperty("webdriver.gecko.driver", "C:\\Test automation\\selenium\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void cleanUp(){
        driver.close();
    }

    @Test
    public void applyAsNewMember() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isPageOpened());
        homePage.clickCalculatePriceTopLink();

        NewMember newMember = new NewMember(driver);
        Assert.assertTrue(newMember.isPageOpened());
        newMember.clickCalculatePriceLink();

        NewMemberWelcome newMemberWelcome = new NewMemberWelcome(driver);
        Assert.assertTrue(newMemberWelcome.isPageOpened());
    }
}
