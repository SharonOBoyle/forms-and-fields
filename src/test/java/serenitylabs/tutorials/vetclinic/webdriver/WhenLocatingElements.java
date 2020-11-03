package serenitylabs.tutorials.vetclinic.webdriver;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class WhenLocatingElements {
    WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "/Users/sharonoboyle/libs/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        URL testSiteUrl = getClass().getResource("/site/elements.html");
//        URL testSiteUrl = getClass().getResource("file:///Users/sharonoboyle/forms-and-fields/src/main/resources/site/elements.html");
//        driver.get(testSiteUrl.toString());
        driver.get("file:///Users/sharonoboyle/forms-and-fields/src/main/resources/site/elements.html");
    }

    @Test
    public void find_an_element_by_id() {
        // TODO: Find the first name field by id
        WebElement firstName = driver.findElement(By.id("first-name"));
//        firstName.sendKeys("Sharon");
//        assertThat(firstName.getText(), equalTo("Sharon"));
        assertThat(firstName.getAttribute("placeholder"), equalTo("Enter the first name here"));
    }


    @Test
    public void find_an_element_by_name() {
        // TODO: Find the last name field by name
        WebElement lastName = driver.findElement(By.name("last-name"));
        assertThat(lastName.getAttribute("placeholder"), equalTo("Enter the last name here"));
    }


    @Test
    public void finding_an_element_by_tag() {
        // TODO: Find the blockquote field by its HTML tag
        WebElement quote = driver.findElement(By.tagName("blockquote"));
        assertThat(quote.getText(), containsString("locating and manipulating elements on a page"));
    }

    @Test
    public void finding_an_element_by_slink_text() {
        // TODO: Find the 'Next Section' link by link text
        WebElement nextSection = driver.findElement(By.linkText("Next Section"));
        assertThat(nextSection.getText(),equalTo("Next Section"));
    }

    @Test
    public void finding_the_new_todo_field_by_css() {
        // TODO: Find the Country of Origin dropdown using a CSS selector
        Select countryOfOrigin = new Select(driver.findElement(By.cssSelector("div.country-of-origin select")));
        assertThat(countryOfOrigin.getFirstSelectedOption().getText(), equalTo("United Kingdom"));
    }

    @Test
    public void entering_values_into_text_fields() {
        // TODO: Enter Sarah-Jane Smith into the first and last names
        WebElement firstName = driver.findElement(By.id("first-name"));
        WebElement lastName = driver.findElement(By.name("last-name"));
        firstName.sendKeys("Sarah-Jane");
        lastName.sendKeys("Smith");
    }

    @Test
    public void setting_a_checkbox() {
        // TODO: Check the VIP checkbox
        WebElement vip = driver.findElement(By.id("vip"));
        vip.click();
        assertThat(vip.isSelected(), is(true));
    }

    @Test
    public void setting_a_radio_button() {
        // TODO: Select the 'Courrier Pigeon' option in the notifications radio buttons
        WebElement notification = driver.findElement(By.xpath("//input[contains(@value, 'Courrier Pigeon')]"));
        notification.click();
        assertThat(notification.isSelected(), is(true));
    }


    @After
    public void shutdown() {
        driver.quit();
    }
}
