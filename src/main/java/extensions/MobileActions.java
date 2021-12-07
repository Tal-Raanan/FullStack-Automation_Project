package extensions;

import com.google.common.util.concurrent.Uninterruptibles;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.CommonOps;

import java.util.concurrent.TimeUnit;

public class MobileActions extends CommonOps {

    @Step("Update Text Element")
    public static void updateText(MobileElement elem, String text) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        elem.sendKeys(text);
    }

    @Step("Tap On Element")
    public static void tap(int fingers, MobileElement elem, int duration) {
        wait.until(ExpectedConditions.elementToBeClickable(elem));
//        mobileDriver.tap(fingers, elem, duration);
    }

    @Step("Swipe")
    public static void swipe(int startX, int startY, int endX, int endY, int duration) {
        Uninterruptibles.sleepUninterruptibly(500, TimeUnit.MILLISECONDS);
//        mobileDriver.swipe(startX, startY, endX, endY, duration);
    }

    @Step("Zoom Element")
    public static void zoom(MobileElement elem) {
        wait.until(ExpectedConditions.visibilityOf(elem));
//        mobileDriver.zoom(elem);
    }

    @Step("Pinch Element")
    public static void pinch(MobileElement elem) {
        wait.until(ExpectedConditions.visibilityOf(elem));
//        mobileDriver.pinch(elem);
    }

    @Step("Execute Script")
    public static void executeScript(String script) {
        mobileDriver.executeScript(script);
    }

}
