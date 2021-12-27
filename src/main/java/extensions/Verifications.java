package extensions;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.sikuli.script.FindFailed;
import utilities.CommonOps;
import java.util.List;
import static org.testng.Assert.*;

public class Verifications extends CommonOps {

    @Step("Verify Text In Element")
    public static void verifyTextInElement(WebElement elem, String expected) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        assertEquals(elem.getText(), expected);
    }

    @Step("Verify Number Of Elements")
    public static void numberOfElements(List<WebElement> elems, int expected) {
        wait.until(ExpectedConditions.visibilityOf(elems.get(elems.size() - 1)));
        assertEquals(elems.size(), expected);
    }

    @Step("Verify Visibility Of Elements")
    public static void visibilityOfElements (List<WebElement> elems){
        for (WebElement elem : elems) {
            softAssert.assertTrue(elem.isDisplayed(), "Sorry " + elem.getText() + " is not displayed");
        }
        softAssert.assertAll("Some elements were not displayed");
    }

    // Using Sikulix
    // <ImageRepo> = C:\\Automation\\Final_Project\\ImageRepository\\
    @Step("Verify Element Visually")
    public static void visualElement(String expectedImageName){
        try {
            screen.find(getData("ImageRepo") + expectedImageName + ".png");
        } catch (FindFailed findFailed) {
            System.out.println("Error Comparing Image File: " + findFailed);
            fail("Error Comparing Image File: " + findFailed);

        }
    }

    @Step("Verify Element Displayed")
    public static void existenceOfElement(List<WebElement> elements){
        assertTrue(elements.size() > 0);
    }

    @Step("Verify Element Not Displayed")
    public static void nonExistenceOfElement(List<WebElement> elements){
        assertFalse(elements.size() > 0);
    }

    @Step("Verify Text Similarity")
    public static void verifyText (String actual, String expected){
        assertEquals(actual, expected);
    }

    @Step("Verify Number Similarity")
    public static void verifyNumber (int actual, int expected){
        assertEquals(actual, expected);
    }

    @Step("Verify Element Is Visible")
    public static void elementIsVisible(WebElement elem) {
        wait.until(ExpectedConditions.visibilityOf(elem));
    }

    @Step("Verify Element Is Invisible")
    public static void elementIsInvisible(WebElement elem) {
        wait.until(ExpectedConditions.invisibilityOf(elem)); }

}


