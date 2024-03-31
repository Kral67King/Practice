package tests;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Indexes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HeaderMenu extends TestBase {
    Indexes indexes = new Indexes();

    //User able to see headers in correct order
    @Test
    public void header_validation() {
        List<String> tabListExpected =
                new ArrayList<>(Arrays.asList("All Indexes", "Equity", "Fixed Income", "Multi Asset", "Alternatives", "ESG", "Private Markets"));
        List<String> tabListActual = indexes.getTabList();
        Assert.assertEquals(tabListExpected, tabListActual);
    }

    @Test
    public void checkBox() {
        indexes.clickCheckBox("Fixed Income");
    }
    @Test
    public void search() {
        indexes.searchBox("Focus");
        List<String> list = indexes.searchResult();
        for (String s : list) {
            if(!s.contains("Focus")){
                System.out.println("s = " + s);
            }
            Assert.assertTrue(s.contains("Focus"));
        }
    }
    @Test
    public void clickMatch(){
        indexes.matchClick("Fixed Income");
    }
    @Test
    public void returnOverview(){
        List<String> actualSelections = indexes.isSelected("Return Overview");
        List<String> expectedSelections=new ArrayList<>(Arrays.asList("Daily Close", "1-Day", "1-Week", "1-Month", "YTD", "Close Price Date"));
        Assert.assertEquals(actualSelections,expectedSelections);
    }
    @Test
    public void annualReturns(){
        List<String> actualselections = indexes.isSelected("Annual Returns");
        List<String> expectedSelections=new ArrayList<>(Arrays.asList("YTD", "2023", "2022", "2021", "2020", "2019"));
        Assert.assertEquals(actualselections,expectedSelections);
    }
    @Test
    public void dropdownClick(){
        indexes.selectIndexDropdown();
    }

}
