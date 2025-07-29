package Automation_Test.MiniProject_Test;
import java.time.Duration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ComarTest {
    @Test
    public void testComarSearch() throws InterruptedException {
        // Setup ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        try {
            driver.manage().window().maximize();
            driver.get("https://www.comar.tn/");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement actualitesLink = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("/html/body/div[1]/div[1]/div/div/div[2]/div/nav/ul/li[6]/a")));
            actualitesLink.click();
            WebElement actualitesTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("/html/body/div[1]/div[4]/div/section/div/div[1]/h1")));
            System.out.println("Actualités title found: " + actualitesTitle.getText());
            WebElement rechercheBox = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("/html/body/div[1]/div[4]/div/section/div/div[3]/div/div[1]/form/div/div[1]/input")));
            WebElement rechercheButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("/html/body/div[1]/div[4]/div/section/div/div[3]/div/div[1]/form/div/div[3]/button")));
            rechercheBox.sendKeys("COMAR Assurances partenaire");
            rechercheButton.click();
            WebElement searchResult = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("/html/body/div[1]/div[4]/div/section/div/div[3]/div/div[2]/div/div/div/div[2]/h4/a")));
            System.out.println("Search result found: " + searchResult.getText());
            Thread.sleep(2000); // Optional delay
        } finally {
            driver.quit();
        }
    }
}