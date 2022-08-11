package pages;

import core.BasePage;
import core.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static core.DriverFactory.getDriver;

public class LandingPage extends BasePage {

    WebDriverWait wait = new WebDriverWait(getDriver(), 20);

    //navigate
    public void navigateaNotLogged(String were){
        if(were == "whoWeAre"){
            clickButton(By.xpath("/html/body/div[1]/section/header/div/div/div[2]/a[1]"));
        }
        if(were == "knowMore"){
            clickButton(By.xpath("/html/body/div[1]/section/header/div/div/div[2]/a[2]"));
        }
        if(were == "price"){
            clickButton(By.xpath("/html/body/div[1]/section/header/div/div/div[2]/a[3]"));
        }
    }

    //WHOWEARE
    public String titleWhoWeAre(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/main/section[1]/div/div[1]/div/h1")));
        return getText(By.xpath("/html/body/main/section[1]/div/div[1]/div/h1"));
    }

    public void clickRegisterWhoWeAre(){
        WebElement btnRegister = DriverFactory.getDriver().findElement(By.xpath("/html/body/main/section[3]/div/div[3]/div/a"));
        runJS("window.scrollBy(0, arguments[0])", btnRegister.getLocation().y);
        runJS("arguments[0].click();", btnRegister);
    }

    //KnowMore
    public String titleKnowMore(){
        return getText(By.xpath("/html/body/main/section[1]/div/div[1]/div/h1"));
    }

    public void clickRegisterKnowMore(){
        WebElement btnRegister = DriverFactory.getDriver().findElement(By.xpath("/html/body/main/section[3]/div/div[5]/div/a"));
        runJS("window.scrollBy(0, arguments[0])", btnRegister.getLocation().y);
        runJS("arguments[0].click();", btnRegister);
    }

    //Price
    public String titlePrice(){
        return getText(By.xpath("/html/body/main/div[1]/div/div/div/h1"));
    }

    public void clickRegisterPrice(){
        WebElement btnRegister = DriverFactory.getDriver().findElement(By.xpath("/html/body/main/div[2]/div[2]/div/div/div[1]/div/a"));
        runJS("window.scrollBy(0, arguments[0])", btnRegister.getLocation().y);
        runJS("arguments[0].click();", btnRegister);
    }


    //notUserLogin-Cadastro
    public void clickRegister() {
        clickButton(By.xpath("//*[@id=\"home\"]/section/div/div/div[1]/div[2]/a"));
    }
    public void addNome(String name){
        write(By.id("name"), name);
    }
    public void addEmail(String email){
        write(By.id("email"), email);
    }
    //TODO: Pensar em meio para inserir variedade de cpfs
    public void addCPF(String cpf){
        write(By.id("cpfCnpj"), cpf);
    }

    public void addTelefone(String telefone){
        write(By.id("phone"), telefone + "000");
    }

    public void addPassword(String password){
        write(By.id("password"), password);
    }
    public void addPasswordConfirm(String passwordConfirm){
        write(By.id("passwordConfirmation"), passwordConfirm);
    }
    public void clickBrokerageFirms(){
        clickRadioOrCheck(By.id("XP"));
        clickRadioOrCheck(By.id("BTG_PACTUAL"));
    }
    public void confirmTerms(){
        clickRadioOrCheck(By.id("usageTerms"));
    }

    public void reCaptchConfirm(){
        WebElement frame = DriverFactory.getDriver().findElement(By.xpath("/html/body/div[1]/main/div/form/div[5]/div/div/div/div/iframe"));
        enterFrame(frame);
        clickRadioOrCheck(By.id("recaptcha-anchor"));
        exitFrame();
    }
    public void confirmRegister(){
        clickButton(By.xpath("//*[@id=\"signupForm\"]/div[6]/div/button"));
    }

    public String RegisterLabel(){
        return getText(By.xpath("//*[@id=\"signupForm\"]/div[1]/h1"));
    }


}
