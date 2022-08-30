package pages;

import core.BasePage;
import core.DriverFactory;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    public void acessLandingPage(){
        DriverFactory.getDriver().get("https://hhh.codetax.com.br/");
    }

    public void clickAcess(){
        clickButton(By.cssSelector("#home > section > header > div > div > div.col-lg-3.col-12.links > div.access > a"));
    }

    public void setEmail(String email){
        write(By.id("email"), email);
    }

    public void setPassword(String password){
        write(By.id("password"), password);
    }

    public void clickLogin(){
        clickButton(By.className("submit-button"));
    }

}
