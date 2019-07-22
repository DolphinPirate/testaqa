import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AQATestsNMMClub {

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
        DriverBRO.open("");
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