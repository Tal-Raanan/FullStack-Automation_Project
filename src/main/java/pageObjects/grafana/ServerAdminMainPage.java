package pageObjects.grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import java.util.List;

//Class Name: ServerAdminMainPage
//Description: This class captures objects which are located at the server admin main page
public class ServerAdminMainPage {
    @FindBy(how = How.XPATH, using = "//*[@id=\"reactRoot\"]/div/div[2]/div[3]/div/div[1]/div/div[2]/div[2]/table/tbody/tr")
    public List<WebElement> rows;

    @FindBy(how = How.CSS, using = "span[class='css-1mhnkuh']")
    public WebElement btn_newUser;

    @FindBy(how = How.XPATH, using = "//*[@id=\"reactRoot\"]/div/div[2]/div[3]/div/div[1]/div/div[2]/div[2]/table/tbody/tr")
    public WebElement defaultUser;

    @FindBy(how = How.CSS, using = "a[title='JohnS']")
    public WebElement secondaryUser;

    @FindBy(how = How.CSS, using = "input[placeholder='Search user by login, email, or name.']")
    public WebElement txt_search;

}
