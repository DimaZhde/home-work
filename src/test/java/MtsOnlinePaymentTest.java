import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.*;

public class MtsOnlinePaymentTest extends TestBase {

    @Test
    public void testOnlinePaymentTitle() {
        // Проверка куки-баннера (1 секунда ожидания)
        try {
            Thread.sleep(1000); // Ждем 1 секунду
            driver.findElement(By.xpath("//*[@id='cookie-agree']")).click();
        } catch (Exception ignored) {}

        WebElement title = driver.findElement(
                By.xpath("//*[@id='pay-section']//h2"));

        String actual = title.getText().replace("\n", " ").trim();
        assertEquals("Онлайн пополнение без комиссии", actual,
                "Название блока не соответствует ожидаемому");
    }

    @Test
    public void testPaymentLogosSimple() {
        // Проверка куки-баннера (1 секунда ожидания)
        try {
            Thread.sleep(1000); // Ждем 1 секунду
            driver.findElement(By.xpath("//*[@id='cookie-agree']")).click();
        } catch (Exception ignored) {}

        String[] expectedLogos = {"visa", "visa-verified", "mastercard", "mastercard-secure", "belkart"};
        for (String logoName : expectedLogos) {
            WebElement logo = driver.findElement(By.xpath(
                    "//*[@id='pay-section']//*[" +
                            "contains(translate(@alt,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'" + logoName + "') or " +
                            "contains(translate(@src,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'" + logoName + "') or " +
                            "contains(translate(@class,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'" + logoName + "')]"));
            assertTrue(logo.isDisplayed(), "Логотип " + logoName + " не отображается");
        }
    }

    @Test
    public void testDetailsLink() {
        // Проверка куки-баннера (1 секунда ожидания)
        try {
            Thread.sleep(1000); // Ждем 1 секунду
            driver.findElement(By.xpath("//*[@id='cookie-agree']")).click();
        } catch (Exception ignored) {}

        // 1. Находим и кликаем ссылку "Подробнее о сервисе"
        WebElement detailsLink = driver.findElement(
                By.xpath("//*[@id='pay-section']//a[contains(text(),'Подробнее о сервисе')]"));
        detailsLink.click();

        // 2. Проверяем заголовок на открывшейся странице
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        // По тексту заголовка
        WebElement cardPaymentHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h3[contains(text(),'Оплата банковской картой')]")));

        assertTrue(cardPaymentHeader.isDisplayed(),
                "Заголовок 'Оплата банковской картой' не отображается");
    }

    @Test
    public void testPaymentProcess() throws InterruptedException {
        // Проверка куки-баннера (1 секунда ожидания)
        try {
            Thread.sleep(1000); // Ждем 1 секунду
            driver.findElement(By.xpath("//*[@id='cookie-agree']")).click();
        } catch (Exception ignored) {}

        // 1. Заполняем поле телефона
        WebElement phoneInput = driver.findElement(By.xpath("//*[@id='connection-phone']"));
        phoneInput.clear();
        phoneInput.sendKeys("297777777");

        // 2. Заполняем поле суммы
        WebElement sumInput = driver.findElement(By.xpath("//*[@id='connection-sum']"));
        sumInput.clear();
        sumInput.sendKeys("100");

        // 3. Заполняем поле email
        WebElement emailInput = driver.findElement(By.xpath("//*[@id='connection-email']"));
        emailInput.clear();
        emailInput.sendKeys("zhde@mail.ru");

        // 4. Нажимаем кнопку "Продолжить"
        WebElement continueButton = driver.findElement(By.xpath("//*[@id='pay-connection']/button"));
        continueButton.click();

        // 5. Ожидаем обработки (3 секунды)
        Thread.sleep(2000);

        // 6. Проверяем результат - ищем номер 375297777777 на странице
        // 2. Ожидаем и переключаемся на iframe
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("iframe.bepaid-iframe")));
        driver.switchTo().frame(iframe);

        // 3. Ищем номер телефона внутри iframe
        WebElement elementWithPhone = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(text(), '375297777777')]")));

        // 4. Извлекаем полный текст и проверяем наличие номера
        String fullText = elementWithPhone.getText();
        assertTrue(fullText.contains("375297777777"),
                "Номер телефона 375297777777 не найден в тексте: " + fullText);

        // 5. Возвращаемся к основному контенту
        driver.switchTo().defaultContent();
    }
}