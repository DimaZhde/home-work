package Lesson_18;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentForm {
    private final WebDriver driver;
    private final String formId;

    @FindBy(id = "connection-phone")
    private WebElement phoneInput;

    @FindBy(id = "connection-sum")
    private WebElement amountInput;

    @FindBy(id = "connection-email")
    private WebElement emailInput;

    @FindBy(css = "#pay-connection button")
    private WebElement submitButton;

    public PaymentForm(WebDriver driver, String formId) {
        this.driver = driver;
        this.formId = formId;
        PageFactory.initElements(driver, this);
    }

    public void fillPhoneNumber(String phone) {
        phoneInput.sendKeys(phone);
    }

    public void fillAmount(String amount) {
        amountInput.sendKeys(amount);
    }

    public void fillEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void submit() {
        submitButton.click();
    }

    public String getInputPlaceholder(int index) {
        return driver.findElements(By.cssSelector("#" + formId + " input[type='text']"))
                .get(index)
                .getAttribute("placeholder");
    }
}