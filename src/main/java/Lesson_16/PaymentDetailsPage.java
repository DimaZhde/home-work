package Lesson_16;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PaymentDetailsPage extends BasePage {
    @FindBy(xpath = "//h3[contains(text(),'Оплата банковской картой')]")
    private WebElement cardPaymentHeader;

    public PaymentDetailsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isCardPaymentHeaderDisplayed() {
        return cardPaymentHeader.isDisplayed();
    }
}