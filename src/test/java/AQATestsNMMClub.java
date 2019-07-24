import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

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
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterTest
    public void afterTests(){
        //driver.quit();
    }

    // ====================================
    // 1. открываем google.ru
    //2. ищем "nnm-club"
    //3. в найденных результатах кликаем по элементу
    // содержащему текст "NNM-Club: Торрент-трекер"
    //4. проверка: проверяем что мы перешли
    // на страницу http://nnmclub.to/

    @Test (priority = 1)//TODO: убрать приоритезацию
    public void firstTest(){
        driver.get(urlGoogle);
        By searchInputForText = By.cssSelector("#tsf [type=\"text\"]");//TODO: переделать селектор
        By searchButton = By.cssSelector("div.FPdoLc.VlcLAe input[type=\"submit\"]:nth-child(1)");//TODO: переделать селектор
        By searchOurUrl = By.xpath("//*[text()='NNM-Club: Торрент-трекер']");

       driver.findElement(searchInputForText).sendKeys("nnm-club");//TODO: тут появляется меню гугла, нужно стабилизировать тест
       driver.findElement(searchButton).click();
       driver.findElement(searchOurUrl).click();

        for (String tab : driver.getWindowHandles()) {
            driver.switchTo().window(tab);
        }

        //TODO: сделать нормальные асерты, сейчас логика работы не правильная, строки сравниваются не правильно
        WebDriverWait wait = (new WebDriverWait(driver, 10));//TODO: без него не работает?
        if ((driver.getCurrentUrl()==urlProject1) |  (driver.getCurrentUrl()==urlProject2)) {
            String mainURL = driver.getCurrentUrl();
            wait.until(ExpectedConditions.urlToBe(mainURL));
            Assert.assertEquals(driver.getCurrentUrl(),urlProject1);
        }

        Assert.assertEquals(driver.getTitle(), titleProject);

    }

    // ====================================
    //Предусловия:
    //Создать руками пользователя для http://nnmclub.to.
    //1. Перейти на http://nnmclub.to
    //2. Зайти под созданным пользователем
    //3. Проверка: убедится что вход успешен

    @Ignore
    @Test (priority = 2)
    public void loginTest(){

        driver.findElement(By.xpath("//a[text()='Вход']")).click();
        String mainTab = driver.getWindowHandle();
        driver.switchTo().window(mainTab);
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("ArtemOdessaAQA");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("zzd-xU2-6Fr-Jrv");
        driver.findElement(By.xpath("//input[@name='login']")).click();
        for (String tab : driver.getWindowHandles()) { 
            driver.switchTo().window(tab);
        }
        By exit = By.xpath("//a[contains(text(), 'Выход')]");
        Assert.assertTrue(driver.findElement(exit).isDisplayed());

    }

    // ====================================
    //Залониться на http://nnmclub.to
    //Осуществить поиск по трекеру (поле Поиск:):
    //искать фразу java
    //только торренты за последние 3 месяца
    //Проверка: осуществить проверку, что найденные торренты соответсвуют критериям поиска

    @Test (priority = 3)
    public void searchOnTreker(){
        driver.get("http://nnmclub.to/forum/tracker.php");
        By inputSearch = By.xpath("//table[@class='menubot']//input[@name='nm']");
        By buttonSearch = By.xpath("//input[@class='mbutton']");
        By dropList = By.xpath("//select[@name='tm']");
        By mounth3Last = By.xpath("//select[@name='tm']//option[@value='90']");
        driver.findElement(inputSearch).sendKeys("Java");
       // String mainTab = driver.getWindowHandle();
       // driver.switchTo().window(mainTab);
        driver.findElement(buttonSearch).click();
        driver.findElement(dropList).click();
        driver.findElement(mounth3Last).click();

       // driver.findElement(dropList).click();
//        WebDriverWait wait = (new WebDriverWait(driver, 2));
//        wait.until(ExpectedConditions.);
       // driver.findElement(mounth3Last).click();
    }
}