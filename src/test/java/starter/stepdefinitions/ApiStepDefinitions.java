package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static net.serenitybdd.rest.SerenityRest.given;

public class ApiStepDefinitions {
    //  file just throws exceptions whenever Cucumber tries to execute the steps and mark them as Pending
    RequestSpecification res;
    Response ResponseBody, ResponseTest;
    TestDataBuild bodyData = new TestDataBuild();

    @Given("API test Given system print")
    public void api_test_given_system_print() {
        System.out.println("Hello API Given in console");
        res = given().baseUri("https://rahulshettyacademy.com").basePath("/maps/api/place/add/json").queryParam("key", "qaclick123")
                .body(bodyData.addPlacePayload("AAhouse", "English", "World cross center")).accept(ContentType.JSON)
                .contentType(ContentType.JSON);

        ResponseBody = res.when().log().all().post();
        System.out.println(ResponseBody.getStatusCode());
        //System.out.println(ResponseBody);
    }

    @When("API test When system print")
    public void api_test_when_system_print() {
        System.out.println("Hello API When in console");
        System.out.println(getJsonpath(ResponseBody, "status"));
    }
    @Then("API test Then system print")
    public void api_test_then_system_print() {
        System.out.println("Hello API Then in console");
        System.out.println(getJsonpath(ResponseBody, "place_id"));
    }

    public String getJsonpath(Response responseBod, String key) {
        // Returns specific key value of JSON response body
        String ResponseStr = responseBod.asString();
        // parse JSON string or file
        JsonPath jp = new JsonPath(ResponseStr);
        return jp.get(key).toString();
    }

}
