package webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WebElementUtils;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;
    private static final String calculatePriceTopXpath = "/html/body/div[1]/header/div/div[2]/div/div[3]/div[2]/div/a";
    private static final String calculatePriceLowerXpath = "/html/body/div[1]/section[1]/div[2]/div[2]/a";
    private static final String welcomeTextXpath = "/html/body/div[1]/section[1]/div[2]/h1/span";
    private static final String PAGE_URL = "https://hedvig.com/se";

    //locators
    @FindBy(xpath = calculatePriceTopXpath)
    private WebElement calculatePriceTop;

    @FindBy(xpath = calculatePriceLowerXpath)
    private WebElement calculatePriceLower;

    @FindBy(xpath = welcomeTextXpath)
    private WebElement welcomeText;

    //constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        driver.get(PAGE_URL);

        //initialize elements
        PageFactory.initElements(driver, this);
    }

    //webpage methods
    public void clickCalculatePriceTopLink(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(calculatePriceTopXpath)));
        WebElementUtils.highlightElement(driver, calculatePriceTop);
        calculatePriceTop.click();
    }

    public void clickCalculatePriceLowerLink(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(calculatePriceLowerXpath)));
        WebElementUtils.highlightElement(driver, calculatePriceLower);
        calculatePriceLower.click();
    }

    public Boolean isPageOpened(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(welcomeTextXpath)));
        WebElementUtils.highlightElement(driver, welcomeText);

        return welcomeText.getText().contains("Saker försvinner.\nVi finns här för alltid.");
    }
}
