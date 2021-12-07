package pageObjects.grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

//Class Name: AddNewUserPage
//Description: This class captures objects which are located at the Add New User page
public class AddNewUserPage {
    @FindBy(how = How.CSS, using = "input[name='name']")
    public WebElement txt_name;

    @FindBy(how = How.CSS, using = "input[name='email']")
    public WebElement txt_email;

    @FindBy(how = How.CSS, using = "input[name='login']")
    public WebElement txt_username;

    @FindBy(how = How.CSS, using = "input[name='password']")
    public WebElement txt_password;

    @FindBy(how = How.CSS, using = "button[class='css-5tn967-button']")
    public WebElement btn_create;
}