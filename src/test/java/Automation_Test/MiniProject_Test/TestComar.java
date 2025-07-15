package Automation_Test.MiniProject_Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager; // Added for automatic ChromeDriver management

public class TestComar {

    public static void main(String[] args) throws InterruptedException {
        // Use WebDriverManager to automatically set up ChromeDriver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            // Maximize the window
            driver.manage().window().maximize();

            // Open the URL
            driver.get("https://www.comar.tn/");

            // Initialize WebDriverWait
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Wait for the "Actualités" link to be clickable and click it
            WebElement actualitesLink = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[1]/div[1]/div/div/div[2]/div/nav/ul/li[6]/a")));
            actualitesLink.click();

            // Wait for the "Actualités" title to be visible and store it (now used)
            WebElement actualitesTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("/html/body/div[1]/div[4]/div/section/div/div[1]/h1")));
            System.out.println("Actualités title found: " + actualitesTitle.getText()); // Use the element

            // Identify the search box and button
            WebElement rechercheBox = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("/html/body/div[1]/div[4]/div/section/div/div[3]/div/div[1]/form/div/div[1]/input")));
            WebElement rechercheButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[1]/div[4]/div/section/div/div[3]/div/div[1]/form/div/div[3]/button")));

            // Perform the search
            rechercheBox.sendKeys("COMAR Assurances partenaire");
            rechercheButton.click();

            // Wait for the search result to be visible
            WebElement searchResult = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("/html/body/div[1]/div[4]/div/section/div/div[3]/div/div[2]/div/div/div/div[2]/h4/a")));
            System.out.println("Search result found: " + searchResult.getText());

            Thread.sleep(2000); // Optional delay for visibility
        } finally {
            // Close the browser properly
            driver.quit();
        }
    }
}