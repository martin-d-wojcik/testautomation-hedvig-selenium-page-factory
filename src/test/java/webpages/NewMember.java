package webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WebElementUtils;

public class NewMember {
    private WebDriver driver;
    private WebDriverWait wait;
    private static final String calculatePriceXpath = "/html/body/div/div/div/div/div[3]/div/div[1]/a";
    private static final String compareHedvigXpath = "/html/body/div/div/div/div/div[3]/div/div[2]/a";
    private static final String hedvigLogoXpath = "/html/body/div/div/div/div/div[1]/div/a";
    private static final String PAGE_URL = "https://hedvig.com/se/new-member";

    //locators
    @FindBy(xpath = calculatePriceXpath)
    private WebElement calculatePrice;

    @FindBy(xpath = compareHedvigXpath)
    private WebElement compareHedvig;

    @FindBy(xpath = hedvigLogoXpath)
    private WebElement hedvigLogo;

    //constructor
    public NewMember(WebDriver driver) throws InterruptedException {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        driver.get(PAGE_URL);

        //initialize elements
        PageFactory.initElements(driver, this);
    }

    //webpage methods
    public void clickCalculatePriceLink(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(calculatePriceXpath)));
        WebElementUtils.highlightElement(driver, calculatePrice);
        calculatePrice.click();
    }

    public void clickCompareHedvigLink(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(compareHedvigXpath)));
        WebElementUtils.highlightElement(driver, compareHedvig);
        compareHedvig.click();
    }

    public Boolean isPageOpened(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(hedvigLogoXpath)));
        WebElementUtils.highlightElement(driver, hedvigLogo);
        return hedvigLogo.isDisplayed();
    }
}
