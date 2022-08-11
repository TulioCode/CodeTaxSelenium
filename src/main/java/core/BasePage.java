package core;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

import static core.DriverFactory.getDriver;

public class BasePage {
    /********* TextField e TextArea ************/

    public void write(By by, String text){
        getDriver().findElement(by).clear();
        getDriver().findElement(by).sendKeys(text);
    }

    public String getFieldValue(By by) {
        return getDriver().findElement(by).getAttribute("value");
    }

    /********* Radio e Check ************/

    public void clickRadioOrCheck(By by) {
        getDriver().findElement(by).click();
    }

    public boolean isRadioOrCheckMarked(By by){
        return getDriver().findElement(by).isSelected();
    }

    /********* Combo ************/

    public void selectCombo(By by, String valor) {
        WebElement element = getDriver().findElement(by);
        Select combo = new Select(element);
        combo.selectByVisibleText(valor);
    }

    public String getComboValue(By by) {
        WebElement element = getDriver().findElement(by);
        Select combo = new Select(element);
        return combo.getFirstSelectedOption().getText();
    }

    public List<String> getComboValues(By by) {
        WebElement element = getDriver().findElement(by);
        Select combo = new Select(element);
        List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
        List<String> valores = new ArrayList<String>();
        for(WebElement opcao: allSelectedOptions) {
            valores.add(opcao.getText());
        }
        return valores;
    }

    public boolean checkComboOption(By by, String optionValue){
        WebElement element = getDriver().findElement(by);
        Select combo = new Select(element);
        List<WebElement> options = combo.getOptions();
        for(WebElement option: options) {
            if(option.getText().equals(optionValue)){
                return true;
            }
        }
        return false;
    }

    /********* Botao ************/

    public void clickButton(By by) {
        getDriver().findElement(by).click();
    }

    public void clickButtonByText(String texto){ clickButton(By.xpath("//button[.='"+texto+"']"));}

    public void clickButtonLink(String link) {
        getDriver().findElement(By.linkText(link)).click();
    }

    public String getText(By by) {
        return getDriver().findElement(by).getText();
    }

    /********* Frames e Janelas ************/

    public void enterFrame(WebElement elem) {
        getDriver().switchTo().frame(elem);
    }

    public void exitFrame(){
        getDriver().switchTo().defaultContent();
    }

    public void changeWindow(String id) {
        getDriver().switchTo().window(id);
    }

    /************** JS *********************/

    public Object runJS(String cmd, Object... param) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        return js.executeScript(cmd, param);
    }

    public Object scrollJS(int x, int y){
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        return js.executeScript("window.scrollBy("+x+", "+y+")", "");
    }

    public Object scrollJSBottonPage(){
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        return js.executeScript("0,document.body.scrollHeight", "");
    }

    /********* UpLoad ************/

    public void uploadFile(By by, String caminho){
        getDriver().findElement(by).clear();
        getDriver().findElement(by).sendKeys(caminho);
    }

}

































