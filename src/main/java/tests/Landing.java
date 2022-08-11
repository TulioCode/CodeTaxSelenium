package tests;

import core.BaseTest;
import core.DriverFactory;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LandingPage;
import utils.DateUtils;
import utils.RandomInformationUtils;

import java.util.Date;

import static utils.DateUtils.formattedDate;



/**
 * Classe de teste de área não logada
 *
 * @author Tulio Lascalla
 * @date 11/08/2021
 */

public class Landing extends BaseTest {

    LandingPage page = new LandingPage();


    /**
     * Teste básico para registrar um user via área não logada
     *
     * @author Tulio Lascalla
     * @date 11/08/2021
     */
    @Test
    public void userNotLoggedIn_Home() throws InterruptedException {

        page.clickRegister();
        Date date = DateUtils.dateWithDaysDifference(0);
        page.addNome("teste by Selenium" + formattedDate(date));
        page.addEmail("testeSelenium" + formattedDate(date) + "@codebit.com.br");
        String CPF = RandomInformationUtils.cpf();
        page.addCPF(CPF);
        String Telefone = RandomInformationUtils.Tel();
        page.addTelefone(Telefone);
        page.addPassword("Codebit@123");
        page.addPasswordConfirm("Codebit@123");
        page.clickBrokerageFirms();
        page.confirmTerms();
        page.reCaptchConfirm();
        page.confirmRegister();
    }

    /**
     * Teste básico para o redirecionamento da area não logada página "Quem Somos"
     *
     * @author Tulio Lascalla
     * @date 11/08/2021
     */
    @Test
    public void userNotLoggedIn_whoWeAre(){
        //clicar em ir para quem somos
        page.navigateaNotLogged("whoWeAre");
        //confere titulo da pagina
        Assert.assertEquals("Quem somos", page.titleWhoWeAre());
        //clica em cadastre-se
        page.clickRegisterWhoWeAre();
        //confere se redirecionou para página
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"signupForm\"]/div[1]/h1")));
        Assert.assertEquals("FAÇA SEU CADASTRO", page.RegisterLabel());
    }

    /**
     * Teste básico para o redirecionamento da area não logada página "Saiba Mais"
     *
     * @author Tulio Lascalla
     * @date 11/08/2021
     */
    @Test
    public void userNotLoggedIn_knowMore(){
        page.navigateaNotLogged("knowMore");
        Assert.assertEquals("Saiba Mais", page.titleKnowMore());
        page.clickRegisterKnowMore();
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"signupForm\"]/div[1]/h1")));
        Assert.assertEquals("FAÇA SEU CADASTRO", page.RegisterLabel());
    }

    /**
     * Teste básico para o redirecionamento da area não logada página "Preços"
     *
     * @author Tulio Lascalla
     * @date 11/08/2021
     */
    @Test
    public void userNotLoggedIn_Price(){
        page.navigateaNotLogged("price");
        page.clickRegisterPrice();
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"signupForm\"]/div[1]/h1")));
        Assert.assertEquals("FAÇA SEU CADASTRO", page.RegisterLabel());
    }


}
