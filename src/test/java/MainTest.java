import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class MainTest {
    public static GooglePage googlePage;
    public static WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
//        System.setProperty("webdriver.chrome.driver", "C:\\chromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        googlePage = new GooglePage(driver);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


    }

    @Before
    public void before(){
        driver.get("https://google.com");
        driver.manage().window().maximize();
    }

    @After
    public void after() {

    }


    @Test
    public void testUSDforBuy() {
        googlePage.inputSearchField("Курс доллара");
        googlePage.clickSearch();
        double result = Double.parseDouble(googlePage.getCurrencyValue());
        Assert.assertTrue( "Рано покупать!!",result < 110.00);
    }

    @Test
    public void testEURforSale() {
        googlePage.inputSearchField("Курс евро");
        googlePage.clickSearch();
        double result = Double.parseDouble(googlePage.getCurrencyValue());
        Assert.assertTrue( "Рано продавать!!",result > 110.00);
    }




    @AfterClass
    public static void afterClass() {
        driver.quit();
    }


}
