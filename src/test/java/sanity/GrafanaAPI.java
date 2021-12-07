package sanity;

import extensions.ApiActions;
import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.ApiFlows;

@Listeners(utilities.Listeners.class)
public class GrafanaAPI extends CommonOps {

    @Test(description = "Test01 - Get Team From Grafana")
    @Description("This test verifies team property")
    public void test01_verifyTeam() {
        Verifications.verifyText(ApiFlows.getTeamProperty("teams[0].name"), "Testing");
    }

    @Test(description = "Test02 - Add Team And Verify")
    @Description("This test adds a team to Grafana and verifies it")
    public void test02_addTeamAndVerify() {
        ApiFlows.postTeam("Testing02", "addedteam@gmail.com");
        Verifications.verifyText(ApiFlows.getTeamProperty("teams[1].name"), "Testing02");
    }

    @Test(description = "Test03 - Update Team And Verify")
    @Description("This test updates a team to Grafana and verifies it")
    public void test03_updateTeamAndVerify() {
        String id = ApiFlows.getTeamProperty("teams[1].id");
        ApiFlows.updateTeam("Testing02","updatedemail@yahoo.com", id);
        Verifications.verifyText(ApiFlows.getTeamProperty("teams[1].email"), "updatedemail@yahoo.com");
    }

    @Test(description = "Test04 - Delete Team And Verify")
    @Description("This test deletes a team in Grafana and verifies it")
    public void test04_deleteTeamAndVerify() {
        String id = ApiFlows.getTeamProperty("teams[1].id");
        ApiFlows.deleteTeam(id);
        Verifications.verifyText(ApiFlows.getTeamProperty("totalCount"), "1");
    }
}