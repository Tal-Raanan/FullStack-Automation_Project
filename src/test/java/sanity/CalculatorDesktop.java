package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.ApiFlows;
import workflows.DesktopFlows;

@Listeners(utilities.Listeners.class)
public class CalculatorDesktop extends CommonOps {

    @Test(description = "Test01 - Verifies The Addition Command")
    @Description("This test verifies the addition command")
    public void test01_verifyAdditionCommand() {
        DesktopFlows.calculateAddition();
        Verifications.verifyTextInElement(calcMain.field_result, "Display is 12");
    }
}
