package sanity;

import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.WebFlows;

@Listeners(utilities.Listeners.class)
public class GrafanaWeb extends CommonOps {

    @Test(description = "Test01 - Verify Header")
    @Description("This test verifies the main header")
    public void test01_verifyHeader() {
        WebFlows.login(getData("Username"), getData("Password"));
        Verifications.verifyTextInElement(grafanaMain.head_Dashboard, "Welcome to Grafana");
    }

    @Test(description = "Test02 - Verify Default users")
    @Description("This test verifies the default users")
    public void test02_verifyDefaultUsers() {
        UIActions.mouseHover(grafanaLeftMenu.btn_server, grafanaServerAdmin.link_users);
        Verifications.numberOfElements(grafanaServerAdminMain.rows, 1);
    }

    @Test(description = "Test03 - Verify New User")
    @Description("This test verifies a new user has been added successfully")
    public void test03_createNewUser() {
        UIActions.mouseHover(grafanaLeftMenu.btn_server, grafanaServerAdmin.link_users);
        WebFlows.createNewUser("John", "johnsmith@gmail.com", "JohnS", "john1954");
        Verifications.elementIsVisible(grafanaServerAdminMain.secondaryUser);
        Verifications.numberOfElements(grafanaServerAdminMain.rows, 2);
    }

    @Test(description = "Test04 - Verify User Deletion")
    @Description("This test verifies the deletion of a user")
    public void test04_verifyUserDeletion() throws InterruptedException {
        UIActions.mouseHover(grafanaLeftMenu.btn_server, grafanaServerAdmin.link_users);
        WebFlows.deleteLastUser();
        Verifications.numberOfElements(grafanaServerAdminMain.rows, 1);
    }

    @Test(description = "Test05 - Verify Progress Steps")
    @Description("This test verifies the default progress steps are displayed (using soft assertion")
    public void test05_verifyProgressSteps() {
        Verifications.visibilityOfElements(grafanaMain.list_progressSteps);
    }

    @Test(description = "Test06 - Verify Avatar Icon")
    @Description("This test verifies the avatar image using Sikuli tool")
    public void test06_verifyAvatarIcon() {
        Verifications.visualElement("GrafanaAvatar");
    }

    @Test(description = "Test07 - Search Users", dataProvider = "data-provider-users", dataProviderClass = utilities.ManageDDT.class)
    @Description("This test searches for users in a table, using DDT")
    public void test07_searchUsers(String user, String shouldExist) {
        UIActions.mouseHover(grafanaLeftMenu.btn_server, grafanaServerAdmin.link_users);
        WebFlows.searchAndVerifyUser(user, shouldExist);
    }
}

