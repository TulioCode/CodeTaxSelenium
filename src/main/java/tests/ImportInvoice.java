package tests;

import core.BaseTest;
import core.DriverFactory;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.ImportInvoicePage;


/**
 * Teste de importação de notas
 * Atualmente o sistema importa notas da XP, CLEAR, INTER, RICO
 *
 * @author Tulio Lascalla
 * @date 11/08/2021
 */
public class ImportInvoice extends BaseTest {

    ImportInvoicePage page = new ImportInvoicePage();

    /**
     * Teste de importação de notas
     * Caso 1: Tipo nota XP
     *
     * @author Tulio Lascalla
     * @date 11/08/2021
     */
    @Test
    public void importInvoiceCase1() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 300);
        Thread.sleep(2000);
        page.clickImportInvoiceMenu();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("file-upload")));
        page.clickSelectInvoices("corretInvoice", "case1");
        page.invoiceImportButton();
        wait.until(ExpectedConditions.visibilityOf(DriverFactory.getDriver().findElement(By.id("containerImportedInvoices"))));
        Assert.assertEquals("Arquivo importado", page.ImportStatusCorrectInvoice());
    }

    /**
     * Teste de importação de notas
     * Caso 2: Tipo nota XP e CLEAR
     *
     * @author Tulio Lascalla
     * @date 11/08/2021
     */
    @Test
    public void importInvoiceCase2() throws InterruptedException {
        Thread.sleep(2000);
        page.clickImportInvoiceMenu();
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 300);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("file-upload")));
        page.clickSelectInvoices("corretInvoice", "case2");
        page.invoiceImportButton();
        wait.until(ExpectedConditions.visibilityOf(DriverFactory.getDriver().findElement(By.id("containerImportedInvoices"))));
        Assert.assertEquals("Arquivo importado", page.ImportStatusCorrectInvoice());
    }

    /**
     * Teste de importação de notas
     * Caso 1: Tipo nota XP
     *
     * @author Tulio Lascalla
     * @date 11/08/2021
     */
    @Test
    public void importInvoiceCase3() throws InterruptedException {
        Thread.sleep(2000);
        page.clickImportInvoiceMenu();
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 300);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("file-upload")));
        page.clickSelectInvoices("corretInvoice", "case3");
        page.invoiceImportButton();
        wait.until(ExpectedConditions.visibilityOf(DriverFactory.getDriver().findElement(By.id("containerImportedInvoices"))));
        Assert.assertEquals("Arquivo importado", page.ImportStatusCorrectInvoice());
    }

    /**
     * Teste de importação de notas
     * Caso 1: Tipo nota XP e CLEAR
     *
     * @author Tulio Lascalla
     * @date 11/08/2021
     */
    @Test
    public void importInvoiceCase4() throws InterruptedException {
        Thread.sleep(2000);
        page.clickImportInvoiceMenu();
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 300);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("file-upload")));
        page.clickSelectInvoices("corretInvoice", "case4");
        page.invoiceImportButton();
        wait.until(ExpectedConditions.visibilityOf(DriverFactory.getDriver().findElement(By.id("containerImportedInvoices"))));
        Assert.assertEquals("Arquivo importado", page.ImportStatusCorrectInvoice());
    }

    /**
     * Teste de importação de notas com extenção de arquivo não permitido
     *
     * @author Tulio Lascalla
     * @date 11/08/2021
     */
    @Test
    public void importInvoiceFileExtensionNoPdf() throws InterruptedException {
        page.clickImportInvoiceMenu();
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("file-upload")));
        page.clickSelectInvoices("noPdf", "");
        Thread.sleep(1000);
        Assert.assertEquals("Extensão de arquivo não permitida", page.ModalReturnMsg());
    }

    /**
     * Teste de importação de notas com extensão de arquivo pdf porem sem ser uma nota de corretagem
     *
     * @author Tulio Lascalla
     * @date 11/08/2021
     */
    @Test
    public void importPDFNoInvoice() throws InterruptedException {
        page.clickImportInvoiceMenu();
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("file-upload")));
        //upload
        page.clickSelectInvoices("noInvoice","");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/section[3]/div/div/div/span")));
        Thread.sleep(2000);
        //submit
        page.invoiceImportButton();
        wait.until(ExpectedConditions.visibilityOf(DriverFactory.getDriver().findElement(By.id("containerImportedInvoices"))));
        Assert.assertEquals("Erro parcial", page.ImportStatusIncorrectInvoice());
//
    }

}
