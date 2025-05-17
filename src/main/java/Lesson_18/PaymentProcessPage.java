package Lesson_18;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;

public class PaymentProcessPage extends BasePage {
    public PaymentProcessPage(WebDriver driver) {
        super(driver);
        WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("iframe.bepaid-iframe")));
        driver.switchTo().frame(iframe);
    }

    public boolean isPhoneNumberDisplayed(String phone) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(text(), '" + phone + "')]")));
        return element.isDisplayed();
    }

    public boolean isAmountDisplayed(String amount) {
        List<WebElement> elements = wait.until(ExpectedConditions
                .presenceOfAllElementsLocatedBy(By.xpath("//*[contains(., '" + amount + "')]")));
        return !elements.isEmpty();
    }

    public boolean isFieldLabelDisplayed(String labelText) {
        WebElement element = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//label[contains(., '" + labelText + "')]")));
        return element.isDisplayed() && element.getText().trim().equals(labelText);
    }

    public int getVisiblePaymentIconsCount() {
        List<WebElement> icons = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                By.xpath("//div[contains(@class, 'cards-brands__container')]//img[not(contains(@style, 'opacity: 0'))]")));
        return icons.size();
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }
}