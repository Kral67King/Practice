package Playwright;

import Playwright.Pages.HomePagePL;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class GetTitle extends HomeBasePL {

    @Test
    public void titleOfPage(){
        System.out.println("Title of the page  = " + page.title());
        String title = page.title();
        Assert.assertEquals(title,"Practice");
      //  page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshot.png")));

    }
    @Test
    public void allText(){
        List<ElementHandle> elementHandles = page.querySelectorAll("a");
        List<String> list = elementHandles.stream().map(a -> a.textContent()).collect(Collectors.toList());
        System.out.println("list = " + list);
    }
}
