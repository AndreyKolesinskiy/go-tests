package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byTitle;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HomePage {

    public HomePage openHomePage(){
        open("/");
        $(".logo-img.lazyloaded").shouldBe(Condition.visible);
        return this;
    }

    public HomePage checkMainTitleIsDisplayed(){
        $(byText("We build high performing teams to deliver mission-critical solutions")).shouldBe(Condition.visible);
        return this;
    }

    public void clickItemInNavigationMenu(String itemName){
        $(".nav-content").$(byText(itemName)).click();
    }
}

