package org.example.pages;


import org.example.enums.MainPageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MainPage extends Page{

    private static final String MAIN_PAGE_URL = "https://avito-tech-internship-psi.vercel.app/";

    public MainPage(WebDriver driver){
        super(driver);
    }

    public void open(){
        super.open(MAIN_PAGE_URL);
    }

    public void clickOnTheCreateTaskButton(){
        waitToBeClickable(By.xpath(MainPageLocators.CREATE_TASK_BUTTON_PATH.getLocatorPath()), 5).click();
    }

    public void clickOnTheProjectsReference(){
        waitToBeClickable(By.xpath(MainPageLocators.PROJECT_REFERENCE_PATH.getLocatorPath()), 5).click();
    }

    public void searchTask(String taskName){
        WebElement inputField = waitToBeClickable(By.xpath(MainPageLocators.INPUT_TASK_PATH.getLocatorPath()), 5);
        inputField.click();
        type(inputField, taskName);
    }

    public void filterByStatus(int statusId){
        WebElement statusDropDownField = waitToBeClickable(By.xpath(MainPageLocators.STATUS_FILTER_DROP_DOWN_LIST_PATH.getLocatorPath()), 5);
        statusDropDownField.click();
        List<WebElement> statusesElementsList = waitForVisibilityOfAll(By.xpath(MainPageLocators.STATUS_FILTER_VALUES_PATH.getLocatorPath()), 3);
        WebElement statusElement = statusesElementsList.get(statusId);
        statusElement.click();
    }

    public void filterByBoard(int boardId){
        WebElement boardDropDownField = waitToBeClickable(By.xpath(MainPageLocators.BOARD_FILTER_DROP_DOWN_LIST_PATH.getLocatorPath()), 5);
        boardDropDownField.click();
        List<WebElement> boardsElementsList = waitForVisibilityOfAll(By.xpath(MainPageLocators.BOARD_FILTER_VALUES_PATH.getLocatorPath()), 3);
        WebElement boardElement = boardsElementsList.get(boardId);
        boardElement.click();
    }

    public boolean checkAllTaskStatusesIsCorrect(String status){
        List<WebElement> statusesElements = getDriver().findElements(By.xpath(MainPageLocators.TASKS_STATUS_SPAN_LIST_PATH.getLocatorPath()));

        return statusesElements.stream()
                .map(WebElement::getText)
                .allMatch(text -> text.equals(status));

    }

    public boolean checkAllTaskBoardsIsCorrect(String board){
        List<WebElement> issuesParagraphsElements = getDriver().findElements(By.xpath(MainPageLocators.ISSUES_PARAGRAPH_LIST_PATH.getLocatorPath()));

        return issuesParagraphsElements.stream()
                .map(WebElement::getText)
                .allMatch(text -> text.contains(board));
    }

    public void createTask(String taskName, String description, int projectId, int priorityId, int executorId){
        clickOnTheCreateTaskButton();
        waitForVisibility(By.xpath(MainPageLocators.TASK_CREATION_FORM_PATH.getLocatorPath()), 3);

        inputTaskNameField(taskName);

        inputTaskDescriptionField(description);

        selectConcreteProjectTask(projectId);

        selectConcreteTaskPriorityStatus(priorityId);

        selectConcreteTaskExecutor(executorId);

        WebElement sendButtonForm = waitToBeClickable(By.xpath(MainPageLocators.SEND_BUTTON_FORM.getLocatorPath()), 3);
        sendButtonForm.click();
    }

    public void updateTask(String taskName, int priorityId, int executorId){
        waitForVisibility(By.xpath(MainPageLocators.TASK_CREATION_FORM_PATH.getLocatorPath()), 3);

        inputTaskNameField(taskName);
        selectConcreteTaskPriorityStatus(priorityId);

        selectConcreteTaskExecutor(executorId);
        WebElement updateButtonForm = waitToBeClickable(By.xpath(MainPageLocators.UPDATE_BUTTON_FORM.getLocatorPath()), 3);
        updateButtonForm.click();

    }


    public boolean allFoundTasksContain(String query){
        List<WebElement> issuesTitlesElements = waitForVisibilityOfAll(By.xpath(MainPageLocators.ISSUES_TITLES_LIST_PATH.getLocatorPath()), 10);
        return issuesTitlesElements.stream()
                .map(WebElement::getText)
                .allMatch(text -> text.contains(query));
    }

    public WebElement getConcreteTask(String taskName){
        return waitForVisibility(By.xpath(MainPageLocators.ISSUES_TITLES_LIST_PATH.getLocatorPath() + "[text()='" + taskName + "']"), 15);
    }

    public boolean checkNoOneTasksIsExist(){
        List<WebElement> issuesTitlesElements = getDriver().findElements(By.xpath(MainPageLocators.ISSUES_TITLES_LIST_PATH.getLocatorPath()));
        return issuesTitlesElements.isEmpty();
    }

    public boolean checkTaskExists(String taskName){
        WebElement issuesTitleElement = getConcreteTask(taskName);
        return issuesTitleElement.isDisplayed();
    }

    public void inputTaskNameField(String taskName){
        WebElement taskFieldNameElement = waitToBeClickable(By.xpath(MainPageLocators.TASK_FIELD_NAME_PATH.getLocatorPath()), 3);
        taskFieldNameElement.click();
        type(taskFieldNameElement, taskName);
    }

    public void inputTaskDescriptionField(String description){
        WebElement taskFieldDescriptionElement = waitToBeClickable(By.xpath(MainPageLocators.TASK_FIELD_DESCRIPTION_PATH.getLocatorPath()), 3);
        taskFieldDescriptionElement.click();
        type(taskFieldDescriptionElement, description);
    }

    public void selectConcreteProjectTask(int projectId){
        WebElement taskProjectDropDownListElement = waitToBeClickable(By.xpath(MainPageLocators.TASK_PROJECT_DROP_DOWN_LIST_PATH.getLocatorPath()), 3);
        taskProjectDropDownListElement.click();

        List<WebElement> taskProjectNamesDropDownList = waitForVisibilityOfAll(By.xpath(MainPageLocators.TASK_PROJECT_NAMES_LIST_PATH.getLocatorPath()), 3);
        WebElement projectNameElement = taskProjectNamesDropDownList.get(projectId);
        projectNameElement.click();
    }

    public void selectConcreteTaskPriorityStatus(int priorityId){
        WebElement taskPriorityDropDownListElement = waitToBeClickable(By.xpath(MainPageLocators.TASK_PRIORITY_DROP_DOWN_LIST_PATH.getLocatorPath()), 3);
        taskPriorityDropDownListElement.click();

        List<WebElement> taskPriorityStatusesDropDownList = waitForVisibilityOfAll(By.xpath(MainPageLocators.TASK_PRIORITY_STATUSES_DROP_DOWN_LIST_PATH.getLocatorPath()), 3);
        WebElement taskStatusElement = taskPriorityStatusesDropDownList.get(priorityId);
        taskStatusElement.click();
    }

    public void selectConcreteTaskExecutor(int executorId){
        WebElement taskExecutorDropDownListElement = waitToBeClickable(By.xpath(MainPageLocators.TASK_EXECUTOR_DROP_DOWN_LIST_PATH.getLocatorPath()), 3);
        taskExecutorDropDownListElement.click();

        List<WebElement> taskExecutorNamesDropDownList = waitForVisibilityOfAll(By.xpath(MainPageLocators.TASK_EXECUTOR_NAMES_LIST_PATH.getLocatorPath()), 3);
        WebElement taskExecutorNameElement = taskExecutorNamesDropDownList.get(executorId);
        taskExecutorNameElement.click();
    }








}
