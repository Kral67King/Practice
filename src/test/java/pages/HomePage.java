package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BrowserUtils;
import utilities.Driver;

import java.util.List;
import java.util.stream.Collectors;

public class HomePage {
    public HomePage(){
        PageFactory.initElements(Driver.getDriver(),this);}

    @FindBy(tagName ="a")
    public List<WebElement>allLinks;
  @FindBy(xpath = "//a[normalize-space()='CYDEO']")
  public WebElement CydeoLink;
  @FindBy(xpath = "//a[normalize-space()='Add/Remove Elements']")
  public WebElement addRemove;
  @FindBy(xpath = "//a[normalize-space()='Basic Auth']")
  public WebElement basicAuth;
  @FindBy(xpath = "//a[normalize-space()='Broken Images']")
  public WebElement brokenLink;
  @FindBy(xpath = "//a[.='Checkboxes']")
  public WebElement checkBox;
  @FindBy(xpath = "//a[.='Frames']")
  public WebElement frame;
  @FindBy(xpath = "//a[normalize-space()='Dropdown']")
  public WebElement dropdown;
  @FindBy(css = "a[href='/forgot_password']")
  public WebElement forgotPassword;
  @FindBy(xpath = "//a[.='Autocomplete']")
  public WebElement autoComplete;
  @FindBy(xpath ="//a[.='Disappearing Elements']" )
  public WebElement disappearingElements;
    @FindBy(xpath ="//a[.='Drag and Drop']" )
    public WebElement dragAndDrop;
    @FindBy(xpath ="//a[.='Drag and Drop Circles']" )
    public WebElement dragAndDropCircle;
    @FindBy(xpath ="//a[.='Dynamic Controls']" )
    public WebElement dynamicControl;
    @FindBy(xpath ="//a[.='Form Authentication']" )
    public WebElement formAuth;
    @FindBy(xpath ="//a[.='Frames']" )
    public WebElement frames;



    public List<String> getAllLinksText() {
        return allLinks.stream().map(a->a.getText()).collect(Collectors.toList());
    }
    public String getTitle(String link){
        Driver.getDriver().findElement(By.xpath("//a[normalize-space()='"+link+"']")).click();
        return Driver.getDriver().getTitle();
    }
    String text;
    public void moveToLink(){
        BrowserUtils.scrollToElement(CydeoLink);
        text = CydeoLink.getText();
    }
    public  String getTextBottom(){
        System.out.println("text = " + text);
        return text;
    }
    public void clickAddRemove(){
        addRemove.click();
    }
    public void clickBasicAuth(){
        basicAuth.click();
    }
    public void brokenLinkClick(){brokenLink.click();}
    public void checkBoxClick(){checkBox.click();}
}
