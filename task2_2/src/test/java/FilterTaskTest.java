import org.example.enums.BrowserType;
import org.example.factories.WebDriverFactory;
import org.example.pages.MainPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FilterTaskTest {

    private WebDriver driver;
    private static final List<String> statuses = List.of("Backlog", "inProgress");
    private static final List<String> boards = List.of("Редизайн карточки товара", "Оптимизация производительности"
    , "Рефакторинг API", "Миграция на новую БД", "Автоматизация тестирования", "Переход на Kubernetes");

    @AfterEach
    public void tearDown(){
        driver.quit();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1}) // В фильтре Done был найден баг!
    public void filterAllTasksByFilterStatusShouldReturnTasksWithCorrectStatus(int statusId){
        driver = WebDriverFactory.createDriver(BrowserType.CHROME);
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.filterByStatus(statusId);
        assertTrue(mainPage.checkAllTaskStatusesIsCorrect(statuses.get(statusId)));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5})
    public void filterAllTasksByFilterBoardShouldReturnTasksWithCorrectBoard(int boardId){
        driver = WebDriverFactory.createDriver(BrowserType.CHROME);
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.filterByBoard(boardId);
        assertTrue(mainPage.checkAllTaskBoardsIsCorrect(boards.get(boardId)));

    }



}
