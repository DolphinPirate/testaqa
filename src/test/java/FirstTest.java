import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FirstTest {

   // private WebDriver driver;

//    private String url = "https://www.google.ru/";
//    private String k = "nnm-club";
//    private String url2 = "http://nnmclub.to/";
//    private String url3 = "http://nnmclub.me/";
//    private String url4 = "https://n.iss.one/";

 //   private String titleSite = "Торрент-трекер :: NNM-Club";

    @Test (priority = 1)
    public void myTestSearch() {

        System.out.println("Hello TEST");
       driver.findElement(By.cssSelector("#tsf [type=\"text\"]")).sendKeys(k);
        driver.findElement(By.cssSelector("div.FPdoLc.VlcLAe input[type=\"submit\"]:nth-child(1)")).click();
        WebElement a = driver.findElement(By.xpath("//*[text()='NNM-Club: Торрент-трекер']"));
        a.click();
        for (String tab : driver.getWindowHandles()) {
            driver.switchTo().window(tab);
        }

    }

        /*
    @Test (priority = 2)
    public void myTestGetUrl() {

        WebDriverWait wait = (new WebDriverWait(driver, 10));
        wait.until(ExpectedConditions.urlToBe(url2));

        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(), url2);
    }

    @Test (priority = 3)
    public void myTestGetTitle(){
        WebDriverWait wait = (new WebDriverWait(driver, 2));
        wait.until(ExpectedConditions.urlToBe(url2));
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(), titleSite);
    }
        */
}