import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SimpleTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }
@Test
    public void SimpleTest() {
        open("https://vk.com/");
        $(".footer_lang").$(byText("English")).click();
        $(".login_all_products_button").click();
        $(".ProductsPageHeader__appDescription").shouldHave(text("You don't have to be at " +
                "your computer to " +
                "keep in touch with friends and family over VK." +
                " Install our official mobile app on your phone and" +
                " keep up to date with what's going on, " +
                "no matter where you are."));
    }
}