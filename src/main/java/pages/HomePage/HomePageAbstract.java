package pages.HomePage;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePageAbstract {

    public By skipBtn;
    public By loginBtn;
    public By emailTxt;
    public By passwordTxt;
    public By submitBtn;
    public By homePageNavBtn;
    public By servicesPageBtn;
    public By mediaBtn;
    public By mystreyShopperBtn;
    //service_item_name  |Test:Inquiry
    public By seeAllservicesBtn;
    public By requetsBtn;
    AppiumDriver driver;

    public HomePageAbstract(AppiumDriver driver) {
        this.driver = driver;
    }
    //Skip Button
    public boolean validationSkip() {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(skipBtn)).isDisplayed();
        driver.findElement(skipBtn).click();
        return new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(skipBtn)).isDisplayed();
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

    //See all services in home page Button
    public boolean validationSeeAllServices() {
        driver.findElement(seeAllservicesBtn).click();
        new WebDriverWait(driver, Duration.ofSeconds(60)).until(ExpectedConditions.elementToBeClickable(servicesPageBtn)).isDisplayed();
        return new WebDriverWait(driver, Duration.ofSeconds(60)).until(ExpectedConditions.elementToBeClickable(servicesPageBtn)).isDisplayed();
    }

    //Media Btn in home page as a guest
    public boolean validationMediaBtn() {
        new WebDriverWait(driver, Duration.ofSeconds(60)).until(ExpectedConditions.invisibilityOfElementLocated(skipBtn));
        driver.findElement(mediaBtn).click();
        return new WebDriverWait(driver, Duration.ofSeconds(60)).until(ExpectedConditions.elementToBeClickable(mediaBtn)).isDisplayed();
    }

    //View Requets list
    public boolean validationOfRequestsList() {
        new WebDriverWait(driver, Duration.ofSeconds(60)).until(ExpectedConditions.invisibilityOfElementLocated(requetsBtn));
        driver.findElement(requetsBtn).click();
        return new WebDriverWait(driver, Duration.ofSeconds(60)).until(ExpectedConditions.elementToBeClickable(homePageNavBtn)).isDisplayed();
    }

    //Mystery Shopper Button
    public boolean validationMystreyShopper() {
        driver.findElement(mystreyShopperBtn).click();
        driver.close();
        driver.getCapabilities();
        return new WebDriverWait(driver, Duration.ofSeconds(60)).until(ExpectedConditions.elementToBeClickable(mystreyShopperBtn)).isDisplayed();
    }


}
