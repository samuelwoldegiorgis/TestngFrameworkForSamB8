package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import sun.rmi.runtime.Log;

public class LoginPage {
    @FindBy(id="txtUsername")
    WebElement username;

    @FindBy(id="//input[@id='tstPassword']")
    public WebElement passwordBox;

    @FindBy(css= "input#btnLogin")
    public WebElement loginBtn;

    LoginPage(){
        PageFactory.initElements(driver,this);

    }
}
