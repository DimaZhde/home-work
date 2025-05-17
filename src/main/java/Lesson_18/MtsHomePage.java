package Lesson_18;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class MtsHomePage extends BasePage {
    @FindBy(id = "cookie-agree")
    private WebElement cookieAgreeButton;

    @FindBy(css = "select#pay")
    private WebElement paymentSelect;

    @FindBy(xpath = "//*[@id='pay-section']//h2")
    private WebElement paymentTitle;

    @FindBy(xpath = "//*[@id='pay-section']//a[contains(text(),'Подробнее о сервисе')]")
    private WebElement detailsLink;

    public MtsHomePage(WebDriver driver) {
        super(driver);
    }

    public void acceptCookies() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(cookieAgreeButton)).click();
        } catch (Exception ignored) {}
    }

    public String getPaymentTitle() {
        return paymentTitle.getText().replace("\n", " ").trim();
    }

    public void selectPaymentOption(String optionName) {
        new Select(paymentSelect).selectByVisibleText(optionName);
    }

    public String getSelectedFormId() {
        return new Select(paymentSelect)
                .getFirstSelectedOption()
                .getAttribute("data-open");
    }

    public PaymentDetailsPage clickDetailsLink() {
        detailsLink.click();
        return new PaymentDetailsPage(driver);
    }

    public PaymentForm getPaymentForm(String formId) {
        return new PaymentForm(driver, formId);
    }

    public PaymentProcessPage startPaymentProcess(String phone, String amount, String email) {
        PaymentForm form = getPaymentForm("pay-connection");
        form.fillPhoneNumber(phone);
        form.fillAmount(amount);
        form.fillEmail(email);
        form.submit();
        return new PaymentProcessPage(driver);
    }
}