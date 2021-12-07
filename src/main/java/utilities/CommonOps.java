package utilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.windows.WindowsDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import org.w3c.dom.Document;
import workflows.ElectronFlows;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class CommonOps extends Base {

    // Method Name: getData
    // Method Description: This method gets the data from xml configuration file
    // Method Parameters: String
    // Method Return: String
    public static String getData(String nodeName) {
        File fXmlFile;
        DocumentBuilderFactory dbFactory;
        DocumentBuilder dBuilder;
        Document doc = null;
        try {
            fXmlFile = new File("./Configuration/DataConfig.xml");
            dbFactory = DocumentBuilderFactory.newInstance();
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
        }
        catch (Exception e){
            System.out.println("Error Reading XML File: " + e);
        }
        finally {
            return doc.getElementsByTagName(nodeName).item(0).getTextContent();
        }
    }

    // Method Name: initBrowser
    // Method Description: This method init the web browser according to its type
    // Method Parameters: String
    // Method Return: None
    public static void initBrowser(String browserType) {
        if (browserType.equalsIgnoreCase("chrome"))
            driver = initChromeDriver();
        else if (browserType.equalsIgnoreCase("firefox"))
            driver = initFirefoxDriver();
        else if (browserType.equalsIgnoreCase("ie"))
            driver = initIEDriver();

        else
            throw new RuntimeException("Invalid Browser Type");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Long.parseLong(getData("Timeout")));
        driver.get(getData("url"));
        ManagePages.initGrafana();
        action = new Actions(driver);
    }

    // Method Name: initChromeDriver
    // Method Description: This method init Chrome Driver
    // Method Parameters: None
    // Method Return: WebDriver
    public static WebDriver initChromeDriver() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        return driver;
    }

    // Method Name: initFireFoxDriver
    // Method Description: This method init FireFox Driver
    // Method Parameters: None
    // Method Return: WebDriver
    public static WebDriver initFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        return driver;
    }

    // Method Name: initIEDriver
    // Method Description: This method init IE Driver
    // Method Parameters: None
    // Method Return: WebDriver
    public static WebDriver initIEDriver() {
        WebDriverManager.iedriver().setup();
        WebDriver driver = new InternetExplorerDriver();
        return driver;
    }

    // Method Name: initMobile
    // Method Description: This method init Mobile
    // Method Parameters: None
    // Method Return: None
    public static void initMobile(){
        dc.setCapability(MobileCapabilityType.UDID, getData("UDID"));
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, getData("AppPackage"));
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, getData("AppActivity"));
        try {
            mobileDriver = new AndroidDriver(new URL(getData("AppiumServer")), dc);
        } catch (Exception e) {
            System.out.println("Can not connect to Appium server, see details: " + e);
        }
        ManagePages.initMortgage();
        mobileDriver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(mobileDriver, Long.parseLong(getData("Timeout")));
        action = new Actions(driver);
    }

    // Method Name: initAPI
    // Method Description: This method init API
    // Method Parameters: None
    // Method Return: None
    public static void initAPI(){
        RestAssured.baseURI = getData("urlAPI");
        httpRequest = RestAssured.given().auth().preemptive().basic(getData("Username"), getData("Password"));
    }

    // Method Name: initElectron
    // Method Description: This method init Electron
    // Method Parameters: None
    // Method Return: None
    public static void  initElectron(){
        System.setProperty("webdriver.chrome.driver", getData("ElectronDriverPath"));
        ChromeOptions opt = new ChromeOptions();
        opt.setBinary(getData("ElectronAppPath"));
        dc.setCapability("chromeOptions", opt);
        dc.setBrowserName("chrome");
        driver = new ChromeDriver(dc);
        ManagePages.initToDo();
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Long.parseLong(getData("Timeout")));
        action = new Actions(driver);
    }

    // Method Name: initDesktop
    // Method Description: This method init Desktop
    // Method Parameters: None
    // Method Return: None
    public static void initDesktop(){
        dc.setCapability("app", getData("CalculatorApp"));
        try {
            driver = new WindowsDriver(new URL(getData("AppiumServerDesktop")), dc);
        } catch (Exception e) {
            System.out.println("Can Not Connect To Appium Server, See Details:" + e);
        }
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Long.parseLong(getData("Timeout")));
        ManagePages.initCalculator();
    }

    // Method Name: startSession
    // Method Description: This method starts a session (due to the pre-selected platform)
    // Method Parameters: String
    // Method Return: None
    @BeforeClass
    @Parameters({"PlatformName"})
    public void startSession(String PlatformName) {
        platform = PlatformName;
        if (platform.equalsIgnoreCase("web"))
            initBrowser(getData("BrowserName"));
        else if(platform.equalsIgnoreCase("mobile"))
                initMobile();
        else if(platform.equalsIgnoreCase("api"))
            initAPI();
        else if(platform.equalsIgnoreCase("electron"))
            initElectron();
        else if(platform.equalsIgnoreCase("desktop"))
            initDesktop();
        else
            throw new RuntimeException("Invalid platform type");

        softAssert = new SoftAssert();
        screen = new Screen();
        ManageDB.openConnection(getData("DBURL"), getData("DBUsername"), getData("DBPassword"));
    }

    // Method Name: closeSession
    // Method Description: This method closes a session at the end of each class running
    // Method Parameters: None
    // Method Return: None
    @AfterClass
    public void closeSession() {
        ManageDB.closeConnection();
        if (!platform.equalsIgnoreCase("api")) {
            if (!platform.equalsIgnoreCase("mobile"))
                driver.quit();
            else
                mobileDriver.quit();
        }
    }

    // Method Name: afterMethod
    // Method Description: This method returns a platform to its default state at the end of each method running
    // Method Parameters: None
    // Method Return: None
    @AfterMethod
    public void afterMethod(){
        if (platform.equalsIgnoreCase("web"))
            driver.get(getData("url"));
        else if (platform.equalsIgnoreCase("electron")){
            ElectronFlows.emptyList();
        }
    }

    // Method Name: beforeMethod
    // Method Description: This method performs actions (start recording) at the beginning of method execution
    // Method Parameters: Method
    // Method Return: None
    @BeforeMethod
    public void beforeMethod(Method method) {
        if (!platform.equalsIgnoreCase("api")) {
            try {
                MonteScreenRecorder.startRecord(method.getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}


