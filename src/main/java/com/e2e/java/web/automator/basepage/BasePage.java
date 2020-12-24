package com.e2e.java.web.automator.basepage;

import com.e2e.java.web.automator.operations.BrowserOperations;
import com.e2e.java.web.automator.operations.ElementValidator;
import com.e2e.java.web.automator.operations.WebElementOperations;
import io.testproject.sdk.drivers.web.RemoteWebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public abstract class BasePage implements BrowserOperations, WebElementOperations, ElementValidator {

    @Autowired
    protected RemoteWebDriver browser;

    @PostConstruct
    private void init() {
        PageFactory.initElements(browser, this);
    }

    public abstract boolean hasItLoaded();

    protected void just(Consumer<RemoteWebDriver> c) {
        c.accept(browser);
    }

    protected void just(BiConsumer<RemoteWebDriver, String> c, String s) {
        c.accept(browser, s);
    }

    protected String fetch(Function<WebElement, String> f, WebElement ele) {
        return f.apply(ele);
    }

    protected String fetch(Function<RemoteWebDriver, String> f) {
        return f.apply(browser);
    }

    protected void just(Consumer<WebElement> c, WebElement ele) {
        c.accept(ele);
    }

    protected void please(BiConsumer<WebElement, String> c, String s, WebElement ele) {
        c.accept(ele, s);
    }

    protected boolean verifyWhether(Predicate<WebElement> p, WebElement ele) {
        return p.test(ele);
    }

}