package pageObjects.calculator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

//Class Name: MainPage
//Description: This class captures objects which are located at the main page
public class MainPage {

    @FindBy(how = How.NAME, using = "Clear")
    public WebElement btn_clear;

    @FindBy(how = How.NAME, using = "One")
    public WebElement btn_one;

    @FindBy(how = How.NAME, using = "Eight")
    public WebElement btn_eight;

    @FindBy(how = How.NAME, using = "Plus")
    public WebElement btn_Plus;

    @FindBy(how = How.NAME, using = "Equals")
    public WebElement btn_equals;

    @FindBy(how = How.XPATH, using = "//*[@AutomationId='CalculatorResults']")
    public WebElement field_result;
}

/*Note: Additional working method - WebElement is "private" (not public):
    public WebElement getBtn_clear(){
        return btn_clear;
} */
