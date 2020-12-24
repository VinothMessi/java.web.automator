package com.e2e.java.web.automator.testcases;

import com.e2e.java.web.automator.ApplicationTests;
import com.e2e.java.web.automator.annotations.Object;
import com.e2e.java.web.automator.entity.Flightdetails;
import com.e2e.java.web.automator.workflow.FlightReservationBusinessFlow;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

public class FlightReservation extends ApplicationTests {

    @Object
    private FlightReservationBusinessFlow ReservationBusinessFlow;

    @Value("${app.url}")
    private String appURL;

    @Test(testName = "Flight Reservation", description = "Flight Reservation Business Flow", dataProvider = "FlightReservation")
    public void flightReservation(Flightdetails fd) {
        ReservationBusinessFlow.homepage(p -> {
            p.goTo(appURL);
            assertThat(p.hasItLoaded()).isTrue();
            System.out.println("Page Title: " + p.getPageHeader());
            p.startRegistration();
        }).registration(p -> {
            assertThat(p.hasItLoaded()).isTrue();
            System.out.println("Page Header: " + p.getPageHeader());
            System.out.println("Page Description: " + p.getPageDescription());
            p.getContactInformation().hasItLoaded();
            p.getContactInformation().fillContactInformations(fd.getFirstName(), fd.getLastName(), fd.getPhone(), fd.getEmail());
            p.getMailingInformation().hasItLoaded();
            p.getMailingInformation().fillMailingInformations(fd.getAddress(), fd.getCity(), fd.getState(), fd.getPostalCode(),
                    fd.getCountry());
            p.getUserInformation().hasItLoaded();
            p.getUserInformation().fillUserInformations(fd.getUserName(), fd.getPassword(), fd.getConfirmPassword());
            p.goToRegistrationConfirmationPage();
        }).confirmation(p -> {
            assertThat(p.hasItLoaded()).isTrue();
            System.out.println(p.getPageHeader());
            p.goToFlightDetailsPage();
        }).flightdetails(p -> {
            assertThat(p.hasItLoaded()).isTrue();
            System.out.println("Page Header: " + p.getPageHeader());
            System.out.println("Page Description: " + p.getPageDescription());
            p.getFlightDetails().hasItLoaded();
            p.getFlightDetails().chooseTripType(fd.getTripType());
            p.getFlightDetails().selectNoOfPassengers(fd.getPassengers());
            p.getFlightDetails().departingDetails(fd.getDepartingPlace(), fd.getDepartingMonth(), fd.getArrivingDate());
            p.getFlightDetails().arrivingDetails(fd.getArrivingPlace(), fd.getArrivingMonth(), fd.getArrivingDate());
            p.getPreferences().selectAirline(fd.getAirline());
            p.goToSelectFlightsPage();
        }).selectflights(p -> {
            assertThat(p.hasItLoaded()).isTrue();
            p.goToBillingAddressPage();
        }).billingaddress(p -> {
            assertThat(p.hasItLoaded()).isTrue();
            p.fillInBillingAddress("Line1", "Line2", fd.getCity(), fd.getState(), fd.getPostalCode());
            p.goToItineraryPage();
        }).flightitinerary(p -> {
            assertThat(p.hasItLoaded()).isTrue();
            p.getConfirmationMessages();
            rDriver.step("Flight Reservation Business Flow", "Flight Reservation", true);
            // p.shutDown();
        });
    }

    @DataProvider(name = "FlightReservation")
    public java.lang.Object[] getContactInformations() {
        return flightdetailsRepository.findAll().stream().collect(Collectors.toList()).toArray();
    }

}