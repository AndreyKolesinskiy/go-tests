package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CareersPage {

    public CareersPage checkSearchFieldIsDisplayed(){
        $("[name='career-q']").shouldBe(Condition.visible);
        return this;
    }

    public CareersPage openCareersPage(){
        open("https://careers.godeltech.com/en/home/");
        return this;
    }

    public CareersPage selectRegion (String region){
        $(String.format("[href='https://careers.godeltech.com/en/location/%s/']", region)).click();
        return this;
    }

    public CareersPage checkRegionNameIsDisplayed (String region){
        $(".banner").shouldHave(Condition.text(region));
        return this;
    }

    public CareersPage openPositionDescription(String position){
        $(byText(position)).click();
        return this;
    }

    public CareersPage clickViewFullDetailsButton(){
        $(byText("View full details")).click();
        return this;
    }

    public CareersPage clickApplyForThisJobButton(){
        $(byText("Apply for this job")).click();
        return this;
    }

    public CareersPage fillFirstName(String firstName){
        $("[name='your-name']").val(firstName);
        return this;
    }

    public CareersPage fillLastName(String lastName){
        $("[name='your-lastname']").val(lastName);
        return this;
    }

    public CareersPage fillEmail(String email){
        $("[name='your-email']").val(email);
        return this;
    }

    public CareersPage fillPhone(String phoneNumber){
        $("[name='your-phone']").val(phoneNumber);
        return this;
    }

    public CareersPage fillMessage(String message){
        $("[name='your-message']").val(message);
        return this;
    }

    public void submitJobApplicationForm(){
        $(byText("Incorrect locator")).click();
    }
}
