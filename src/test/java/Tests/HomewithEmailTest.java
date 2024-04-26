package Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage.HomePageAbstract;
import pages.HomePage.HomePageAndroid;
import pages.HomePage.HomePageiOS;
import utilities.readers.PropertiesReader;

public class HomewithEmailTest extends BaseTest{
    HomePageAbstract homePage;
    LoginTest login;
    public HomewithEmailTest() throws Exception {
        setUp();
        if(PropertiesReader.getValue("Platform").equalsIgnoreCase("Android"))
        {
            homePage = new HomePageAndroid(driver);
        }
        else {
            homePage = new HomePageiOS(driver);
        }
    }
    @BeforeMethod()

    public void addLogin()
    {
        login.ValidateLoginTest();
    }
    @Test()

    public void ValidateRequestsTest()
    {
      Assert.assertTrue(homePage.validationOfRequestsList());
    }


}
