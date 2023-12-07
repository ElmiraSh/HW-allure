
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;


public class StepTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
         Configuration.holdBrowserOpen = true;
    }

    @Test
    @Feature("Find in VK ")
    @Story("Find in VK with LamdaStep")
    public void LambdaTesting() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Open VK", () -> {
            open("https://vk.com/");
        });
        step("Translate english", () -> {
            $(".footer_lang").$(byText("English")).click();
        });
        step("Open All Products ", () -> {
            $(".login_all_products_button").click();
        });
        step("Should be text about VK Mobile App ", () -> {
            $(".ProductsPageHeader__appDescription").shouldHave(text("You don't have to be at " +
                    "your computer to " +
                    "keep in touch with friends and family over VK." +
                    " Install our official mobile app on your phone and" +
                    " keep up to date with what's going on, " +
                    "no matter where you are."));
        });
    }
    @Test
    @Feature("Find in VK ")
    @Story("Find in VK with Annotation")
    public void testAnnotatedStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();
        steps.openPage();
        steps.translateEnglish();
        steps.openAllProducts();
        steps.finText();
    }

}

