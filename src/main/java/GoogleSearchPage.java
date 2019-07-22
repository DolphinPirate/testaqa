import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleSearchPage {

    private WebDriver driver;

    private String txt;

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }


    public GoogleSearchPage(WebDriver driver) {
        this.driver = driver;
    }

    // Google
    private By searchInputForText = By.cssSelector("#tsf [type=\"text\"]");
    private By textForSearch = By.xpath("//*[text()='NNM-Club: Торрент-трекер']");
    private By searchButton = By.cssSelector("div.FPdoLc.VlcLAe input[type=\"submit\"]:nth-child(1)");

    public void mySearchGoogle() {

        driver.findElement(searchInputForText).sendKeys(txt);
        driver.findElement(searchButton).click();
        driver.findElement(By.xpath("//*[text()='NNM-Club: Торрент-трекер']"));


       /* for (String tab : driver.getWindowHandles()) {
            driver.switchTo().window(tab);
        }*/
    }


}
