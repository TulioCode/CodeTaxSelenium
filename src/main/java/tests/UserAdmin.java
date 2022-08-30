package tests;

import core.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import pages.UserAdminPage;
import utils.DateUtils;
import utils.RandomInformationUtils;
import utils.RandomUser;

import java.util.Date;

import static core.DriverFactory.getDriver;

public class UserAdmin extends BaseTest {

    private UserAdminPage page = new UserAdminPage();
    private LoginPage loginPage = new LoginPage();
    public Date date = DateUtils.dateWithDaysDifference(0);

    @Test
    public void createUserAdmin() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(getDriver(), 10);

        page.openMenu();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/nav/div/div[2]/a[7]/span")));
        page.openRegisterSelect();
        Thread.sleep(1000);
        page.openRegisterUser();
        Thread.sleep(2000);
        page.clickRegisterNewUser();
        Thread.sleep(2000);
        page.inputNameNewUser("User Teste By Selenium ADM" + DateUtils.formattedDate(date));
        page.inputEmailNewUser(RandomUser.RandomTestEmail());
        page.inputPhoneNewUser(RandomInformationUtils.Tel());
        page.inputCpfCnpjNewUser(RandomInformationUtils.cpf());
        page.clickStatus("admin");
        page.inputPasswordNewUser("Codebit@123");
        page.clickSaveNewUserBtn();
        //Colocar validação de menssagem da Modal
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[1]/div[2]")));
        Assert.assertEquals("", page.msgModalSuccess(), "Usuário salvo com sucesso!");
        page.clickOkModal();
    }

    @Test
    public void createUserNormal() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(getDriver(), 10);

        page.openMenu();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/nav/div/div[2]/a[7]/span")));
        page.openRegisterSelect();
        Thread.sleep(1000);
        page.openRegisterUser();
        Thread.sleep(2000);
        page.clickRegisterNewUser();
        Thread.sleep(2000);
        page.inputNameNewUser("User Teste By Selenium ADM" + DateUtils.formattedDate(date));
        page.inputEmailNewUser(RandomUser.RandomTestEmail());
        page.inputPhoneNewUser(RandomInformationUtils.Tel());
        page.inputCpfCnpjNewUser(RandomInformationUtils.cpf());
        page.clickStatus("normal");
        page.inputPasswordNewUser("Codebit@123");
        page.clickSaveNewUserBtn();
        //Colocar validação de menssagem da Modal
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[1]/div[2]")));
        Assert.assertEquals("", page.msgModalSuccess(), "Usuário salvo com sucesso!");
        page.clickOkModal();
    }

}
