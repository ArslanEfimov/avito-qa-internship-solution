import org.example.enums.BoardPageLocators;
import org.example.enums.BrowserType;
import org.example.factories.WebDriverFactory;
import org.example.pages.BoardPage;
import org.example.pages.MainPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.FieldGenerator;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ConcreteBoardPageTest {

    private WebDriver driver;
    private static final String TASK_NAME = FieldGenerator.getTaskName();
    private static final String TASK_DESCRIPTION = FieldGenerator.getTaskDescription();
    private static final int TASK_PROJECT_ID = 0;
    public static final int TASK_PRIORITY_ID = 1;
    public static final int TASK_EXECUTOR_ID = 1;

    @AfterEach
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void concreteBoardPageShouldShowedCorrectProject(){
        driver = WebDriverFactory.createDriver(BrowserType.CHROME);
        BoardPage boardPage = new BoardPage(driver);
        MainPage mainPage = new MainPage(driver);
        final String boardName = "Редизайн карточки товара";
        mainPage.open();
        mainPage.clickOnTheProjectsReference();
        boardPage.clickOnTheGoToTheBoardReferences(BoardPageLocators.REDESIGN_CARD_BOARD_REFERENCE_PATH.getLocatorPath());
        assertTrue(boardPage.checkConcreteBoardNameIsCorrect(boardName));

    }

    @Test
    public void concreteBoardPageShouldShowedCreatedProjectAndProjectShouldToBeClickable(){
        driver = WebDriverFactory.createDriver(BrowserType.CHROME);
        BoardPage boardPage = new BoardPage(driver);
        MainPage mainPage = new MainPage(driver);
        final String boardName = "Оптимизация производительности";
        mainPage.open();
        mainPage.createTask(TASK_NAME, TASK_DESCRIPTION, TASK_PROJECT_ID, TASK_PRIORITY_ID, TASK_EXECUTOR_ID);
        mainPage.clickOnTheProjectsReference();
        boardPage.clickOnTheGoToTheBoardReferences(BoardPageLocators.OPTIMIZATION_PERFORMANCE_BOARD_REFERENCES_PATH.getLocatorPath());
        assertTrue(boardPage.checkConcreteBoardNameIsCorrect(boardName));
        WebElement concreteCard = boardPage.getConcreteTaskCard(TASK_NAME);
        assertTrue(concreteCard.isDisplayed());
        concreteCard.click();
        WebElement editBox = driver.findElement(By.xpath(BoardPageLocators.EDIT_CARD_FORM_PATH.getLocatorPath()));
        assertTrue(editBox.isDisplayed());

    }
}
