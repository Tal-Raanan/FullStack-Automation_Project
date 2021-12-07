package pageObjects.grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import java.util.List;

//Class Name: MainPage
//Description: This class captures objects which are located at the main page
public class MainPage {
    @FindBy(how = How.XPATH, using = "//div[@class=\"css-1m290ug\"]/h1")
    public WebElement head_Dashboard;

    @FindBy(how = How.XPATH, using = "//*[@id=\"reactRoot\"]/div/div[2]/div[3]/div[2]/div/div[1]/div/div[2]/div[2]/div/div[1]/div/div[2]/div/div[2]/div")
    public List<WebElement> list_progressSteps;

}
