package StepDefinitions;

import Pages.apiRequests;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.text.ParseException;

public class unixTimeSteps extends apiRequests {

    @Given("user send valid unixTime {string} request")
    public void userSendValidUnixTimeRequest(String unixTime) {
        apiRequests.getUnixTime(unixTime);
        getCurrentDate();
        getCurrentEpochTime();

    }

    @Then("verify that the response is success for {string}")
    public void verifyThatTheResponseIsSuccessFor(String unixTime) throws ParseException {
        Assert.assertEquals(200, apiRequests.getUnixTime(unixTime)
                .statusCode());
        Assert.assertEquals("application/json; charset=utf-8", apiRequests.getUnixTime(unixTime)
                .contentType());
        Assert.assertTrue(validateDateFormat(getUnixTime(unixTime).path("Datetime").toString()));
    }


    @Given("user send invalid unixTime {string} request")
    public void userSendInvalidUnixTimeRequest(String invalidUnixTime) {
        apiRequests.getUnixTime(invalidUnixTime);
    }

    @Then("verify that the response contains error message {string} for {string}")
    public void verifyThatTheResponseContainsErrorMessage(String message, String unixTime) {
        Assert.assertTrue(apiRequests.getBodyAsString(unixTime).contains(message));
    }

    @Given("user send unixTime {string} of mission-critical production service request")
    public void userSendUnixTimeOfMissionCriticalProductionServiceRequest(String unixTime) {
        apiRequests.getUnixTime(unixTime);
    }

    @Then("verify that the mission-critical date, hour, minute, and second is showed for {string}")
    public void verifyThatTheMissionCriticalDateHourMinuteAndSecondIsShowed(String unixTime) {
        String str = getUnixTime(unixTime).path("Datetime").toString();
        str = str.replace("-", " ").replace(":", " ");
        String[] arrayStr = str.split(" ");
        System.out.println("The mission date was on: ");
        System.out.println("Year:" + arrayStr[0] + "\n" +
                           "Month:" + arrayStr[1] + "\n" +
                           "Day:" + arrayStr[2] + "\n" +
                           "Hour:" + arrayStr[3] + "\n" +
                           "Minute:" + arrayStr[4] + "\n" +
                           "Second:" + arrayStr[5] + "\n");
    }

    @Given("user send the current unixTime")
    public void userSendTheCurrentUnixTime() {
        apiRequests.getUnixTime(getCurrentEpochTime());
    }

    @Then("verify that the response is success with current time")
    public void verifyThatTheResponseIsSuccessWithCurrentTime() {
        Assert.assertEquals(getBodyAsString(getCurrentEpochTime()).substring(13, 29), getCurrentDate().substring(0, getCurrentDate().length() - 3));
    }
}
