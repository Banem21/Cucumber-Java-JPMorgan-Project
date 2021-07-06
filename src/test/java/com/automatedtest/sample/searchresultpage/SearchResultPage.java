package com.automatedtest.sample.searchresultpage;

import com.automatedtest.sample.basepage.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.IntStream;

public class SearchResultPage extends BasePage {


    @FindBy(xpath = "//h3[contains(text(),'J.P. Morgan')]")
    private List<WebElement> results;

    @FindBy(xpath = "//img[@class='first-logo']")
    private List<WebElement> jpMorganLogo;

    public SearchResultPage() {
        PageFactory.initElements(driver, this);
    }

    public String validateLinkOnLandingPage()
    {
        wait.forLoading(5);
        String link = results.get(0).getText();
        return link;
    }

    /**
     * This method clicks on the first JPMorgan Link
     */
    public void clickOnLink(int index)
    {
        results.get(index).click();
    }

    public String getJPMorganURL()
    {
        return driver.getCurrentUrl();
    }

    public boolean isLogoDisplayed()
    {
        wait.forLoading(5);
        return jpMorganLogo.get(1).isDisplayed();
    }
}

