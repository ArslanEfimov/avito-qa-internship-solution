import org.example.enums.BrowserType;
import org.example.factories.WebDriverFactory;
import org.example.pages.MainPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import utils.FieldGenerator;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreateTaskTest {

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
    public void createTaskShouldDisplayItInTaskList() {
        driver = WebDriverFactory.createDriver(BrowserType.CHROME);
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.createTask(TASK_NAME, TASK_DESCRIPTION, TASK_PROJECT_ID, TASK_PRIORITY_ID, TASK_EXECUTOR_ID);
        assertTrue(mainPage.checkTaskExists(TASK_NAME));
    }
}
