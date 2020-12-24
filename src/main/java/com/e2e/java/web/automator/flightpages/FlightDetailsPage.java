package com.e2e.java.web.automator.flightpages;

import com.e2e.java.web.automator.annotations.Object;
import com.e2e.java.web.automator.annotations.Page;
import com.e2e.java.web.automator.basepage.BasePage;
import com.e2e.java.web.automator.flightpagecomponents.FlightDetails;
import com.e2e.java.web.automator.flightpagecomponents.Preferences;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;

@Page
public class FlightDetailsPage extends BasePage {

    @Object
    private FlightDetails flightDetails;

    @Object
    private Preferences preferences;

    @FindBy(xpath = "(//div[@id='cid_37']//h1)[3]")
    private WebElement pageHeader;

    @FindBy(xpath = "((//div[@id='cid_37'])[5]//font)[1]")
    private WebElement pageDescription;

    @FindBy(name = "findFlights")
    private WebElement findFlights;

    public String getPageHeader() {
        return fetch(TEXT_FROM, this.pageHeader);
    }

    public String getPageDescription() {
        return fetch(TEXT_FROM, this.pageDescription);
    }

    public void goToSelectFlightsPage() {
        just(CLICK_ON, this.findFlights);
    }

    @Override
    public boolean hasItLoaded() {
        await().atMost(5, TimeUnit.SECONDS).until(() -> verifyWhether(WE_CAN_SEE, this.pageHeader));
        return verifyWhether(WE_CAN_SEE, this.pageDescription) &&
                verifyWhether(WE_CAN_SEE.and(WE_CAN_CLICK), this.findFlights);
    }

    public FlightDetails getFlightDetails() {
        return flightDetails;
    }

    public Preferences getPreferences() {
        return preferences;
    }

}