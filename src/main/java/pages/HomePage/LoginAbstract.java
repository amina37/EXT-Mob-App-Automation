package pages.HomePage;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginAbstract {
    public By loginBtn;
    public By emailTxt;
    public By passwordTxt;
    public By submitBtn;
    public By homePageNavBtn;
    public By servicesPageBtn;
    //service_item_name  |Test:Inquiry
    public By seeAllservicesBtn;
    public By requestsBtn;
    AppiumDriver driver;

    public LoginAbstract(AppiumDriver driver) {
        this.driver = driver;
    }

    //Login Button with username and password
    public void validationLogin() {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfElementLocated(loginBtn)).isDisplayed();
        driver.findElement(loginBtn).click();
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(emailTxt)).isDisplayed();
        driver.findElement(emailTxt).sendKeys("test3@bnsights.com");
        driver.findElement(passwordTxt).sendKeys("P@ssw0rd");
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(submitBtn)).isEnabled();
        driver.findElement(submitBtn).click();
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(homePageNavBtn)).isDisplayed();

    }
    //View Requets list
    public boolean validationOfRequestsList() {
        new WebDriverWait(driver, Duration.ofSeconds(60)).until(ExpectedConditions.invisibilityOfElementLocated(requestsBtn));
        driver.findElement(requestsBtn).click();
        return new WebDriverWait(driver, Duration.ofSeconds(60)).until(ExpectedConditions.elementToBeClickable(homePageNavBtn)).isDisplayed();
    }
}
