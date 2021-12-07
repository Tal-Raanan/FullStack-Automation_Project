package workflows;

import extensions.ApiActions;
import io.qameta.allure.Step;
import utilities.CommonOps;

public class ApiFlows extends CommonOps {

    @Step("Business Flow: Get Team Property")
    public static String getTeamProperty(String jPath){
    response = ApiActions.get("/api/teams/search");
    return ApiActions.extractFromJSON(response, jPath);
    }

    @Step("Business Flow: Create New Team In Grafana")
    public static void postTeam(String name, String email){
        params.put("name", name);
        params.put("email", email);
        ApiActions.post(params, "/api/teams");
    }

    @Step("Business Flow: Update An Existing Team In Grafana")
    public static void updateTeam(String name, String email, String id){
        params.put("name", name);
        params.put("email", email);
        ApiActions.put(params, "/api/teams/" + id);
    }

    @Step("Business Flow: Delete An Existing Team In Grafana")
    public static void deleteTeam(String id){
        ApiActions.delete(id);
    }
}
