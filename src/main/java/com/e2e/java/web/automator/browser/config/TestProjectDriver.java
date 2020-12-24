package com.e2e.java.web.automator.browser.config;

import com.e2e.java.web.automator.annotations.Browser;
import io.testproject.sdk.DriverBuilder;
import io.testproject.sdk.drivers.web.RemoteWebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import java.net.MalformedURLException;
import java.net.URL;

@Lazy
@Configuration
public class TestProjectDriver {

    @Value("${dev.token}")
    private String devToken;

    @Value("${agent.url}")
    private String agentUrl;

    @Value("${project.name}")
    private String projectName;

    @Value("${job.name}")
    private String jobName;

    @Browser
    @ConditionalOnProperty(name = "browser.name", havingValue = "chrome")
    public RemoteWebDriver chrome() throws MalformedURLException {
        return new DriverBuilder<RemoteWebDriver>(new ChromeOptions()).withToken(this.devToken)
                .withProjectName(this.projectName).withJobName(this.jobName).withRemoteAddress(new URL(this.agentUrl))
                .build(RemoteWebDriver.class);
    }

    @Browser
    @ConditionalOnProperty(name = "browser.name", havingValue = "firefox")
    public RemoteWebDriver firefox() throws MalformedURLException {
        return new DriverBuilder<RemoteWebDriver>(new FirefoxOptions()).withToken(this.devToken)
                .withProjectName(this.projectName).withJobName(this.jobName).withRemoteAddress(new URL(this.agentUrl))
                .build(RemoteWebDriver.class);
    }

    @Browser
    @ConditionalOnProperty(name = "browser.name", havingValue = "edge")
    public RemoteWebDriver edge() throws MalformedURLException {
        return new DriverBuilder<RemoteWebDriver>(new EdgeOptions()).withToken(this.devToken)
                .withProjectName(this.projectName).withJobName(this.jobName).withRemoteAddress(new URL(this.agentUrl))
                .build(RemoteWebDriver.class);
    }

    @Browser
    @ConditionalOnProperty(name = "browser.name", havingValue = "ie")
    public RemoteWebDriver ie() throws MalformedURLException {
        return new DriverBuilder<RemoteWebDriver>(new InternetExplorerOptions()).withToken(this.devToken)
                .withProjectName(this.projectName).withJobName(this.jobName).withRemoteAddress(new URL(this.agentUrl))
                .build(RemoteWebDriver.class);
    }

}