package org.example.enums;

import lombok.Getter;

@Getter
public enum MainPageLocators {
    PROJECT_REFERENCE_PATH("//div[@class='MuiBox-root css-10egq61']/a[text()='Проекты']"),
    ISSUES_PARAGRAPH_LIST_PATH("//div[@class='MuiPaper-root MuiPaper-outlined MuiPaper-rounded css-atox0b']/p"),
    BOARD_FILTER_VALUES_PATH("//li[@class='MuiButtonBase-root MuiMenuItem-root MuiMenuItem-gutters MuiMenuItem-root MuiMenuItem-gutters css-5dycmn']"),
    TASKS_STATUS_SPAN_LIST_PATH("//span[@class='MuiChip-label MuiChip-labelSmall css-b9zgoq']"),
    STATUS_FILTER_VALUES_PATH("//li[@class='MuiButtonBase-root MuiMenuItem-root MuiMenuItem-gutters MuiMenuItem-root MuiMenuItem-gutters css-5dycmn']"),
    STATUS_FILTER_DROP_DOWN_LIST_PATH("//div[@class='MuiInputBase-root MuiOutlinedInput-root MuiInputBase-colorPrimary MuiInputBase-formControl MuiInputBase-sizeSmall MuiSelect-root css-98ra8i'][1]"),
    BOARD_FILTER_DROP_DOWN_LIST_PATH("//div[@class='MuiGrid-root MuiGrid-direction-xs-row MuiGrid-grid-xs-12 MuiGrid-grid-sm-6 MuiGrid-grid-md-3 css-qoghzg'][last()]"),
    INPUT_TASK_PATH("//input[@class='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputSizeSmall MuiInputBase-inputAdornedStart css-1m7embp']"),
    ISSUES_TITLES_LIST_PATH("//div[@class='MuiPaper-root MuiPaper-outlined MuiPaper-rounded css-atox0b']/div/h6"),
    SEND_BUTTON_FORM("//div[@class='MuiGrid-root MuiGrid-direction-xs-row css-1n5khr6']/button[text()='Создать']"),
    UPDATE_BUTTON_FORM("//div[@class='MuiGrid-root MuiGrid-direction-xs-row css-1n5khr6']/button[text()='Обновить']"),
    TASK_EXECUTOR_NAMES_LIST_PATH("//ul/li[@class='MuiButtonBase-root MuiMenuItem-root MuiMenuItem-gutters MuiMenuItem-root MuiMenuItem-gutters css-5dycmn']"),
    TASK_EXECUTOR_DROP_DOWN_LIST_PATH("//div[@class='MuiFormControl-root MuiFormControl-fullWidth css-17qa0m8']/label[text()='Исполнитель']/parent::div"),
    TASK_PRIORITY_STATUSES_DROP_DOWN_LIST_PATH("//ul/li[@class='MuiButtonBase-root MuiMenuItem-root MuiMenuItem-gutters MuiMenuItem-root MuiMenuItem-gutters css-5dycmn']"),
    TASK_PRIORITY_DROP_DOWN_LIST_PATH("//div[@class='MuiFormControl-root MuiFormControl-fullWidth css-17qa0m8']/label[text()='Приоритет']/parent::div"),
    TASK_PROJECT_NAMES_LIST_PATH("//ul/li[@class='MuiButtonBase-root MuiMenuItem-root MuiMenuItem-gutters MuiMenuItem-root MuiMenuItem-gutters css-5dycmn']"),
    TASK_PROJECT_DROP_DOWN_LIST_PATH("//div[@class='MuiFormControl-root MuiFormControl-fullWidth css-17qa0m8']/label[text()='Проект']/parent::div"),
    TASK_FIELD_DESCRIPTION_PATH("//textarea[@class='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputMultiline css-s63k3s'][1]"),
    TASK_FIELD_NAME_PATH("//input[@class='MuiInputBase-input MuiOutlinedInput-input css-1pk1fka']"),
    TASK_CREATION_FORM_PATH("//div[@class='MuiBox-root css-1epuubg']"),
    CREATE_TASK_BUTTON_PATH("//div[@class='MuiContainer-root MuiContainer-maxWidthMd css-f9xje0']/button[contains(text(),'Создать задачу')]");

    private final String locatorPath;

    MainPageLocators(String locatorPath){
        this.locatorPath = locatorPath;
    }


}
