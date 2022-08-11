package core;

import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {

    private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<WebDriver>(){
        @Override
        protected synchronized @NotNull WebDriver initialValue(){
            return initDriver();
        }
    };

    private DriverFactory(){}

    public static WebDriver getDriver(){
        return threadDriver.get();
    }

    public static WebDriver initDriver(){
        WebDriver driver = null;

        if(Properties.EXECUTION_TYPE == Properties.ExecutionType.LOCAL) {
            switch (Properties.BROWSER) {
                case FIREFOX: driver = new FirefoxDriver(); break;
                case CHROME: driver = new ChromeDriver(); break;
            }
        }
        if(Properties.EXECUTION_TYPE == Properties.ExecutionType.GRID){
            DesiredCapabilities cap = null;
            switch (Properties.BROWSER) {
                case FIREFOX: cap = DesiredCapabilities.firefox(); break;
                case CHROME: cap = DesiredCapabilities.chrome(); break;
            }
            try {
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), (Capabilities) cap);
            } catch (MalformedURLException e){
                System.out.println("!!!!!!!!!FALHA NA CONEXÃO COM GRID!!!!!!!!");
                e.printStackTrace();
            }

        }
        if(Properties.EXECUTION_TYPE == Properties.ExecutionType.NUVEM){
            DesiredCapabilities cap = null;
            switch (Properties.BROWSER) {
                case FIREFOX: cap = DesiredCapabilities.firefox(); break;
                case CHROME: cap = DesiredCapabilities.chrome(); break;
            }

            try {
                //pegar dados do SauceLabs
                driver = new RemoteWebDriver(new URL("https://oauth-tuliolascalla-8f453:ddb24c4e-ddc9-4384-8454-b136c037fb14@ondemand.us-west-1.saucelabs.com:443/wd/hub"), (Capabilities) cap);
            } catch (MalformedURLException e){
                System.out.println("!!!!!!!!!FALHA NA CONEXÃO COM GRID!!!!!!!!");
                e.printStackTrace();
            }
            //c8a1fafa-d09a-48c9-beb7-1e3de4b3f4e6
            //https://oauth-tuliolascalla-8f453:c8a1fafa-d09a-48c9-beb7-1e3de4b3f4e6@ondemand.us-west-1.saucelabs.com:443/wd/hub
        }
        driver.manage().window().maximize();
        return driver;
    }

    public static void killDriver(){
        WebDriver driver = getDriver();
        if(driver != null) {
            driver.quit();
            driver = null;
        }
        if(threadDriver != null){
            threadDriver.remove();
        }
    }


}
