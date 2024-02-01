package com.virgingames.pages;

import com.virgingames.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends Utility {

    private static final Logger log = LogManager.getLogger(HomePage.class.getName());

    public HomePage() {
        PageFactory.initElements(driver, this);

    }
    @CacheLookup
    @FindBy(xpath = "//ul[@class='StyledNavigationMenuList-sc-v46bks-1 ctndtu nav-bar']//li")
    List<WebElement> headers;

    @CacheLookup
    @FindBy(xpath = "//img[contains(@alt,'Virgin Games')")
    WebElement companyLogo;

    @CacheLookup
    @FindBy(xpath = "/canvas[contains(@data-tracking,'{\"label\":\"Hero Banner\",\"mvtVariant\":\"\",\"mvtCampaign\":\"\"}')]")
    WebElement welcomePage;

    @CacheLookup
    @FindBy(xpath = "//a[contains(.,'Login')]")
    WebElement loginButton;

    @CacheLookup
    @FindBy(xpath = "//a[contains(.,'Join Now')]")
    WebElement joinNowButton;

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Welcome to Virgin Games')]")
    WebElement welcomeMessage;

    @CacheLookup
    @FindBy(css= "label[for='privacy_pref_optin']")
    WebElement handleCookies;

    public Boolean verifyCompanyLogo() {
        log.info("Verifying orangeHRM Logo from : " + companyLogo.toString());
        return verifyThatElementIsDisplayed(new HomePage().companyLogo);
    }

    public void clickOnWelcomePage() {
        clickOnElement(welcomePage);
        log.info("Clicking on Admin link : " + welcomePage.toString());
    }


    public void clickOnAllHeaders(String tab) {
        log.info("Clicking on headers: " + headers.toString());
        for (WebElement menu : headers) {
            if (menu.getText().contains(tab)) {
                clickOnElement(menu);
                break;
            }
        }
    }

    public void clickOnJoinNow() {
        clickOnElement(joinNowButton);
        log.info("Clicking on JoinNow Button  : " + joinNowButton.toString());
    }

    public void iAcceptCookies() {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", handleCookies);
        log.info("Clicking accept cookies: " + handleCookies.toString());

      }


    public String getWelcomeText() {
        log.info("Getting text from : " + welcomeMessage.toString());
        return getTextFromElement(welcomeMessage);
    }
    public void mouseHooverOnLogin(){
        mouseHoverToElement(loginButton);
    }
}
