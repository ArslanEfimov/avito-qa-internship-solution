package org.example.pages;

import org.example.enums.BoardPageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BoardPage extends Page{

    private static final String BOARD_PAGE_URL = "https://avito-tech-internship-psi.vercel.app/boards";

    public BoardPage(WebDriver driver) {
        super(driver);
    }

    public void open(){
        super.open(BOARD_PAGE_URL); // Из-за бага в системе страница выдает 404 ошибку
    }

    public boolean checkProjectsIsExist(){
        List<WebElement> projectsElements = waitForVisibilityOfAll(By.xpath(BoardPageLocators.PROJECTS_LIST_PATH.getLocatorPath()), 10);
        return !projectsElements.isEmpty();
    }

    public void clickOnTheGoToTheBoardReferences(String concretePath){
        waitToBeClickable(By.xpath(concretePath), 5).click();
    }

    public boolean checkConcreteBoardNameIsCorrect(String boardName){
        return getDriver().findElement(By.xpath(BoardPageLocators.CONCRETE_BOARD_NAME_PATH.getLocatorPath())).getText().equals(boardName);
    }

    public WebElement getConcreteTaskCard(String cardName){
       WebElement concreteTaskCardElement = waitToBeClickable(By.xpath(BoardPageLocators.TASK_CARD_PATH.getLocatorPath() + "[text()='" + cardName + "']/parent::div"), 10);
        scrollToElement();
        return concreteTaskCardElement;
    }

}
