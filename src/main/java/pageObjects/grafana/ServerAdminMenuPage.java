package pageObjects.grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

//Class Name: ServerAdminMenuPage
//Description: This class captures objects which are located at the server admin menu page
public class ServerAdminMenuPage {
    @FindBy(how = How.XPATH, using = "//a[@href='/admin/users']")
    public WebElement link_users;

    @FindBy(how = How.XPATH, using = "//a[@href='/admin/orgs']")
    public WebElement link_orgs;

    @FindBy(how = How.XPATH, using = "//a[@href='/admin/settings']")
    public WebElement link_settings;
}
