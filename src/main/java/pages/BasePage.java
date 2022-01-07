package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Проверка присутствия элемента на странице.")
    public void isElementDisplayed(WebElement element) {
        Assert.assertTrue(element.isDisplayed());
    }

    @Step("Проверка присутствия элементов на странице.")
    public void isElementsDisplayed(List<WebElement> elements) {
        boolean isAllDisplayed = true;
        for (WebElement element : elements) {
            if (element.isDisplayed() == false) {
                isAllDisplayed = false;
                break;
            }
        }
    }

    @Step("Проверка, что элемент активен.")
    public void isElementEnabled(WebElement element) {
        Assert.assertTrue(element.isEnabled());
    }
}
