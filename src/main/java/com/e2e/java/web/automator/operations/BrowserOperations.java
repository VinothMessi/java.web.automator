package com.e2e.java.web.automator.operations;

import io.testproject.sdk.drivers.web.RemoteWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public interface BrowserOperations {
    Consumer<RemoteWebDriver> MAXIMIZE_THE_BROWSER = d -> d.manage().window().maximize();
    Consumer<RemoteWebDriver> CLOSE_CURRENT_BROWSER = RemoteWebDriver::close;
    Consumer<RemoteWebDriver> CLOSE_ALL_BROWSERS = RemoteWebDriver::quit;

    BiConsumer<RemoteWebDriver, String> NAVIGATE_TO = RemoteWebDriver::get;

    Function<RemoteWebDriver, String> PAGE_TITLE = RemoteWebDriver::getTitle;
    Function<RemoteWebDriver, String> CURRENT_URL = RemoteWebDriver::getCurrentUrl;
    Function<RemoteWebDriver, String> PAGE_SOURCE = RemoteWebDriver::getPageSource;

    BiFunction<RemoteWebDriver, By, WebElement> IDENTIFY = RemoteWebDriver::findElement;

}