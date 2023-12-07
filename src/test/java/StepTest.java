import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class StepTest {
    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize="1920x1080";
        Configuration.holdBrowserOpen = true;
        SelenideLogger.addListener("allure",new AllureSelenide());
    }
    @Test
    public void LamdaTesting(){

        step("Открываем страницу вк", () ->{
                open("https://vk.com/");
});
        step("Переводим на английский язык", () -> {
            $(".footer_lang").$(byText("English")).click();
        });

        step("Открываем Все продукты ", () -> {
            $(".login_all_products_button").click();
        });

        step("Должна быть надпись о VK Mobile App ", () -> {
            $(".ProductsPageHeader__appDescription").shouldHave(text("You don't have to be at your computer to keep in touch with friends and family over VK." +
                    " Install our official mobile app on your phone and keep up to date with what's going on, no matter where you are."));
        });
       // $(".header-search-input").sendKeys("eroshenkoam/allure-example");
       // $(".header-search-input").submit();

       // $(linkText("eroshenkoam/allure-example")).click();
        //$("#issues-tab").click();
       // $(withText("#80")).should(Condition.exist);
    }
}
