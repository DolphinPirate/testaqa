import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AQATestsNMMClub {

    private WebDriver driver;

    @BeforeTest
    public void preCondition(){
        DriverBRO.startBrouserChrome();
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

        String urlProject = "http://nnmclub.to/";
        By searchInputForText = By.cssSelector("#tsf [type=\"text\"]");
        By searchButton = By.cssSelector("div.FPdoLc.VlcLAe input[type=\"submit\"]:nth-child(1)");

        By searchOurUrl = By.xpath("//*[text()='NNM-Club: Торрент-трекер']");

        DriverBRO.open("https://www.google.ru/");
        driver.findElement(searchInputForText).sendKeys("nnm-club");
        driver.findElement(searchButton).click();
        driver.findElement(searchOurUrl).click();

        for (String tab : driver.getWindowHandles()) {
            driver.switchTo().window(tab);
        }
        WebDriverWait wait = (new WebDriverWait(driver, 10));
        wait.until(ExpectedConditions.urlToBe(urlProject));

        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(), urlProject);

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

    @AfterTest
    public void afterTest(){
        DriverBRO.closeDriver();
    }
}