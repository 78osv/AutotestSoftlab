package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ConfProperties;
import pages.SoftLabHomePage;
import pages.SolutionsPage;

public class AutoTest extends BaseTest {

    @Story("Тестирование сайта R-Style Softlab")
    @Description("1.\tНаписать тест с использованием стека: java, Selenium.\n" +
            "Реализовать, используя паттерн Page Object. \n" +
            "2.\t Организовать отчет с использованием allure фреймворка. \n" +
            "3.\tЗапуск теста выполнить через maven.\n" +
            "4.\tНаписать документацию к запуску.\n")
    @Test(description = "Тестовое задание для Инженера-тестировщика (автоматизированное тестирование)")
    public void testTaskForAutotest() {
        driver.get(ConfProperties.getProperty("SOFTLAB_HOME_PAGE"));
        driver.navigate().refresh();
        PageFactory.initElements(driver, SoftLabHomePage.class)
                .checkAllElementsOnSoftLabHomePage()
                .openMainNavItem("Решения");
        PageFactory.initElements(driver, SolutionsPage.class)
                .checkAllElementsOnSolutionsPage()
                .hoverToArticle()
                .clickProductCatalogButton()
                .checkButtonLookActive();
        PageFactory.initElements(driver, SoftLabHomePage.class)
                .clickLogoHomePage()
                .checkAllElementsOnSoftLabHomePage();
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, ConfProperties.getProperty("SOFTLAB_HOME_PAGE"));
    }
}
