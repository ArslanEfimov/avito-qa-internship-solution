import org.example.enums.BrowserType;
import org.example.factories.WebDriverFactory;
import org.example.pages.BoardPage;
import org.example.pages.MainPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BoardsViewTest {

    private WebDriver driver;

    @AfterEach
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void boardPageShouldShowedExistProjects(){
        driver = WebDriverFactory.createDriver(BrowserType.CHROME);
        MainPage mainPage = new MainPage(driver);
        BoardPage boardPage = new BoardPage(driver);
        mainPage.open();
        mainPage.clickOnTheProjectsReference();
        assertTrue(boardPage.checkProjectsIsExist());
    }
}
