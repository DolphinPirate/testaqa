import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

   private WebDriver driver;
    public void DriverBRO(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By inputLogin = By.xpath("//input[@name='username']");
    private By inputPassword = By.xpath("//input[@name='password']");
    private By ClikButtonEntertToSite = By.xpath("//input[@name='login']");

    public LoginPage reg(String username, String password) {
        this.typeUsername(username);
        this.typePassword(password);
        this.clickButtonEnter();
        return new LoginPage(driver);
    }

    public LoginPage typeUsername(String username) {
        driver.findElement(inputLogin).sendKeys(username);
        return this;
    }

    public LoginPage typePassword(String password) {
        driver.findElement(inputPassword).sendKeys(password);
        return this;
    }

    public LoginPage clickButtonEnter() {
        driver.findElement(ClikButtonEntertToSite).click();
        return new LoginPage(driver);
    }

    public void logInToSite() {

        // WebDriverWait wait = (new WebDriverWait(driver, 3));
        // wait.until(ExpectedConditions.urlToBe(url));
        // String mainTab = driver.getWindowHandle();
        // driver.switchTo().window(mainTab);
        /*for (String tab : driver.getWindowHandles()) {
            driver.switchTo().window(tab);
        }*/
    }
}
