package tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@DisplayName("UI tests for https://www.godeltech.com/")
public class GodelTests extends BaseTest {

    @Test
    @Description("TestCase #1")
    @DisplayName("Main title is displayed on Home page")
    public void checkMainTitleIsDisplayed() {
        step("Open Home Page", () -> {
            homePage.openHomePage();
        });
        step("Check that Main title is displayed", () -> {
            homePage.checkMainTitleIsDisplayed();
        });
    }

    @Test
    @Description("TestCase #2")
    @DisplayName("Search field is displayed on Careers page")
    public void checkSearchIconIsDisplayed() {
        step("Open Home Page", () -> {
            homePage.openHomePage();
        });
        step("Navigate to Careers page", () -> {
            homePage.clickItemInNavigationMenu("Careers");
        });
        step("Check that Search field is displayed", () -> {
            careersPage.checkSearchFieldIsDisplayed();
        });
    }

    @Test
    @Description("TestCase #3")
    @DisplayName("Grodno is displayed on page when appropriate location is selected")
    public void checkUserCanSearchOnCareersPage() {
        step("Open Careers Page", () -> {
            careersPage.openCareersPage();
        });
        step("Select Grodno location", () -> {
            careersPage.selectRegion("grodno");
        });
        step("Check that Grodno is displayed on page", () -> {
            careersPage.checkRegionNameIsDisplayed("Grodno");
        });
    }

    @Test
    @Description("TestCase #4 - Will fail on last step because of incorrect locator")
    @DisplayName("User can fill form and submit job application")
    public void checkFillApplicationFormAndSubmitIt() {
        step("Open Careers Page", () -> {
            careersPage.openCareersPage();
        });
        step("Select Grodno location", () -> {
            careersPage.selectRegion("grodno");
        });
        step("Open position description", () -> {
            careersPage.openPositionDescription("QA Automation");
        });
        step("Open full details for position", () -> {
            careersPage.clickViewFullDetailsButton();
        });
        step("Click [Apply for this job]", () -> {
            careersPage.clickApplyForThisJobButton();
        });
        step("Fill job application form", () -> {
            careersPage.fillFirstName("FirstName")
                    .fillLastName("LastName")
                    .fillEmail("testemail@gmail.com")
                    .fillPhone("123123123")
                    .fillMessage("Hello! I would like to apply for QA Automation position");
        });
        step("Submit form", () -> {
            careersPage.submitJobApplicationForm();
        });
    }
}
