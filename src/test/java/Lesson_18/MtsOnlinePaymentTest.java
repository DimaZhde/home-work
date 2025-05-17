package Lesson_18;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.jupiter.api.Test;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

@Epic("MTS Online Payments")
@Feature("Проверка функционала оплаты")
public class MtsOnlinePaymentTest extends TestBase {

    @Test
    @Story("Проверка вариантов оплаты")
    @Description("Тест проверяет корректность плейсхолдеров для всех вариантов оплаты")
    @Severity(SeverityLevel.CRITICAL)
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
            Allure.step("Открываем выпадающий список с вариантами оплаты", () -> {
                WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(
                        By.cssSelector("div.select__wrapper button.select__header")));
                dropdown.click();
            });

            Allure.step("Выбираем опцию: " + optionName, () -> {
                WebElement option = wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//ul[@class='select__list']//p[contains(text(), '" + optionName + "')]")));
                option.click();
            });

            Allure.step("Проверяем форму для опции: " + optionName, () -> {
                String formId = getFormIdByOptionName(optionName);
                wait.until(ExpectedConditions.attributeContains(By.id(formId), "class", "opened"));

                WebElement activeForm = driver.findElement(By.id(formId));
                List<WebElement> inputs = activeForm.findElements(By.tagName("input"));

                assertEquals(expectedPlaceholders.get("firstField"), inputs.get(0).getAttribute("placeholder"),
                        "Неверный плейсхолдер первого поля для опции: " + optionName);
                assertEquals(expectedPlaceholders.get("secondField"), inputs.get(1).getAttribute("placeholder"),
                        "Неверный плейсхолдер второго поля для опции: " + optionName);
                assertEquals(expectedPlaceholders.get("thirdField"), inputs.get(2).getAttribute("placeholder"),
                        "Неверный плейсхолдер третьего поля для опции: " + optionName);
            });
        });
    }

    @Test
    @Story("Проверка заголовка")
    @Description("Тест проверяет корректность отображения заголовка блока оплаты")
    @Severity(SeverityLevel.NORMAL)
    public void testOnlinePaymentTitle() {
        MtsHomePage homePage = new MtsHomePage(driver);
        homePage.acceptCookies();

        Allure.step("Проверяем заголовок блока оплаты", () -> {
            assertEquals("Онлайн пополнение без комиссии",
                    homePage.getPaymentTitle(),
                    "Название блока не соответствует ожидаемому");
        });
    }

    @Test
    @Story("Проверка логотипов")
    @Description("Тест проверяет отображение логотипов платежных систем")
    @Severity(SeverityLevel.MINOR)
    public void testPaymentLogosSimple() {
        MtsHomePage homePage = new MtsHomePage(driver);
        homePage.acceptCookies();

        Allure.step("Проверяем отображение логотипов", () -> {
            String[] expectedLogos = {"visa", "visa-verified", "mastercard", "mastercard-secure", "belkart"};
            for (String logoName : expectedLogos) {
                WebElement logo = driver.findElement(By.xpath(
                        "//*[@id='pay-section']//*[" +
                                "contains(translate(@alt,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'" + logoName + "') or " +
                                "contains(translate(@src,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'" + logoName + "') or " +
                                "contains(translate(@class,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'" + logoName + "')]"));
                assertTrue(logo.isDisplayed(), "Логотип " + logoName + " не отображается");
            }
        });
    }

    @Test
    @Story("Проверка ссылки")
    @Description("Тест проверяет работу ссылки 'Подробнее о сервисе'")
    @Severity(SeverityLevel.NORMAL)
    public void testDetailsLink() {
        MtsHomePage homePage = new MtsHomePage(driver);
        homePage.acceptCookies();

        Allure.step("Кликаем на ссылку 'Подробнее'", () -> {
            PaymentDetailsPage detailsPage = homePage.clickDetailsLink();

            Allure.step("Проверяем отображение заголовка", () -> {
                assertTrue(detailsPage.isCardPaymentHeaderDisplayed(),
                        "Заголовок 'Оплата банковской картой' не отображается");
            });
        });
    }

    @Test
    @Story("Процесс оплаты")
    @Description("Тест проверяет корректность отображения формы оплаты")
    @Severity(SeverityLevel.CRITICAL)
    public void testPaymentProcess() {
        MtsHomePage homePage = new MtsHomePage(driver);
        homePage.acceptCookies();

        Allure.step("Заполняем данные для оплаты", () -> {
            PaymentProcessPage paymentPage = homePage.startPaymentProcess(
                    "297777777", "100", "zhde@mail.ru");

            try {
                Allure.step("Проверяем отображение номера телефона", () -> {
                    assertTrue(paymentPage.isPhoneNumberDisplayed("375297777777"),
                            "Номер телефона не найден");
                });

                Allure.step("Проверяем отображение суммы", () -> {
                    assertTrue(paymentPage.isAmountDisplayed("100"),
                            "Сумма платежа не отображается");
                });

                Allure.step("Проверяем поля формы", () -> {
                    String[] fieldLabels = {"Номер карты", "Срок действия", "CVC", "Имя и фамилия на карте"};
                    for (String label : fieldLabels) {
                        assertTrue(paymentPage.isFieldLabelDisplayed(label),
                                "Неверная подпись для поля: " + label);
                    }
                });

                Allure.step("Проверяем иконки платежных систем", () -> {
                    assertTrue(paymentPage.getVisiblePaymentIconsCount() >= 4,
                            "Ожидалось минимум 4 видимые иконки");
                });
            } finally  {
                paymentPage.switchToDefaultContent();
            }
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
}