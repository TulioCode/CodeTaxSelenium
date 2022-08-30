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
    WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 20);

    /**
     * Teste básico para registrar
     *
     * @author Tulio Lascalla
     * @date 11/08/2021
     */
    @Test
    public void userNotLoggedIn_Home() {

        Assert.assertEquals("Para quem investe na bolsa valores", page.HomeSubLabel());
        page.clickRegister();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"signupForm\"]/div[1]/h1")));
        Assert.assertEquals("FAÇA SEU CADASTRO", page.RegisterLabel());
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
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"signupForm\"]/div[1]/h1")));
        Assert.assertEquals("FAÇA SEU CADASTRO", page.RegisterLabel());
    }


}
