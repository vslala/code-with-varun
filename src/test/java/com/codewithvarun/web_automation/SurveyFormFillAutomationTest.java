package com.codewithvarun.web_automation;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SurveyFormFillAutomationTest {

    public static final String CHROME_DRIVER_PATH = "src/main/resources/chromedriver";
    private static WebDriver driver;
    private SurveyFormFillAutomation survey;

    @BeforeAll
    public static void init() {
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        driver = new ChromeDriver();
    }

    @BeforeEach
    void itShouldCreateNewSurveyObjectEveryTime() {
        survey = new SurveyFormFillAutomation(driver);
    }

    @Test
    void itShouldFillTheSurveyForIndiaISTTime() {
        survey.fill();
        assertEquals("Scrum Meeting Norming - Survio", driver.getTitle());
    }

    @Test
    void itShouldFillForm10Times() {
        IntStream.range(0, 20).forEach(count -> {
                survey.fill();
        });
    }

    @AfterAll
    public static void destroy() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
        driver.quit();
    }

}