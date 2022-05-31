import enums.CatalogItems;
import enums.ProductItem;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.CatalogCategoryPage;
import pageobjects.MainPage;

public class SelersPageTest extends BaseTest{
    CatalogCategoryPage catalogCategoryPage;
    private static String productName = ProductItem.DRESS_ISSA_PLUS.getName();
    private static String productCartName = ProductItem.DRESS_ISSA_PLUS.getCartName();
    private static String selersName = ProductItem.DRESS_ISSA_PLUS.getSellersName();

    @Test
    public void isNumberOfProductsUpdatedTest(){
        catalogCategoryPage = new MainPage(driver)
                .openCatalog()
                .openCatalogCategory(CatalogItems.SUKNI.getName())
                .clickBuyProduct(productName)
                .selectRandomSize()
                .getMainPageHeader()
                .openCartPage()
                .openSelersPageOfProduct(productCartName);

       Assert.assertTrue(catalogCategoryPage.isSellersNameDisplayed(selersName),
               "Sellers name should be displayed");
    }
}
