import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class UITest {

    String baseurl = "http://www.pchelovod.info/";

    @Test
    void registrationWrongPass() {
        open(baseurl);
        $(By.linkText("Вход")).click();
        $(By.name("UserName")).setValue("User123456");
        $(By.name("PassWord")).setValue("1234567");
        $(By.name("submit")).click();
        $(By.xpath("//span[@class='postcolor']")).shouldHave(text("Неверный пароль. Все пароли чувствительны к регистру"));

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
