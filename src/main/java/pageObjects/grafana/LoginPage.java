package pageObjects.grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

//Class Name: LoginPage
//Description: This class captures objects which are located at the login page
public class LoginPage {
    @FindBy(how = How.NAME, using = "user")
    public WebElement txt_username;

    @FindBy(how = How.NAME, using = "password")
    public WebElement txt_password;

    @FindBy(how = How.CSS, using = "button[class='css-w9m50q-button']")
    public WebElement btn_login;

    @FindBy(how = How.CSS, using = "button[class='css-g4ra35-button']")
    public WebElement btn_skip;

}
