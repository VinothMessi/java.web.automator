package com.e2e.java.web.automator.flightpagecomponents;

import com.e2e.java.web.automator.annotations.Page;
import com.e2e.java.web.automator.basepage.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Page
public class UserInformation extends BasePage {

    @FindBy(name = "email")
    private WebElement userName;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(name = "confirmPassword")
    private WebElement confirmPassword;

    public void fillUserInformations(String uName, String passWord, String conPassword) {
        please(TYPE, uName, this.userName);
        please(TYPE, passWord, this.password);
        please(TYPE, conPassword, this.confirmPassword);
    }

    @Override
    public boolean hasItLoaded() {
        return verifyWhether(WE_CAN_SEE.and(WE_CAN_CLICK), this.userName) &&
                verifyWhether(WE_CAN_SEE.and(WE_CAN_CLICK), this.password) &&
                verifyWhether(WE_CAN_SEE.and(WE_CAN_CLICK), this.confirmPassword);
    }

}