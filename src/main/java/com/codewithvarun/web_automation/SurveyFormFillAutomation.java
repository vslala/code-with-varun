package com.codewithvarun.web_automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SurveyFormFillAutomation {

    public static final String SURVEY_URL = "https://www.survio.com/survey/d/D1Q8Q4O9J5I7O0Q3C";
    private final WebDriver browser;
    private final WebDriverWait wait;

    public SurveyFormFillAutomation(WebDriver browser) {
        this.browser = browser;
        this.wait = new WebDriverWait(browser, 60);
    }

    private void start() {
        this.browser.get(SURVEY_URL);
        this.browser.findElement(By.xpath("//*[text()='Start Survey Now']")).click();
    }

    public void fill() {
        start();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.tagName("li")));
        final List<WebElement> li = browser.findElements(By.tagName("li"));
        Stream.of(
                "All meetings in IST morning i.e. PST night time",
                "7:00 AM IST - 9:00 AM IST (i.e. 6:30 PM PST - 8:30 PM PST)",
                "Once every sprint")
                .map(linkText -> li
                        .stream()
                        .peek(el -> System.out.println(el.getText()))
                        .filter(el -> el.getText().equals(linkText))
                        .findAny()
                        .orElseThrow(RuntimeException::new))
                .collect(Collectors.toList())
                .forEach(WebElement::click);

        submit();
    }

    private void submit() {
        this.browser.findElement(By.xpath("//*[text()='Submit']")).click();
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("free2-headline")),
                ExpectedConditions.visibilityOfAllElementsLocatedBy(By.tagName("h1"))));
    }


}
