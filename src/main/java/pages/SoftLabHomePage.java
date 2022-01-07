package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SoftLabHomePage extends BasePage {

    public SoftLabHomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//img[@class='logo']")
    public WebElement logo;

    @FindBy(xpath = "//ul[@class='mainNav']/li/a")
    public List<WebElement> mainNavItems;

    @FindBy(name = "q")
    public WebElement searchForm;

    @FindBy(xpath = "//span[text()='Поддержка']")
    public WebElement buttonSupport;

    @FindBy(xpath = "//ul[@class='newsList']/li[contains(@id,'bx_')]")
    public List<WebElement> newsList;

    @FindBy(xpath = "//div[@class='inFocus']/ul/li")
    public List<WebElement> storiesList;

    @FindBy(xpath = "//div[@class='bjqs-wrapper']")
    public WebElement carousel;

    @Step("Отображена главная страница. Элементы присутствуют.")
    public SoftLabHomePage checkAllElementsOnSoftLabHomePage() {
        isElementDisplayed(logo);
        isElementsDisplayed(mainNavItems);
        isElementDisplayed(searchForm);
        isElementDisplayed(buttonSupport);
        isElementsDisplayed(newsList);
        isElementsDisplayed(storiesList);
        isElementDisplayed(carousel);
        return this;
    }

    @Step("Клик на логотип компании.")
    public SoftLabHomePage clickLogoHomePage() {
        logo.click();
        return this;
    }

    @Step("Выбрать вкладку меню.")
    public void openMainNavItem(String itemName) {
        mainNavItems.stream().filter(element -> element.getText().equals(itemName)).findFirst().get().click();
    }

}
