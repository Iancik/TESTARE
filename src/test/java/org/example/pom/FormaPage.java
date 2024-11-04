package org.example.pom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.openqa.selenium.JavascriptExecutor;


public class FormaPage {

    public static WebDriver driver;
    public static JavascriptExecutor javascriptExecutor;

    public FormaPage(WebDriver driver) {
        FormaPage.driver = driver;
        FormaPage.javascriptExecutor = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id='firstName']")
    private WebElement firstNameEl;

    public void setFirstName(String firstNameParam) {
        firstNameEl.sendKeys(firstNameParam);
    }

    @FindBy(xpath = "//*[@id='lastName']")
    private WebElement lastNameEL;

    public void setLastName(String lastNameParam) {
        lastNameEL.sendKeys(lastNameParam);
    }

    @FindBy(xpath = "//*[@id='userEmail']")
    private WebElement userMailEl;

    public void setUserMail(String userMailParam) {
        userMailEl.sendKeys(userMailParam);
    }

    @FindBy(xpath = "//label[@class='custom-control-label' and text()='Male']")
    private WebElement genderRadioMaleEl;

    public void selectGenderMale() {
        genderRadioMaleEl.click();
    }

    @FindBy(xpath = "//*[@id='userNumber']")
    private WebElement userNumberEl;

    public void setUserNumber(String userNumberParam) {
        userNumberEl.sendKeys(userNumberParam);
    }

    @FindBy(id = "dateOfBirthInput")
    private WebElement userDateEl;

    public void setUserDate(String userDateParam) {
        userDateEl.click();
        javascriptExecutor.executeScript("arguments[0].value='';", userDateEl);
        userDateEl.sendKeys(userDateParam);
        userDateEl.sendKeys(Keys.ENTER);
    }

    @FindBy(xpath = "//*[@id='subjectsInput']")
    private WebElement userSubjectsEl;

    public void setUserSubjects(String userSubjectsParam) {
        userSubjectsEl.sendKeys(userSubjectsParam);
        userSubjectsEl.sendKeys(Keys.ENTER);
    }

    @FindBy(xpath = "//label[text()='Sports']")
    private WebElement hobbiesCheckboxEl;

    public void hobbiesCheckbox() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", hobbiesCheckboxEl);
        hobbiesCheckboxEl.click();
    }

    @FindBy(id = "uploadPicture")
    private WebElement uploadInputEl;

    public void uploadFile() {
        String filePath = Paths.get(System.getProperty("user.home"), "Desktop", "download.png").toString();
        uploadInputEl.sendKeys(filePath);
    }

    @FindBy(xpath = "//*[@id='currentAddress']")
    private WebElement currentAddressEl;

    public void setcurrentAddress(String currentAddressParam) {
        currentAddressEl.sendKeys(currentAddressParam);
    }

    @FindBy(id ="react-select-3-input")
    private WebElement userStateEl;

    public void setUserState(String userStateParam) {
        userStateEl.sendKeys(userStateParam);
        userStateEl.sendKeys(Keys.ENTER);
    }


    @FindBy(id ="react-select-4-input")
    private WebElement userCountryEl;

    public void setUserCountry(String userCountryParam) {
        userCountryEl.sendKeys(userCountryParam);
        userCountryEl.sendKeys(Keys.ENTER);
    }



    @FindBy(xpath = "//button[@type='submit' and text()='Submit']")
    private WebElement submitButtonEl;

    public void clickSubmitButton() {
        submitButtonEl.click();
    }


}
