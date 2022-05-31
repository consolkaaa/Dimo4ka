package pageobjects;

import driver.DriverConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.function.Function;

public class CartPage extends AbstractPage {

    private WebDriver driver;

    @FindBy(css = ".btn btn--make-order btn--cart")
    public WebElement makeOrderButton;

    @FindBy(css = ".cart_item_price")
    public WebElement itemPrice;

    @FindBy(xpath = "//div[@class=\"empty-cart__wrapper\"]")
    public WebElement emptyCart;

    @FindBy(xpath = "//div[@class='cart_item'][1]")
    public WebElement cartElement;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // this initializes @FindBy elements
    }

    //для кожної сторінки інший локатор треба вставити
    public CartPage waitUntilLoaded(){
       // waitUntil(ExpectedConditions.visibilityOf());
        return this;
    }

    //то теж треба на кожній сторінці юзати, або придумати як то винести в AbstractPage
    public void waitUntil(Function condition) {
        getWebDriverWait(driver).until(condition);
    }
}
