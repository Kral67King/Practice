package ApiTest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public class Book {
    @Test
    public void basicMethod(){
        Response response = RestAssured.get("https://restful-booker.herokuapp.com/booking").then().statusCode(200).extract().response();
        List<String> bookingids = response.path("bookingid");
        System.out.println("bookingids.size() = " + bookingids.size());
        System.out.println("bookingids = " + bookingids);
        List<Map<String,Integer>> list =response.jsonPath().get();

        for (Map<String, Integer> eachElement : list) {
            System.out.println("eachElement.entrySet() = " + eachElement.entrySet());
            System.out.println("eachElement.values() = " + eachElement.values());
            for (Map.Entry<String, Integer> each : eachElement.entrySet()) {
                System.out.println("each.getKey()+\"\"+each.getValue() = " + each.getKey() + " : " + each.getValue());
            }
        }
        
        System.out.println("response.statusCode() = " + response.statusCode());
        response.prettyPrint();


    }
}
