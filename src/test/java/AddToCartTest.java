import enums.CatalogItems;
import enums.ProductItem;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.MainPage;
import pageobjects.CatalogCategoryPage;


public class AddToCartTest extends BaseTest{

    @Test
    public  void Test1(){
        CatalogCategoryPage catalogCategoryPage = new MainPage(driver)
                .openCatalog()
                .openCatalogCategory(CatalogItems.SUKNI.getName());
        String numberOfItemsInCart = catalogCategoryPage
                .getMainPageHeader()
                .getCartProductsNumber();
        String numberOfItemsInCartAfterAddingProduct = catalogCategoryPage
                .clickBuyProduct(ProductItem.DRESS_ISSA_PLUS.getName())
                .selectRandomSize()
                .getMainPageHeader()
                .getCartProductsNumber();

        Assert.assertEquals(Integer.parseInt(numberOfItemsInCart) + 1, Integer.parseInt(numberOfItemsInCartAfterAddingProduct),
                "Number of items in the cart should have been updated");
    }
}