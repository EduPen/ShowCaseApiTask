package StepDefinitions;

import Utilities.ConfigurationReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;

import static io.restassured.RestAssured.baseURI;


public class Hooks {

    @Before
    public void setUp(){
        baseURI= ConfigurationReader.get("api_url");
    }

    @After
    public void tearDown(){

    }

}
