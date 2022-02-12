package test;

import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class MainTest {

    private static final String singIn = "//a[@class=\"HeaderMenu-link flex-shrink-0 no-underline\"]";
    private static final String login = "#login_field";
    private static final String password = "#password";
    private static final String submit = ".js-sign-in-button";

    @BeforeAll
    static void before() {
        open("https://github.com/");
        $x(singIn).click();
        $(By.cssSelector(login)).setValue("cdpegova@bk.ru");
        $(By.cssSelector(password)).setValue("ItsTest!11");
        $(By.cssSelector(submit)).click();
    }
}
