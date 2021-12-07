package pageObjects.grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

//Class Name: LeftMenuPage
//Description: This class captures objects which are located at the left menu
public class LeftMenuPage {
    @FindBy(how = How.XPATH, using = "//div[@Class=\"sidemenu-item dropdown\"][5]")
    public WebElement btn_alerting;

    @FindBy(how = How.XPATH, using = "//div[@Class=\"sidemenu-item dropdown\"][6]")
    public WebElement btn_configuration;

    @FindBy(how = How.XPATH, using = "//div[@Class=\"sidemenu-item dropdown\"][7]")
    public WebElement btn_server;
}
