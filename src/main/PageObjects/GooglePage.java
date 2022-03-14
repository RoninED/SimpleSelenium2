import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * First page of google service: google.com
 */
public class GooglePage {
    public WebDriver driver;

    public GooglePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")
    private WebElement searchField;

    /**
     * Input string in search field of google
     * @param str search value
     */
    public void inputSearchField(String str) {
        searchField.sendKeys(str);
    }

    @FindBy(xpath = "/html/body/div[1]/div[3]/form/div[1]/div[1]/div[3]/center/input[1]")
    private WebElement searchButton;

    /**
     * Click search button in google.com
     */
    public void clickSearch() {
        searchButton.click();
    }


    @FindBy(xpath = "//*/tr[3]/td[1]//input[@aria-label=\"Поле для ввода суммы в валюте\"]")
    private WebElement currencyValue;

    /**
     * get currency value, after google find it
     * @return Currency value
     */
    public String getCurrencyValue() {
        return currencyValue.getAttribute("value");
    }
}
