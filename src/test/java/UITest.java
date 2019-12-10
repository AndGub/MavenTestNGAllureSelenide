import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

@Feature("Тест авторизации")
public class UITest {

    String baseurl = "http://www.pchelovod.info/";

    @BeforeTest
    void beforeTest() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
        open(baseurl);
    }

    @Test
    void registrationWrongPass() {
        $(By.linkText("Вход")).click();
        $(By.name("UserName")).setValue("User123456");
        $(By.name("PassWord")).setValue("1234567");
        $(By.name("submit")).click();
        $(By.xpath("//span[@class='postcolor']")).shouldHave(text("Неверный пароль. Все пароли чувствительны к регистру"));
    }

    @Test
    void registrationWrongUser() {
        $(By.linkText("Вход")).click();
        $(By.name("UserName")).setValue("User12345");
        $(By.name("PassWord")).setValue("1234567");
        $(By.name("submit")).click();
        $(By.xpath("//span[@class='postcolor']")).shouldHave(text("Невозможно найти пользователя с введенными вами данными."));
    }

    @Test
    void registrationWrongUserFailing() {
        $(By.linkText("Вход")).click();
        $(By.name("UserName")).setValue("User12345");
        $(By.name("PassWord")).setValue("1234567");
        $(By.name("submit")).click();
        $(By.xpath("//span[@class='postcolor']")).shouldHave(text("Неверный текст, чтобы тест упал"));
    }

    @Test
    void registrationPositive() {
        $(By.linkText("Вход")).click();
        $(By.name("UserName")).setValue("User123456");
        $(By.name("PassWord")).setValue("123456");
        $(By.name("submit")).click();
        $(By.id("redirectwrap")).shouldBe(visible);
        $(By.linkText("Выход")).click();
    }

}
