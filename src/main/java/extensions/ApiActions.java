package extensions;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import utilities.CommonOps;

public class ApiActions extends CommonOps {

    @Step("Get Data From Server")
    public static Response get(String paramValues) {
        response = httpRequest.get(paramValues);
        response.prettyPrint();
        return response;
    }

    @Step("Extract Value From JSON Format")
    public static String extractFromJSON(Response response, String path) {
        jp = response.jsonPath();
        return jp.get(path).toString();
    }

    @Step("Post Data To Server")
    public static void post(JSONObject params, String resource) {
        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(params.toJSONString());
        response = httpRequest.post(resource);
        response.prettyPrint();
    }

    @Step("Update Data In Server")
    public static void put(JSONObject params, String resource) {
        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(params.toJSONString());
        response = httpRequest.put(resource);
        response.prettyPrint();
    }

    @Step("Delete Data From Server")
    public static void delete(String id) {
        response = httpRequest.delete("/api/teams/" + id);
        response.prettyPrint();
    }
}

