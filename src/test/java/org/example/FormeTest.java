package org.example;

import org.example.pom.FormaPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.LocalDate;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FormeTest {
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
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ianik\\Desktop\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

    }

    @Test
    public void FormaTest() {
        driver.get("https://demoqa.com/automation-practice-form");
        FormaPage page = new FormaPage(driver);
          page.setFirstName(FIRS_NAME);
          page.setLastName(LAST_NAME);
          page.setUserMail(USER_MAIL);
          page.selectGenderMale();
          page.setUserNumber(USER_NUMBER);
          page.setUserDate(USER_DATE);
          page.setUserSubjects(USER_SUBJECTS);
          page.hobbiesCheckbox();
          page.uploadFile();
          page.setcurrentAddress(USER_ADRESS);
          page.setUserState(USER_STATE);
          page.setUserCountry(USER_COUNTRY);
          page.clickSubmitButton();

    }

    @AfterClass
    public void close() {
        driver.quit();
    }
}
