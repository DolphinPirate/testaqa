import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleSearchPage {

    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    // Google
    private By searchInputText = By.cssSelector("#tsf [type=\"text\"]");
    private By searchInputText = By.cssSelector("div.FPdoLc.VlcLAe input[type=\"submit\"]:nth-child(1)");
    private By searchInputText = By.xpath("//*[text()='NNM-Club: Торрент-трекер']");

}
