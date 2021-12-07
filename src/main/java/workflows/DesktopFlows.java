package workflows;

import extensions.UIActions;
import io.qameta.allure.Step;
import utilities.CommonOps;

public class DesktopFlows extends CommonOps {

    @Step("Business Flow: Calculate Addition: 1 + 8")
    public static void calculateAddition(){
        UIActions.click(calcMain.btn_clear);
        UIActions.click(calcMain.btn_one);
        UIActions.click(calcMain.btn_Plus);
        UIActions.click(calcMain.btn_eight);
        UIActions.click(calcMain.btn_equals);
    }
}
