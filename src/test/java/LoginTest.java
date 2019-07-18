import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {

    private WebDriver driver;

    private By inputLogin = By.xpath("//input[@name='username']");
    private By inputPassword = By.xpath("//input[@name='password']");
    private By ClikButtonEntertToSite = By.xpath("//input[@name='login']");
    private By LogOutUser = By.xpath("//a[text()='Выход [ "+getLogin()+" ]']");
    private String url = "http://nnmclub.to/";
    private String login;
    private String password;

    @BeforeTest
    public void PreCondition() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(url);
        String mainTab = driver.getWindowHandle();
        driver.switchTo().window(mainTab);
    }

    @Test (priority = 1)
    public void LoginToSite(){
        WebDriverWait wait = (new WebDriverWait(driver, 2));
        wait.until(ExpectedConditions.urlToBe(url));
        driver.findElement(By.xpath("//a[text()='Вход']")).click();
        driver.findElement(inputLogin).sendKeys(getLogin());
        driver.findElement(inputPassword).sendKeys(getPassword());
        driver.findElement(ClikButtonEntertToSite).click();
    }

    @Test (priority = 2)
    public void userEnter(){
        if (driver.findElement(LogOutUser).isDisplayed()){
            System.out.println("Nice! Welcome "+getLogin());
        }
    }

    @AfterTest
    public void close(){
      driver.quit();
    }

    private String getLogin() {
        return login = "ArtemOdessaAQA";
    }

    private String getPassword() {
        return password = "zzd-xU2-6Fr-Jrv";
    }
}