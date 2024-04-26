package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage.HomePageAbstract;
import pages.HomePage.HomePageAndroid;
import pages.HomePage.HomePageiOS;
import utilities.readers.PropertiesReader;

public class LoginTest extends BaseTest {


        HomePageAbstract homePage;
    public LoginTest() throws Exception {
            setUp();
            if(PropertiesReader.getValue("Platform").equalsIgnoreCase("Android"))
            {
                homePage = new HomePageAndroid(driver);
            }
            else {
                homePage = new HomePageiOS(driver);
            }
        }
        @Test()

        public void ValidateLoginTest()
        {
            homePage.validationLogin();
        }


    }



