package pages;

import core.BasePage;
import org.openqa.selenium.By;

public class UserAdminPage extends BasePage {
    //Realiza��o de um cadastro
    public void openMenu(){
        clickButton(By.id("registration"));
    }
    public void openRegisterSelect(){
        clickButton(By.xpath("/html/body/nav/div/div[2]/a[7]/span"));
    }
    public void openRegisterUser(){
        clickButton(By.xpath("//*[@id=\"containerRegistration\"]/a[4]/span"));
    }

    public void clickRegisterNewUser(){
        clickButton(By.xpath("/html/body/section[2]/div/div/div/div/div[2]/a"));
    }

    public void inputNameNewUser(String name){
        write(By.id("name"), name);
    }

    public void inputEmailNewUser(String email){
        write(By.id("email"), email);
    }

    public void inputPhoneNewUser(String phone){
        write(By.id("phone"), phone);
    }

    public void inputCpfCnpjNewUser(String cpfCnpj){
        write(By.id("cpfCnpj"), cpfCnpj);
    }

    public void clickStatus(String status){
        if(status.equals("admin") ){
            clickButton(By.cssSelector("div.checkBox-patern:nth-child(2) > span:nth-child(2)"));
        }
        if(status.equals("normal")){
            clickButton(By.cssSelector("body > main > div:nth-child(3) > div > div > form > div:nth-child(4) > div > div:nth-child(3) > div > span"));
        }
    }

    public void inputPassword(String password){
        write(By.id("password"), password);
    }

    public void inputConfirmPassword(String password){
        write(By.id("repeatPassword"), password);
    }

    public void clickSaveNewUserBtn(){
        clickButton(By.id("save"));
    }

    public String msgModalSuccess(){
        return getText(By.xpath("/html/body/div[3]/div[1]/div[2]"));
    }

    public void clickOkModal(){
        clickButton(By.xpath("/html/body/div[3]/div[1]/div[3]/div[2]/button[3]"));
    }

    public void insertImg() {
        uploadFile(By.xpath("//*[@id=\"fileButton\"]/input"), System.getProperty("user.dir") + "\\src\\main\\resources\\Images\\roboPerfilSelenium.jpg");
        //*[@id="fileButton"]/input
    }

    public String nameMsg(){
        return getText(By.id("nameMessage"));
    }

    public String emailMsg(){
        return getText(By.id("emailMessage"));
    }

    public String TelMsg(){
        return getText(By.id("phoneMessage"));
    }

    public String CPFCNPJMsg(){
        return getText(By.id("cpfCnpjMessage"));
    }

    public String StatusMsg(){
        return getText(By.id("statusMessage"));
    }

    public String PasswordMsg(){
        return getText(By.id("passwordMessage"));
    }

    public String ConfirmPasswordMsg(){
        return getText(By.id("repeatPasswordMessage"));
    }


    //Listagem
    public void clickOptionsUserTabel(){
        clickButton(By.xpath("//*[@id=\"userTable\"]/tr/td[8]/button"));
    }

    public void clickExcludedUser(){
        clickButton(By.xpath("//*[@id=\"userTable\"]/tr/td[8]/div/ul/li[3]"));
    }

    //conferir msg antes de clicar
    public String msgPreUserExcluded(){
        return getText(By.xpath("/html/body/div[3]/div[1]/div[1]/h1"));
    }

    public void clickBtnExcluir(){
        clickButton(By.xpath("/html/body/div[3]/div[1]/div[3]/div[2]/button[1]"));
    }

    //conferir msg de excluir  => Usu�rio removido com sucesso!
    public String msgUserExcluded(){
        return getText(By.xpath("/html/body/div[3]/div[1]/div[2]"));
    }

}
