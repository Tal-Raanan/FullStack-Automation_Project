package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.WebFlows;

@Listeners(utilities.Listeners.class)
public class GrafanaWebDB extends CommonOps {

        @Test(description = "Test01 - Login To Grafana Using DB Credentials")
        @Description("This test perform login to Grafana using DB credentials and verifies the main header")
        public void test01_loginDBAndVerifyHeader() {
            WebFlows.loginDB();
            Verifications.verifyTextInElement(grafanaMain.head_Dashboard, "Welcome to Grafana");
        }
}
