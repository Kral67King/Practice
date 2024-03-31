package ApiTest;

import  io.restassured.*;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Equity {
    @BeforeTest
    public void init(){
        RestAssured.baseURI = "https://indexes.morningstar.com/api/screener/filter-options";
    }
    @Test
    public void equity(){
        Response response = given().accept("*/*").log().all()
                .queryParam("assetClass","equity")
                .when().get().then().statusCode(200).
                extract().response();
        response.prettyPrint();
        List<Integer>list= response.path("");
        System.out.println("list.size() = " + list.size());
        List< List<Map<String,String>>>allListValues=new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            List<Map<String,String>> listOfValues= response.path("values.get("+i+")");
            allListValues.add(listOfValues);
        }
        System.out.println("allListValues = " + allListValues);
        System.out.println("first list of MAP = " + allListValues.get(0));
        for (Map<String, String> each : allListValues.get(0)) {
            System.out.println("each = " + each);
            
        }
    }
    @Test
    public void equity2(){
        Response response = get("https://indexes.morningstar.com/api/screener/filter-options?assetClass=equity");
        System.out.println("response.statusCode() = " + response.statusCode());
        response.prettyPrint();
        List<Map<String,String>> listOfMap= response.as(List.class);
        System.out.println("listOfMap = " + listOfMap);
        for (Map<String, String> each : listOfMap) {
            System.out.println("each = " + each);

        }
    }
}
