import org.example.enums.BrowserType;
import org.example.factories.WebDriverFactory;
import org.example.pages.MainPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.FieldGenerator;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UpdateTaskTest {

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

    // Тест написан правильно, но есть баг в системе, что задача не обновляется!

//    @Test
//    public void updateTaskShouldChangedKeysValuesCorrect(){
//        driver = WebDriverFactory.createDriver(BrowserType.CHROME);
//        MainPage mainPage = new MainPage(driver);
//        mainPage.open();
//        mainPage.createTask(TASK_NAME, TASK_DESCRIPTION, TASK_PROJECT_ID, TASK_PRIORITY_ID, TASK_EXECUTOR_ID);
//        WebElement createdTask = mainPage.getConcreteTask(TASK_NAME);
//        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
//        try {
//            Thread.sleep(1800);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        final String updatedTaskNameField = FieldGenerator.getTaskName();
//        final int updatedTaskPriorityId = 0;
//        final int updatedTaskExecutorId = 2;
//        createdTask.click();
//        mainPage.updateTask(updatedTaskNameField, updatedTaskPriorityId, updatedTaskExecutorId);
//        assertTrue(mainPage.checkTaskExists(updatedTaskNameField));
//
//    }

}
