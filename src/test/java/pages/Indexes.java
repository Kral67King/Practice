package pages;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BrowserUtils;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Indexes {
    public Indexes() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
   String valueOfCheckBox="//span[@class='mds-checkbox__text__mds-nuxt'][normalize-space()='value']/preceding-sibling::span//span";
    @FindBy(xpath = "//ul[@role='tablist']//li")
    public List<WebElement> tabList;
    @FindBy(xpath = "//span[@class='mds-checkbox__text__mds-nuxt'][normalize-space()='Equity']/preceding-sibling::span")
    public WebElement EquityCheckBox;
    @FindBy(xpath = "//span[@class='mds-checkbox__text__mds-nuxt'][normalize-space()='Fixed Income']/preceding-sibling::span")
    public WebElement FixedIncomeCheckBox;
    @FindBy(xpath = "//span[@class='mds-checkbox__text__mds-nuxt'][normalize-space()='Multi Asset']/preceding-sibling::span")
    public WebElement MultiAssetCheckBox;
    @FindBy(xpath = "//span[@class='mds-checkbox__text__mds-nuxt'][normalize-space()='Alternatives']/preceding-sibling::span")
    public WebElement AlternativesCheckBox;
    @FindBy(xpath = "//span[@class='mds-checkbox__text__mds-nuxt'][normalize-space()='ESG Index']/preceding-sibling::span")
    public WebElement ESGCheckBox;
    @FindBy(xpath = "//span[@class='mds-checkbox__text__mds-nuxt'][normalize-space()='Private Markets']/preceding-sibling::span")
    public WebElement PrivateMarketsCheckBox;
    @FindBy(xpath = "//span[@class='mds-checkbox__text__mds-nuxt'][normalize-space()='Strategic Beta']/preceding-sibling::span")
    public WebElement StrategicBetaCheckBox;
    @FindBy(xpath = "//input[@placeholder='Filter by keyword']")
    public WebElement searchBox;
    @FindBy(xpath = "//button[@type='button']//span[contains(text(),'Equity')]")
    public WebElement EquityHeader;
    @FindBy(xpath = "//button[@type='button']//span[contains(text(),'Fixed Income')]")
    public WebElement FixedIncomeHeader;
    @FindBy(xpath = "//button[@type='button']//span[contains(text(),'Multi Asset')]")
    public WebElement MultiAssetHeader;
    @FindBy(xpath = "//button[@type='button']//span[contains(text(),'Alternatives')]")
    public WebElement AlternativesHeader;
    @FindBy(xpath = "//button[@type='button']//span[contains(text(),'ESG')]")
    public WebElement ESGHeader;
    @FindBy(xpath = "//button[@type='button']//span[contains(text(),'Private Markets')]")
    public WebElement PrivateMarketHeader;
    @FindBy(xpath = "//tbody/tr/td[1]")
    public List<WebElement> indexName;
    @FindBy(xpath = "//button[@id='MONTHLY']")
    public WebElement ReturnOverview;
    @FindBy(xpath = "//th[@class='mds-th__mds-nuxt mds-th--right__mds-nuxt mds-th--sortable__mds-nuxt']")
    public List<WebElement> returnOverviewCase;
    @FindBy(xpath = "//button[@id='ANNUAL']")
    public WebElement annualReturn;
    @FindBy(xpath = "(//div[@class='mds-combo-box__mds-nuxt'])[1]")
    public WebElement indexFamilyDropdown;
    @FindBy(xpath = "//span[normalize-space()='Morningstar 529 College Savings']")
    public WebElement CollageSaving529;
    @FindBy(xpath = "//li[@role='option']")
    public List<WebElement> allDropDownElements;
    @FindBy(xpath = "//ul[@id='mds-combo-box-874310']")
            public WebElement boxIndexFamily;

    Actions actions = new Actions(Driver.getDriver());
    public void selectIndexDropdown() {
        BrowserUtils.scrollToElement(500);
        indexFamilyDropdown.click();
        BrowserUtils.scrollToElement(200);
        for (WebElement allDropDownElement : allDropDownElements) {
            actions.moveToElement(allDropDownElement).clickAndHold().moveByOffset(0, 20).release().perform();
            //actions.moveToElement(boxIndexFamily).clickAndHold().moveByOffset(0, 20).release().perform();
            allDropDownElement.click();


            BrowserUtils.sleep(2);
            allDropDownElement.isSelected();
            //CollageSaving529.click();
            // CollageSaving529.isSelected();

        }
    }


    public List<String> isSelected(String selection) {
        List<String>list=new ArrayList<>();
        switch (selection){
            case "Return Overview":
             list.addAll(returnOverviewCase.stream().map(a->a.getText()).collect(Collectors.toList()));
            break;
            case "Annual Returns":
                annualReturn.click();
                list.addAll(returnOverviewCase.stream().map(a->a.getText()).collect(Collectors.toList()));
            break;
        }
        return list;
    }
    public boolean matchClick(String selection){


        boolean result=true;
        switch (selection){
            case "Equity":
                BrowserUtils.scrollToElement();
                actions.doubleClick(EquityHeader).perform();
                BrowserUtils.sleep(2);
                 result =EquityCheckBox.isSelected();
                 break;

            case "Fixed Income":
                BrowserUtils.scrollToElement();
                actions.doubleClick(FixedIncomeHeader).perform();
                BrowserUtils.sleep(2);
                  result= FixedIncomeCheckBox.isSelected();
                  break;

            case "Multi Asset":
                BrowserUtils.scrollToElement();
                actions.doubleClick(MultiAssetHeader).perform();
                BrowserUtils.sleep(2);
                result=MultiAssetCheckBox.isSelected();
                break;

            case "Alternatives":
                BrowserUtils.scrollToElement();
                actions.doubleClick(AlternativesHeader).perform();
                BrowserUtils.sleep(2);
                result=AlternativesCheckBox.isSelected();
                break;

            case "ESG":
                BrowserUtils.scrollToElement();
                actions.doubleClick(ESGHeader).perform();;
                BrowserUtils.sleep(2);
                result=ESGCheckBox.isSelected();
                break;

            case "Private Markets":
                BrowserUtils.scrollToElement();
                actions.doubleClick(PrivateMarketHeader).perform();
                BrowserUtils.sleep(2);
               result= PrivateMarketsCheckBox.isSelected();
               break;
        }
        return result;
    }

public  List<String> searchResult(){
    return indexName.stream().map(a->a.getText()).collect(Collectors.toList());
}
    public  void searchBox(String keyword){
        BrowserUtils.scrollToElement();
        searchBox.sendKeys(keyword);
        searchBox.sendKeys(Keys.ENTER);
        BrowserUtils.sleep(2);

    }

    public List<String> getTabList() {

        return tabList.stream().map(a -> a.getText()).collect(Collectors.toList());
    }

    public void clickCheckBox(String box) {
        switch (box){
            case "Equity":
                BrowserUtils.scrollToElement();
                BrowserUtils.sleep(2);
                EquityCheckBox.click();
                EquityCheckBox.isSelected();
                BrowserUtils.sleep(2);
                break;
            case "Fixed Income":
                BrowserUtils.scrollToElement(500);
                BrowserUtils.sleep(2);
                FixedIncomeCheckBox.click();
                FixedIncomeCheckBox.isSelected();
                BrowserUtils.sleep(2);
                break;

            case "Multi Asset":
                BrowserUtils.scrollToElement(600);
                BrowserUtils.sleep(2);
                MultiAssetCheckBox.click();
                MultiAssetCheckBox.isSelected();
                BrowserUtils.sleep(2);
                break;
            case "Alternatives":
                BrowserUtils.scrollToElement(500);
                BrowserUtils.sleep(2);
                AlternativesCheckBox.click();
                AlternativesCheckBox.isSelected();
                BrowserUtils.sleep(2);
                break;

            case "ESG":
                BrowserUtils.scrollToElement(500);
                BrowserUtils.sleep(2);
                ESGCheckBox.click();
                ESGCheckBox.isSelected();
                BrowserUtils.sleep(2);
                break;
            case "Private Markets":
                BrowserUtils.scrollToElement(500);
                BrowserUtils.sleep(2);
                PrivateMarketsCheckBox.click();
                PrivateMarketsCheckBox.isSelected();
                BrowserUtils.sleep(2);
                break;
            case "Strategic Beta":
                BrowserUtils.scrollToElement(500);
                BrowserUtils.sleep(2);
                StrategicBetaCheckBox.click();
                StrategicBetaCheckBox.isSelected();
                BrowserUtils.sleep(2);
                break;
        }


    }
}

