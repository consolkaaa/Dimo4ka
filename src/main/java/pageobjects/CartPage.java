package pageobjects;

import driver.DriverConfigurator;
import org.openqa.selenium.*;
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

    @FindBy(xpath = "//h1[.='Кошик']")
    public WebElement cartTitle;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // this initializes @FindBy elements
    }

    public CartPage deleteProduct(String cartProductName){
        getProductWebElement(cartProductName).findElement(By.xpath(".//div[@class='cart_product-delete']")).click();
        return this;
    }

    private WebElement getProductWebElement(String cartProductName){
        return driver.findElement(By.xpath(String.format("//a[.='%s']/ancestor::div[@class='cart_item']", cartProductName)));
    }

    public boolean isProductPresentInCart(String cartProductName){
        try {
            waitUntil(ExpectedConditions.presenceOfElementLocated(By.xpath(String.format("//a[.='%s']/ancestor::div[@class='cart_item']", cartProductName))));
            return getProductWebElement(cartProductName).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    //для кожної сторінки інший локатор треба вставити
    public CartPage waitUntilLoaded(){
        waitUntil(ExpectedConditions.visibilityOf(cartTitle));
        return this;
    }

    //то теж треба на кожній сторінці юзати, або придумати як то винести в AbstractPage
    public void waitUntil(Function condition) {
        getWebDriverWait(driver).until(condition);
    }
}
