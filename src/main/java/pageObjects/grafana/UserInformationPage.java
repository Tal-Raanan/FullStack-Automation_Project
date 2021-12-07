package pageObjects.grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

//Class Name: UserInformationPage
//Description: This class captures objects which are located at the user information page
public class UserInformationPage {
    @FindBy(how = How.XPATH, using = "//*[@id=\"reactRoot\"]/div/div[2]/div[3]/div/div[1]/div/div[2]/div[1]/div[2]/button[1]")
    public WebElement btn_deleteUser;

    @FindBy(how = How.CSS, using = "button[aria-label='Confirm Modal Danger Button']")
    public WebElement btn_ConfirmDeleteUser;
}

