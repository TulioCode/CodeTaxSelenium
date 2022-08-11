package pages;

import core.BasePage;
import core.DriverFactory;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.ArrayList;

import static core.DriverFactory.getDriver;

public class ImportInvoicePage extends BasePage {

    public void clickImportInvoiceMenu() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), 20);
        Thread.sleep(4500);
        WebElement btn = DriverFactory.getDriver().findElement(By.cssSelector(".justify-content-center"));
        runJS("window.scrollBy(0, arguments[0])", btn.getLocation().y);
        runJS("arguments[0].click();", btn);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.margin-bottom-65:nth-child(1)")));
        Thread.sleep(1000);
        scrollJS(0, 150);
        clickButton(By.cssSelector("a.margin-bottom-65:nth-child(1)"));
    }


    public void clickSelectInvoices(String type, String cases) throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("file-upload")));
        File pasta = new File("");
        
        if(type == "corretInvoice") {

            if(cases == "case1"){ pasta = new File(System.getProperty("user.dir") + "\\src\\main\\resources\\Invoices\\Case1");};
            if(cases == "case2"){pasta = new File(System.getProperty("user.dir") + "\\src\\main\\resources\\Invoices\\Case2");};
            if(cases == "case3"){pasta = new File(System.getProperty("user.dir") + "\\src\\main\\resources\\Invoices\\Case3");};
            if(cases == "case4"){ pasta = new File(System.getProperty("user.dir") + "\\src\\main\\resources\\Invoices\\Case4");};

            File[] list = pasta.listFiles();
            ArrayList nameArquivo = new ArrayList();

            for(File file : list){
                String nameFile = file.getName();
                nameArquivo.add(nameFile);
                wait.until(ExpectedConditions.presenceOfElementLocated(By.className("file-upload")));
                uploadFile(By.className("file-upload"), String.valueOf(file));
            }

            WebElement Lista = getDriver().findElement(By.id("fileChipList"));
            wait.until(ExpectedConditions.numberOfElementsToBe(By.className("mdl-chip__text"), nameArquivo.size()));
            boolean testSize = (Lista.findElements(By.tagName("div")).size() == nameArquivo.size());
            Assert.assertTrue(testSize);
        }

        if(type == "noPdf"){
            File path = new File(System.getProperty("user.dir") + "\\src\\main\\resources\\Invoices\\ArquivoTesteCodetax.xlsx");
            uploadFile(By.className("file-upload"), String.valueOf(path));
        }

        if(type == "noInvoice"){
            File path = new File(System.getProperty("user.dir") + "\\src\\main\\resources\\Invoices\\ArquivoTesteCodetaxPdf.pdf");
            uploadFile(By.className("file-upload"), String.valueOf(path));
        }

    }

    //verifica import
    public String invoiceImported(){
        return getText(By.xpath("/html/body/section[3]/div/div/div/span"));
    }

    //clica em importar nota
    public void invoiceImportButton() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        WebElement btn = DriverFactory.getDriver().findElement(By.className("container"));
        Thread.sleep(5000);
        runJS("window.scrollBy(0, arguments[0])", btn.getLocation().y);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("importInvoice")));
        clickButton(By.id("importInvoice"));
    }


    //confere a saida
    public String ImportStatusCorrectInvoice(){
        return getText(By.cssSelector("#invoicesTable > tr:nth-child(1) > td:nth-child(2)"));
    }

    public String ImportStatusIncorrectInvoice(){
        return getText(By.cssSelector("#invoicesTable > tr:nth-child(1) > td:nth-child(2)"));
    }

    public String ModalReturnMsg(){
        return getText(By.cssSelector("body > div.GKW4YO5BMI > div > div.mdl-dialog__content > div"));
    }

    public String takeErrorStatus(){
        return getText(By.cssSelector("#invoicesTable > tr:nth-child(1) > td:nth-child(3)"));
    }
}
