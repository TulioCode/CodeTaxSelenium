package utils;

import core.BasePage;
import core.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static core.DriverFactory.getDriver;


public class RandomInformationUtils extends BasePage {

    public static String Tel() {
        Random rand = new Random();
        int num = rand.nextInt();
        String numTel = String.valueOf(num);
        return numTel;
    }

    public static String cpf() throws InterruptedException {

        WebDriver driver = DriverFactory.getDriver();

        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.open('');");

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        List<String> wH = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(wH.get(1));

        driver.get("https://www.4devs.com.br/gerador_de_cpf");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("bt_gerar_cpf")));
        driver.findElement(By.id("bt_gerar_cpf")).click();
        Thread.sleep(1000);
        String cpf = driver.findElement(By.id("texto_cpf")).getText();
        driver.switchTo().window(wH.get(0));
        return cpf;
    }

}
