import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.*;

@Feature("sdadsasd")
public class UITest {

    String baseurl = "http://www.pchelovod.info/";

    @Story("adsadsad")
    @Test
    void registrationWrongPass() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().savePageSource(false).screenshots(true));
        open(baseurl);
        $(By.linkText("Вход")).click();
//        $(By.name("UserName")).setValue("User123456");
//        $(By.name("PassWord")).setValue("1234567");
//        $(By.name("submit")).click();
//        $(By.xpath("//span[@class='postcolor']")).shouldHave(text("Неверный пароль. Все пароли чувствительны к регистру"));

    }

//    @Test
//    void registrationWrongUser() {
//        open(baseurl);
//        $(By.linkText("Вход")).click();
//        $(By.name("UserName")).setValue("User12345");
//        $(By.name("PassWord")).setValue("1234567");
//        $(By.name("submit")).click();
//        $(By.xpath("//span[@class='postcolor']")).shouldHave(text("Невозможно найти пользователя с введенными вами данными."));
//    }


//    @Test
//    void registrationPositive() {
//        open(baseurl);
//        $(By.linkText("Вход")).click();
//        $(By.name("UserName")).setValue("User123456");
//        $(By.name("PassWord")).setValue("123456");
//        $(By.name("submit")).click();
//
//    }


}
