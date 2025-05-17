package Lesson_16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.jupiter.api.Test;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

public class MtsOnlinePaymentTest extends TestBase {

    @Test
    public void testAllPaymentOptions() {
        MtsHomePage homePage = new MtsHomePage(driver);
        homePage.acceptCookies();

        Map<String, Map<String, String>> testData = Map.of(
                "Услуги связи", Map.of(
                        "firstField", "Номер телефона",
                        "secondField", "Сумма",
                        "thirdField", "E-mail для отправки чека"
                ),
                "Домашний интернет", Map.of(
                        "firstField", "Номер абонента",
                        "secondField", "Сумма",
                        "thirdField", "E-mail для отправки чека"
                ),
                "Рассрочка", Map.of(
                        "firstField", "Номер счета на 44",
                        "secondField", "Сумма",
                        "thirdField", "E-mail для отправки чека"
                ),
                "Задолженность", Map.of(
                        "firstField", "Номер счета на 2073",
                        "secondField", "Сумма",
                        "thirdField", "E-mail для отправки чека"
                )
        );

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        testData.forEach((optionName, expectedPlaceholders) -> {
            // 1. Открываем выпадающий список
            WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(
                    By.cssSelector("div.select__wrapper button.select__header")));
            dropdown.click();

            // 2. Выбираем нужную опцию
            WebElement option = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//ul[@class='select__list']//p[contains(text(), '" + optionName + "')]")));
            option.click();

            // 3. Ждем, пока форма станет активной (имеет класс 'opened')
            String formId = getFormIdByOptionName(optionName);
            wait.until(ExpectedConditions.attributeContains(By.id(formId), "class", "opened"));

            // 4. Находим все input в активной форме
            WebElement activeForm = driver.findElement(By.id(formId));
            List<WebElement> inputs = activeForm.findElements(By.tagName("input"));

            // 5. Проверяем плейсхолдеры
            assertEquals(expectedPlaceholders.get("firstField"), inputs.get(0).getAttribute("placeholder"),
                    "Неверный плейсхолдер первого поля для опции: " + optionName);
            assertEquals(expectedPlaceholders.get("secondField"), inputs.get(1).getAttribute("placeholder"),
                    "Неверный плейсхолдер второго поля для опции: " + optionName);
            assertEquals(expectedPlaceholders.get("thirdField"), inputs.get(2).getAttribute("placeholder"),
                    "Неверный плейсхолдер третьего поля для опции: " + optionName);
        });
    }

    private String getFormIdByOptionName(String optionName) {
        switch (optionName) {
            case "Услуги связи": return "pay-connection";
            case "Домашний интернет": return "pay-internet";
            case "Рассрочка": return "pay-instalment";
            case "Задолженность": return "pay-arrears";
            default: throw new IllegalArgumentException("Unknown option: " + optionName);
        }
    }

    @Test
    public void testOnlinePaymentTitle() {
        MtsHomePage homePage = new MtsHomePage(driver);
        homePage.acceptCookies();

        assertEquals("Онлайн пополнение без комиссии",
                homePage.getPaymentTitle(),
                "Название блока не соответствует ожидаемому");
    }

    @Test
    public void testPaymentLogosSimple() {
        MtsHomePage homePage = new MtsHomePage(driver);
        homePage.acceptCookies();

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
        MtsHomePage homePage = new MtsHomePage(driver);
        homePage.acceptCookies();

        PaymentDetailsPage detailsPage = homePage.clickDetailsLink();
        assertTrue(detailsPage.isCardPaymentHeaderDisplayed(),
                "Заголовок 'Оплата банковской картой' не отображается");
    }

    @Test
    public void testPaymentProcess() {
        MtsHomePage homePage = new MtsHomePage(driver);
        homePage.acceptCookies();

        PaymentProcessPage paymentPage = homePage.startPaymentProcess(
                "297777777", "100", "zhde@mail.ru");

        try {
            assertTrue(paymentPage.isPhoneNumberDisplayed("375297777777"),
                    "Номер телефона не найден");
            assertTrue(paymentPage.isAmountDisplayed("100"),
                    "Сумма платежа не отображается");

            String[] fieldLabels = {"Номер карты", "Срок действия", "CVC", "Имя и фамилия на карте"};
            for (String label : fieldLabels) {
                assertTrue(paymentPage.isFieldLabelDisplayed(label),
                        "Неверная подпись для поля: " + label);
            }

            assertTrue(paymentPage.getVisiblePaymentIconsCount() >= 4,
                    "Ожидалось минимум 4 видимые иконки");
        } finally {
            paymentPage.switchToDefaultContent();
        }
    }
}