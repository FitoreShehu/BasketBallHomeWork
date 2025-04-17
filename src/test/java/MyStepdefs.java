import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import stepDefs.Methods.WaitMethods;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MyStepdefs {
    WebDriver driver;


    @Given("User is using {string} as a web-browser.")
    public void userIsUsingAsAWebdriver(String browser) {
        if (browser.equals("Edge")) {
            driver = new EdgeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.manage().window().maximize();


        } else if (browser.equals("Chrome")) {
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.manage().window().maximize();
        }

    }

    @Given("User is on the register-page {string}")
    public void userIsOnThePage(String webPage) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(webPage);

    }

    @When("User writes the date of birth {string}")
    public void userWriteTheDateOfBirth(String dateOfBirth) {
        WaitMethods.sendKeys(driver, By.xpath("//input[@id='dp']"), dateOfBirth);

    }


    @And("User writes the name {string}")
    public void userWritesTheName(String inputName) {
        WaitMethods.sendKeys(driver, By.cssSelector("input[id='member_firstname']"), inputName);

    }

    @And("User writes the lastname {string}")
    public void userWritesTheLastname(String inputLastName) {
        WebElement lastName = driver.findElement(By.xpath("//input[@id='member_lastname']"));
        lastName.sendKeys(inputLastName);
    }

    @When("User writes the email {string}")
    public void userWritesTheEmail(String inputEmail) {
        WebElement email = driver.findElement(By.xpath("//input[@id='member_emailaddress']"));
        email.sendKeys(inputEmail);
    }

    @When("User writes the confirm email  {string}")
    public void userWritesTheConfirmEmailAddress(String confirmEmail) {
        WebElement secondEmail = driver.findElement(By.xpath("//input[@id='member_confirmemailaddress']"));
        secondEmail.sendKeys(confirmEmail);
    }

    @When("User write the password {string}")
    public void userWriteThePassword(String inputPassword) {
        WebElement password = driver.findElement(By.xpath("//input[@id='signupunlicenced_password']"));
        password.sendKeys(inputPassword);

    }

    @And("User write the retype password {string}")
    public void userWriteTheRetypePassword(String retypePassword) {
        WebElement secondPassword = driver.findElement(By.xpath("//input[@id='signupunlicenced_confirmpassword']"));
        secondPassword.sendKeys(retypePassword);
    }

    @Then("User choose the role Fan in basketball")
    public void selectRole() {
        WaitMethods.click(driver, By.xpath("//label[@for='signup_basketballrole_19']"));


    }

    @And("User is on the account confirmation and accepts the Terms and Conditions")
    public void theTermsAndConditions() {
        WaitMethods.click(driver, By.xpath("//label[@for='sign_up_25']"));

    }
    @And("User is on the account confirmation and declines the Terms and Conditions")
    public void TermsAndConditions() {
    }

    @And("User accepts that they are an adult")
    public void verifyAdult() {
        WaitMethods.click(driver, By.xpath("//label[@for='sign_up_26']"));

    }

    @Then("User is on the communication preferences and accepts the first checkbox")
    public void selectFirstPreference() {
        WaitMethods.click(driver, By.xpath("//label[@for='sign_up_27']"));
    }

    @And("User accepts the checkbox for agreeing to the Basketball England Code of Ethics and Conduct")
    public void agreeToBasketballEthics() {
        WaitMethods.click(driver, By.xpath("//label[@for='fanmembersignup_agreetocodeofethicsandconduct']"));

    }

    @And("User clicks the red button to submit")
    public void RedButtonToSubmit() {
        WebElement submit = driver.findElement(By.name("join"));
        submit.click();

    }

    @Then("Account creation is confirmed successfully")
    public void accountSuccess() {
        WebElement accountConfirmationHeader = driver.findElement(By.xpath("//h2[.='THANK YOU FOR CREATING AN ACCOUNT WITH BASKETBALL ENGLAND']"));
        String expectedHeader = "THANK YOU FOR CREATING AN ACCOUNT WITH BASKETBALL ENGLAND";
        String actualHeader = accountConfirmationHeader.getText();
        assertEquals(expectedHeader, actualHeader);
    }


    @Then("User get the error message {string}")
    public void userGetTheErrorMessage(String expectedErrorMessage) {
        WebElement webelement = driver.findElement(By.xpath("//span[@class='warning field-validation-error'][1]"));
        String actualErrorMessage = webelement.getText();
        System.out.println("expectedErrorMessage = " + expectedErrorMessage);
        System.out.println("actualerrormesage = " + webelement.getText());
        assertEquals(expectedErrorMessage, actualErrorMessage);
        assertTrue(webelement.isDisplayed(),"The element is not displayed");
    }

    @And("User forget to write the lastname")
    public void userForgetToWriteTheLastname() {

    }

    @When("User does not enter the confirm email")
    public void userDoesNotEnterTheConfirmEmail() {

    }

    @And("User does not write the retype password")
    public void userDoesNotWriteTheRetypePassword() {

    }

    @And("User does not accepts that they are an adult")
    public void userDoesNotAcceptsThatTheyAreAnAdult() {

    }

    @And("User does not accepts the checkbox for agreeing to the Basketball England Code of Ethics and Conduct")
    public void userDoesNotAcceptsTheCheckboxForAgreeingToTheBasketballEnglandCodeOfEthicsAndConduct() {

    }

    @Then("User get all the error message displayed")
    public void userGetAllTheErrorMessageDisplayed(List<String> expectedErrorMessage) {
        List<String>actualErrorMessage = new ArrayList<>();
        List<WebElement> actualElements = driver.findElements(By.xpath("//span[@class='warning field-validation-error']"));

        for (WebElement actualElement : actualElements) {
            String text = actualElement.getText();
            if (!text.isEmpty()) {
                actualErrorMessage.add(text);
            }
        }
        System.out.println("expectedErrorMessage = " + expectedErrorMessage);
        System.out.println("actualErrorMessage = " + actualErrorMessage);
        assertEquals(expectedErrorMessage,actualErrorMessage);
    }
//    private  void click( By by){
//        (new WebDriverWait(driver, Duration.ofSeconds(10))).until(ExpectedConditions.elementToBeClickable(by));
//        driver.findElement(by).click();
//    }
}
