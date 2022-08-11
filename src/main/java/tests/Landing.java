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
 * Classe de teste de �rea n�o logada
 *
 * @author Tulio Lascalla
 * @date 11/08/2021
 */

public class Landing extends BaseTest {

    LandingPage page = new LandingPage();


    /**
     * Teste b�sico para registrar um user via �rea n�o logada
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
     * Teste b�sico para o redirecionamento da area n�o logada p�gina "Quem Somos"
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
        //confere se redirecionou para p�gina
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"signupForm\"]/div[1]/h1")));
        Assert.assertEquals("FA�A SEU CADASTRO", page.RegisterLabel());
    }

    /**
     * Teste b�sico para o redirecionamento da area n�o logada p�gina "Saiba Mais"
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
        Assert.assertEquals("FA�A SEU CADASTRO", page.RegisterLabel());
    }

    /**
     * Teste b�sico para o redirecionamento da area n�o logada p�gina "Pre�os"
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
        Assert.assertEquals("FA�A SEU CADASTRO", page.RegisterLabel());
    }


}
