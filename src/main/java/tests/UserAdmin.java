package tests;

import core.BaseTest;
import org.junit.Assert;
import org.junit.Before;
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
    WebDriverWait wait = new WebDriverWait(getDriver(), 10);

    @Before
    public void before() throws InterruptedException {
        page.openMenu();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/nav/div/div[2]/a[7]/span")));
        page.openRegisterSelect();
        Thread.sleep(2000);
        page.openRegisterUser();
        Thread.sleep(2000);
        page.clickRegisterNewUser();
        Thread.sleep(2000);
    }

    @Test
    public void validationRequiredFields() throws InterruptedException {
        page.clickSaveNewUserBtn();
        Thread.sleep(1000);
        Assert.assertEquals("Insira um nome completo", page.nameMsg());
        Assert.assertEquals("Insira um e-mail válido", page.emailMsg());
        Assert.assertEquals("Insira um telefone válido", page.TelMsg());
        Assert.assertEquals("Insira um CPF/CNPJ válido", page.CPFCNPJMsg());
        Assert.assertEquals("Selecione um status válido", page.StatusMsg());
        Assert.assertEquals("Insira uma senha válida", page.PasswordMsg());
        Assert.assertEquals("Insira uma senha válida", page.ConfirmPasswordMsg());
        //completa 1 nome
        Thread.sleep(300);
        page.inputNameNewUser("Name");
        Assert.assertEquals("Insira um nome completo", page.nameMsg());

    }

    @Test
    public void validationSamePasswordRegister() {
        page.insertImg();
        page.inputNameNewUser("User Teste By Selenium ADM" + DateUtils.formattedDate(date));
        page.inputEmailNewUser(RandomUser.RandomTestEmail());
        page.inputPhoneNewUser(RandomInformationUtils.Tel());
        page.clickStatus("normal");
        page.inputPassword("Codebit@111");
        page.inputConfirmPassword("Codebit@222");
        page.clickSaveNewUserBtn();
        Assert.assertEquals("*Senhas não conferem", page.ConfirmPasswordMsg());
    }

    @Test
    public void createUserAdmin_createDataUser() throws InterruptedException {
        page.insertImg();
        page.inputNameNewUser("User Teste By Selenium ADM" + DateUtils.formattedDate(date));
        page.inputEmailNewUser(RandomUser.RandomTestEmail());
        page.inputPhoneNewUser(RandomInformationUtils.Tel());
        page.inputCpfCnpjNewUser(RandomInformationUtils.cpf());
        page.clickStatus("admin");
        page.inputPassword("Codebit@123");
        page.inputConfirmPassword("Codebit@123");
        page.clickSaveNewUserBtn();
        //Colocar validação de menssagem da Modal
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[1]/div[2]")));
        Assert.assertEquals("", page.msgModalSuccess(), "Usuário salvo com sucesso!");
        page.clickOkModal();
    }

    @Test
    public void createUserNormal_createDataUser() throws InterruptedException {
        page.inputNameNewUser("User Teste By Selenium ADM" + DateUtils.formattedDate(date));
        page.inputEmailNewUser(RandomUser.RandomTestEmail());
        page.inputPhoneNewUser(RandomInformationUtils.Tel());
        page.inputCpfCnpjNewUser(RandomInformationUtils.cpf());
        page.clickStatus("normal");
        page.inputPassword("Codebit@123");
        page.inputConfirmPassword("Codebit@123");
        page.clickSaveNewUserBtn();
        //Colocar validação de menssagem da Modal
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[1]/div[2]")));
        Assert.assertEquals("", page.msgModalSuccess(), "Usuário salvo com sucesso!");
        page.clickOkModal();
    }

}
