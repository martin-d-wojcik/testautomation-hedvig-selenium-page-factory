package webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WebElementUtils;

public class NewMemberWelcome {
    private WebDriver driver;
    private WebDriverWait wait;
    private static final String welcomeTextXpath = "/html/body/div/div/div/div/div[2]/div[1]/div[1]/ul/div[1]/li/p";
    private static final String PAGE_URL = "https://hedvig.com/se/new-member/new/welcome";

    //locators
    @FindBy(xpath = welcomeTextXpath)
    private WebElement welcomeText;

    //constructor
    public NewMemberWelcome(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        driver.get(PAGE_URL);

        //initialize elements
        PageFactory.initElements(driver, this);
    }

    //webpage methods
    public Boolean isPageOpened(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(welcomeTextXpath)));
        WebElementUtils.highlightElement(driver, welcomeText);

        return welcomeText.getText().contains("Hej! Låt oss ta fram ett prisförslag, det tar bara 1 minut");
    }
}
