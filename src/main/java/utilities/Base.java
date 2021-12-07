package utilities;

import io.appium.java_client.AppiumDriver;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.asserts.SoftAssert;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class Base {
    //Abstract objects - init via CommonOps
        //General
    protected static WebDriverWait wait;
    protected static Actions action;
    protected static SoftAssert softAssert;
    protected static Screen screen;
    protected static String platform;

        //Web
    protected static WebDriver driver;

        //Mobile
    protected static AppiumDriver mobileDriver;
    protected static DesiredCapabilities dc = new DesiredCapabilities();

        //Rest API
    protected static RequestSpecification httpRequest;
    protected static Response response;
    protected static JSONObject params = new JSONObject();
    protected static JsonPath jp;

        //Database
    protected static Connection con;
    protected static Statement stmt;
    protected static ResultSet rs;

    //Page Objects - Web - init via ManagePages
    protected static pageObjects.grafana.LoginPage grafanaLogin;
    protected static pageObjects.grafana.MainPage grafanaMain;
    protected static pageObjects.grafana.LeftMenuPage grafanaLeftMenu;
    protected static pageObjects.grafana.ServerAdminMenuPage grafanaServerAdmin;
    protected static pageObjects.grafana.ServerAdminMainPage grafanaServerAdminMain;
    protected static pageObjects.grafana.AddNewUserPage grafanaAddNewUser;
    protected static pageObjects.grafana.UserInformationPage grafanaUserInformation;

    //Page Objects - Mobile - init via ManagePages
    protected static pageObjects.mortgage.MainPage mortgageMain;

    //Page Objects - Electron
    protected static pageObjects.todo.MainPage todoMain;

    //Page Objects - Desktop
    protected static pageObjects.calculator.MainPage calcMain;
}

