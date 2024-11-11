package org.example;

import org.apache.log4j.Logger;
import org.example.pom.FormaPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class FormeTest {

    public static Logger logger = Logger.getLogger(FormeTest.class);

    public static String FIRS_NAME = "Anatolie";
    public static String LAST_NAME = "Snegur";
    public static String USER_MAIL = "ianiovita005@gmail.com";
    public static String USER_NUMBER = "0602989201";
    public static String USER_SUBJECTS = "hindi";
    public static String USER_ADRESS = "str. Sfanta Treime, nr. 2";
    public static String USER_STATE = "Haryana";
    public static String USER_COUNTRY = "Karnal";
    public static String USER_DATE = "31 Oct 2005";

    public static WebDriver driver;

    @BeforeClass
    public void BeforeClass() {
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ianik\\Desktop\\chromedriver-win64\\chromedriver.exe");
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*");
//        driver = new ChromeDriver(options);
//        driver.manage().window().maximize();
        driver = SeleniumDriver.getRemoteDriver();
    }

    @Test
    public void FormaTest() throws InterruptedException {
        logger.info("Test has been started");
        driver.get("https://demoqa.com/automation-practice-form");
        FormaPage page = new FormaPage(driver);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));



        // Completarea formularului
        page.setFirstName(FIRS_NAME);
        Thread.sleep(1000);
        page.setLastName(LAST_NAME);
        Thread.sleep(1000);
        page.setUserMail(USER_MAIL);
        Thread.sleep(1000);
        page.selectGenderMale();
        Thread.sleep(1000);
        page.setUserNumber(USER_NUMBER);
        Thread.sleep(1000);
        page.setUserDate(USER_DATE);
        Thread.sleep(1000);
        page.setUserSubjects(USER_SUBJECTS);
        Thread.sleep(1000);
        page.hobbiesCheckbox();
        Thread.sleep(1000);
//        page.uploadFile();
        page.setcurrentAddress(USER_ADRESS);
        Thread.sleep(1000);
        page.setUserState(USER_STATE);
        Thread.sleep(1000);
        page.setUserCountry(USER_COUNTRY);
        Thread.sleep(1000);
        page.clickSubmitButton();
        Thread.sleep(5000);

        // Asserts
//        Assert.assertEquals(page.getLastFirst(), FIRS_NAME + " " + LAST_NAME, "First and Last Name do not match.");
//        logger.info("Name has been set");
        Assert.assertEquals(page.getEmail(), USER_MAIL, "Email does not match.");
        logger.info("Email has been set");
        Assert.assertEquals(page.getGender(), "Male", "Gender does not match.");
        logger.info("Gender has been set");
        Assert.assertEquals(page.getNumber(), USER_NUMBER, "Mobile number does not match.");
//        Assert.assertEquals(page.getDate(), USER_DATE, "Date of birth does not match.");
//        Assert.assertEquals(page.getSubjects(), USER_SUBJECTS, "Subjects do not match.");
//        Assert.assertTrue(page.isHobbiesCheckboxSelected(), "Hobbies checkbox is not selected.");
//        Assert.assertEquals(page.getFile(), "download.png", "Uploaded file does not match.");
//        Assert.assertEquals(page.getAdress(), USER_ADRESS, "Address does not match.");
//        Assert.assertEquals(page.getStateCountry(), USER_STATE + " " + USER_COUNTRY, "State and Country do not match.");
        logger.info("Test finish, OK");
    }


    @AfterClass
    public void close() {
        driver.quit();
    }
}
