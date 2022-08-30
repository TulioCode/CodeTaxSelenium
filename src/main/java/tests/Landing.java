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
    WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 20);

    /**
     * Teste b�sico para registrar
     *
     * @author Tulio Lascalla
     * @date 11/08/2021
     */
    @Test
    public void userNotLoggedIn_Home() {

        Assert.assertEquals("Para quem investe na bolsa valores", page.HomeSubLabel());
        page.clickRegister();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"signupForm\"]/div[1]/h1")));
        Assert.assertEquals("FA�A SEU CADASTRO", page.RegisterLabel());
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
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"signupForm\"]/div[1]/h1")));
        Assert.assertEquals("FA�A SEU CADASTRO", page.RegisterLabel());
    }


}
