import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AQATestsNMMClub {

    private WebDriver driver;

   private String urlProject1 = "http://nnmclub.to/";
   private String urlProject2 = "https://n.iss.one/";
   private String titleProject = "Торрент-трекер :: NNM-Club";
   private String link;

   private String urlGoogle = "https://www.google.ru/";

    @BeforeTest
    public void preCondition(){
       // DriverBRO.startBrouserChrome(urlGoogle);
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @AfterTest
    public void afterTests(){
        driver.quit();
    }

    // ====================================
    // 1. открываем google.ru
    //2. ищем "nnm-club"
    //3. в найденных результатах кликаем по элементу
    // содержащему текст "NNM-Club: Торрент-трекер"
    //4. проверка: проверяем что мы перешли
    // на страницу http://nnmclub.to/

    @Test (priority = 1)
    public void firstTest(){
        driver.get(urlGoogle);
        By searchInputForText = By.cssSelector("#tsf [type=\"text\"]");
        By searchButton = By.cssSelector("div.FPdoLc.VlcLAe input[type=\"submit\"]:nth-child(1)");
        By searchOurUrl = By.xpath("//*[text()='NNM-Club: Торрент-трекер']");

       driver.findElement(searchInputForText).sendKeys("nnm-club");
       driver.findElement(searchButton).click();
       driver.findElement(searchOurUrl).click();

        for (String tab : driver.getWindowHandles()) {
            driver.switchTo().window(tab);
        }

        WebDriverWait wait = (new WebDriverWait(driver, 10));

        if (driver.getCurrentUrl()== urlProject1 |  driver.getCurrentUrl()== urlProject2) {
            wait.until(ExpectedConditions.urlToBe(driver.getCurrentUrl()));
            link = driver.getCurrentUrl();
            Assert.assertEquals(driver.getCurrentUrl(),link);
        }

        Assert.assertEquals(driver.getTitle(), titleProject);

    }

    // ====================================
    //Предусловия:
    //Создать руками пользователя для http://nnmclub.to.
    //1. Перейти на http://nnmclub.to
    //2. Зайти под созданным пользователем
    //3. Проверка: убедится что вход успешен

    @Test (priority = 2)
    public void loginTest(){

    }

    // ====================================
    //Залониться на http://nnmclub.to
    //Осуществить поиск по трекеру (поле Поиск:):
    //искать фразу java
    //только торренты за последние 3 месяца
    //Проверка: осуществить проверку, что найденные торренты соответсвуют критериям поиска

    @Test (priority = 3)
    public void searchOnTreker(){

    }
}