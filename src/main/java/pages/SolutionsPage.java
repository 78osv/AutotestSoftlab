package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SolutionsPage extends BasePage {

    public SolutionsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h2/preceding::div[@class='box']//a")
    public List<WebElement> blockSolutionsForBanks;

    @FindBy(xpath = "//h2/following::div[@class='box']//a")
    public List<WebElement> blockSolutionsForInsuranceCompanies;

    @FindBy(xpath = "//strong[text()='Каталог продуктов']")
    public WebElement productCatalogTitle;

    @FindBy(xpath = "//div[@class='ico i-orange-list']")
    public WebElement productCatalogIco;

    @FindBy(xpath = "//a[@class='button orange slim load']")
    public WebElement buttonLook;

    @Step("Отображена страница Решения. Элементы присутствуют.")
    public SolutionsPage checkAllElementsOnSolutionsPage() {
        isElementsDisplayed(blockSolutionsForBanks);
        isElementsDisplayed(blockSolutionsForInsuranceCompanies);
        isElementDisplayed(productCatalogTitle);
        isElementDisplayed(productCatalogIco);
        isElementDisplayed(buttonLook);
        return this;
    }


    @Step("Навести мышкой на одну из плашек в блоке «Решения для банков» Плашка меняет цвет фона и текста.")
    public SolutionsPage hoverToArticle() {
        Actions actions = new Actions(driver);
        WebElement article = blockSolutionsForBanks.stream().findFirst().get();
        actions.moveToElement(article).build().perform();
        String background = article.getCssValue("background-color");
        String hexBackground = Color.fromString(background).asHex();
        hexBackground.equals("#4bbaad");
        String color = article.getCssValue("color");
        String hex = Color.fromString(color).asHex();
        hex.equals("#ffffff");
        return this;
    }


    @Step("Клик на кнопку «Посмотреть», переход к новой вкладке браузера с просмотром pdf, закрытие вкладки с pdf")
    public SolutionsPage clickProductCatalogButton() {
        String parentHandle = driver.getWindowHandle();
        buttonLook.click();

        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        driver.close();
        driver.switchTo().window(parentHandle);
        return this;
    }

    @Step("Проверка, что кнопка «Посмотреть» Активна.")
    public SolutionsPage checkButtonLookActive() {
        isElementEnabled(buttonLook);
        return this;
    }
}
