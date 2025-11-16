package org.example.enums;

import lombok.Getter;

@Getter
public enum BoardPageLocators {
    EDIT_CARD_FORM_PATH("//div[@class='MuiBox-root css-1epuubg']"),
    TASK_CARD_PATH("//div[@class='MuiCardContent-root css-15q2cw4']/h6"),
    CONCRETE_BOARD_NAME_PATH("//h4[@class='MuiTypography-root MuiTypography-h4 MuiTypography-gutterBottom css-1p2zds4']"),
    REDESIGN_CARD_BOARD_REFERENCE_PATH("//div[@class='MuiPaper-root MuiPaper-outlined MuiPaper-rounded css-lrhoby']//h6[text()='Редизайн карточки товара']/following-sibling::a"),
    OPTIMIZATION_PERFORMANCE_BOARD_REFERENCES_PATH("//div[@class='MuiPaper-root MuiPaper-outlined MuiPaper-rounded css-lrhoby']//h6[text()='Оптимизация производительности']/following-sibling::a"),
    PROJECTS_LIST_PATH("//div[@class='MuiPaper-root MuiPaper-outlined MuiPaper-rounded css-lrhoby']");

    private final String locatorPath;

    BoardPageLocators(String locatorPath){
        this.locatorPath = locatorPath;
    }
}
