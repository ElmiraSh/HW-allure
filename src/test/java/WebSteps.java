import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {
    @Step("Open VK")
    public void openPage(){
        open("https://vk.com/");
    }
    @Step("Translate english")
    public void translateEnglish(){
        $(".footer_lang").$(byText("English")).click();
    }
    @Step("Open All Products ")
    public void openAllProducts(){
        $(".login_all_products_button").click();
    }
    @Step("Should be text about VK Mobile App ")
    public void finText(){
        $(".ProductsPageHeader__appDescription").shouldHave(text("You don't have to be at " +
                "your computer to " +
                "keep in touch with friends and family over VK." +
                " Install our official mobile app on your phone and" +
                " keep up to date with what's going on, " +
                "no matter where you are."));
    }
}
