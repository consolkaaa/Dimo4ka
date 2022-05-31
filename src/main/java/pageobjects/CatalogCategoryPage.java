package pageobjects;

import enums.MenuItems;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.function.Function;

public class CatalogCategoryPage extends AbstractPage{

    private WebDriver driver;
    private MainPageHeader mainPageHeader;

    public CatalogCategoryPage(WebDriver driver) {
        this.driver = driver;
        mainPageHeader = new MainPageHeader(driver);
        PageFactory.initElements(driver, this); // this initializes @FindBy elements
    }

    @FindBy(xpath = "//li[@class = 'menu-vertical__item group ']/descendant::a[text()='Одяг']/parent::li")
    private WebElement catalogOpenButton;


    //то теж треба на кожній сторінці юзати, або придумати як то винести в AbstractPage
    public void waitUntil(Function condition) {
        getWebDriverWait(driver).until(condition);
    }

    public CatalogCategoryPage clickBuyProduct(String productName) {
        try {
            WebElement productElement = driver.findElement(By.xpath(String.format("//header[.='%s']/ancestor::div[@class='p__info_container']", productName)));
            productElement.click();
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException(String.format("There is no product with name '%s'", productName));
        }
        return this;
    }

    public MainPageHeader getMainPageHeader(){
        return mainPageHeader;
    }


//    public CartPage openCartPage(){
//        addToCart.click();
//        mainPageHeader.clickHeaderMenuItem(MenuItems.CART.getName());
//        return new CartPage(driver).waitUntilLoaded();
//    }


}