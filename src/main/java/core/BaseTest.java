package core;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.ImportInvoicePage;
import pages.LoginPage;
import pages.UserAdminPage;
import utils.DateUtils;
import utils.RandomInformationUtils;
import utils.RandomUser;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import static core.DriverFactory.getDriver;
import static core.DriverFactory.killDriver;

public class BaseTest {

    private LoginPage page = new LoginPage();
    private UserAdminPage admPage = new UserAdminPage();
    public Date date = DateUtils.dateWithDaysDifference(0);

    @Rule
    public TestName testName = new TestName();

    public void deleteCreateUser() throws InterruptedException {
        if(Properties.DELETE_USER && testName.getMethodName().endsWith("createDataUser")){
            WebDriverWait wait = new WebDriverWait(getDriver(), 10);
            page.acessDashPage();
            Thread.sleep(1500);
            //entrar na pagina de user
            admPage.openMenu();
            Thread.sleep(2000);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/nav/div/div[2]/a[7]/span")));
            admPage.openRegisterSelect();
            Thread.sleep(1000);
            admPage.openRegisterUser();
            Thread.sleep(2000);
            admPage.clickOptionsUserTabel();
            admPage.clickExcludedUser();
            Thread.sleep(800);
            Assert.assertEquals("Excluir usuário", admPage.msgPreUserExcluded());
            Thread.sleep(500);
            admPage.clickBtnExcluir();
            Thread.sleep(800);
            Assert.assertEquals("Usuário removido com sucesso!", admPage.msgUserExcluded());
        }
    }

    @Before
    public void initialize() throws InterruptedException {
        if(testName.getMethodName().startsWith("userNotLoggedIn")){
            page.acessLandingPage();
            Thread.sleep(1000);
        }
//        if(testName.getMethodName().startsWith("dataTest")){
//            WebDriverWait wait = new WebDriverWait(getDriver(), 10);
//            page.acessLandingPage();
//            page.clickAcess();
//            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email")));
//            page.setEmail("tulio@codebit.com.br");
//            page.setPassword("Codebit@123");
//            page.clickLogin();
//        }
        else{
            WebDriverWait wait = new WebDriverWait(getDriver(), 10);
            page.acessLandingPage();
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#home > section > header > div > div > div.col-lg-3.col-12.links > div.access > a")));
            page.clickAcess();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email")));
            page.setEmail("tulio@codebit.com.br");
            page.setPassword("Codebit@123");
            page.clickLogin();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.className("title-h1")));
            Thread.sleep(2000);
        }
    }

    @After
    public void finaliza() throws IOException, InterruptedException {
        TakesScreenshot ss = (TakesScreenshot) getDriver();
        File arquivo = ss.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(arquivo, new File("target" + File.separator + "screenshot" +
                File.separator + testName.getMethodName() + ".jpg"));

        if(Properties.DELETE_USER && testName.getMethodName().endsWith("_createDataUser")){
            deleteCreateUser();
        }

        if(Properties.CLOSE_BROWSER) {
            killDriver();
        }

    }

}
