package com.e2e.java.web.automator;

import com.e2e.java.web.automator.annotations.Object;
import com.e2e.java.web.automator.repository.FlightdetailsRepository;
import io.testproject.sdk.drivers.web.RemoteWebDriver;
import io.testproject.sdk.internal.reporting.Reporter;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.*;

@SpringBootTest
public class ApplicationTests extends AbstractTestNGSpringContextTests {

    @Object
    protected RemoteWebDriver browser;

    @Object
    protected FlightdetailsRepository flightdetailsRepository;

    protected Reporter rDriver;

    @BeforeClass
    public void setUp() {
        rDriver = browser.report();
    }

}