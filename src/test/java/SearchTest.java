import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SearchTest {

    // Залониться на http://nnmclub.to
    //    Осуществить поиск по трекеру (поле Поиск:):
    //    искать фразу java
    //    только торренты за последние 3 месяца
    //    Проверка: осуществить проверку, что найденные торренты соответсвуют критериям поиска

    private WebDriver driver;

    private By SearchOnSite = By.xpath("//input[@class='mbutton']");
    private  By InputSearch = By.xpath("//form/input[@name='nm']");

    private By LastTimeTorrentFile = By.xpath("//legend[text()='Торренты за']/following-sibling::div/select[@class='post']");
    private  By SelectLastTimeTorrentFile = By.xpath("");

    @BeforeTest
    public void preCondition() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();

        LoginPage loginUser = new LoginPage();
        loginUser.logInToSite();
    }

    @Test
    public void hello(){
       driver.findElement(InputSearch).sendKeys("Java");
    }

}
