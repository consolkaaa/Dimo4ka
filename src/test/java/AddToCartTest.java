import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.MainPage;
import pageobjects.CatalogCategoryPage;

import static enums.CatalogItems.SHIRTS;


public class AddToCartTest extends BaseTest{

    @Test
    public  void Test1(){
        CatalogCategoryPage catalogCategoryPage = new MainPage(driver)
                .openCatalog();
        String numberOfItemsInCart = catalogCategoryPage
                .getMainPageHeader()
                .getCartProductsNumber();
        String numberOfItemsInCartAfterAddingProduct = catalogCategoryPage
                .clickBuyProduct(SHIRTS.getName())
                .getMainPageHeader()
                .getCartProductsNumber();

        Assert.assertEquals(Integer.parseInt(numberOfItemsInCart) + 1, Integer.parseInt(numberOfItemsInCartAfterAddingProduct),
                "Number of items in the cart should have been updated");
    }
}