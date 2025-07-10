package Automation_Test.MiniProject_Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestComar {

    public static void main(String[] args) throws InterruptedException {
        // Définir le chemin vers chromedriver (vérifie que ce chemin est correct)
        System.setProperty("webdriver.chrome.driver", "src/test/ressources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        try {
            // Maximiser la fenêtre
            driver.manage().window().maximize();

            // Ouvrir l'URL
            driver.get("https://www.comar.tn/");

            // Remplacer Thread.sleep(1000) par une attente explicite
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Attendre que le lien "ACTUALITÉS" soit cliquable puis cliquer dessus
            WebElement actualitesLink = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[1]/div[1]/div/div/div[2]/div/nav/ul/li[6]/a")));
            actualitesLink.click();

            // Attendre que le titre "ACTUALITÉS" soit visible
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("/html/body/div[1]/div[4]/div/section/div/div[1]/h1")));

            // Identifier la zone de recherche et le bouton
            WebElement recherchebox = driver.findElement(By.xpath(
                "/html/body/div[1]/div[4]/div/section/div/div[3]/div/div[1]/form/div/div[1]/input"));
            WebElement recherchebutton = driver.findElement(By.xpath(
                "/html/body/div[1]/div[4]/div/section/div/div[3]/div/div[1]/form/div/div[3]/button"));

            // Effectuer la recherche
            recherchebox.sendKeys("COMAR Assurances partenaire");
            recherchebutton.click();

            // Attendre que le texte "ACTUALITÉS" apparaisse dans les résultats
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("/html/body/div[1]/div[4]/div/section/div/div[3]/div/div[2]/div/div/div/div[2]/h4/a")));

            System.out.println("\"COMAR Assurances partenaire du Semi-Marathon Ulysse Djerba\" est affichée");

            Thread.sleep(2000);
        } finally {
            // Fermer le navigateur proprement
            driver.quit();
        }
    }
}
