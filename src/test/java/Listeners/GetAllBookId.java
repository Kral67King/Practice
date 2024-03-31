package Listeners;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
@Listeners(CustomListeners.class)
public class GetAllBookId {
    String generalToken;
    Integer generalId;
    @BeforeTest
    public void init() {
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
    }
    @Test(priority = 0)
    public void getAll(){
        Response response = get("/booking");
        //validate status code
        System.out.println("response.statusCode() = " + response.statusCode());
        Assert.assertEquals(response.statusCode(),200);
       //size of list
        List<Map<String,Integer>> list = response.jsonPath().getList("");
        System.out.println("============================================================================================= ");

        System.out.println("list = " + list);

        System.out.println("============================================================================================= ");

        Map<String, Integer> stringIntegerMap = list.get(0);
        System.out.println("stringIntegerMap.values() = " + stringIntegerMap.values());

        System.out.println("============================================================================================= ");

        System.out.println("list.get(0) = " + list.get(0));

        System.out.println("============================================================================================= ");
        System.out.println("list.size() = " + list.size());

        //validate response header
        System.out.println("============================================================================================= ");
        System.out.println("Content Type = " + response.header("Content-Type"));
        Assert.assertEquals(response.header("Content-Type"),"application/json; charset=utf-8");
        //Header have a date
        Assert.assertTrue(!response.getHeader("Date").isEmpty());
        System.out.println("============================================================================================= ");

    }

    @Test(priority = 1)
    public void Token(){
        Map<String,String> body=new LinkedHashMap<>();
        body.put("username","admin");
        body.put("password","password123");
        Response response = given().accept(ContentType.JSON).log().all() // what we are asking from api which is JSON response
                .and()
                .contentType(ContentType.JSON) //what we are sending to api, which is JSON request body
                .body(body)
                .when()
                .post("/auth");
        response.prettyPrint();
        generalToken = response.jsonPath().get("token").toString();

        System.out.println("============================================================================================= ");
        System.out.println("generalToken = " + generalToken);
        Assert.assertEquals(response.statusCode(),200);
    }
    @Test(priority = 2)
    public void createBook(){
String requestBody="{\n" +
        "    \"firstname\" : \"Enes\",\n" +
        "    \"lastname\" : \"Kral\",\n" +
        "    \"totalprice\" : 111,\n" +
        "    \"depositpaid\" : true,\n" +
        "    \"bookingdates\" : {\n" +
        "        \"checkin\" : \"2018-01-01\",\n" +
        "        \"checkout\" : \"2019-01-01\"\n" +
        "    },\n" +
        "    \"additionalneeds\" : \"Breakfast\"\n" +
        "}";
        System.out.println("===================================== CREATE BOOK WITH POST ======================================================== ");
        Response response = given().log().all() // what we are asking from api which is JSON response
                .and()
                .contentType(ContentType.JSON) //what we are sending to api, which is JSON request body
                .body(requestBody)
                .when()
                .post("/booking");
            response.prettyPrint();
        System.out.println("response.statusCode() = " + response.statusCode());
        System.out.println("============================================================================================= ");
         generalId= response.jsonPath().get("bookingid");
        String firstname = response.jsonPath().get("booking.firstname").toString();
        System.out.println("firstname = " + firstname);
        Assert.assertEquals(response.statusCode(),200);
        Assert.assertEquals(firstname,"Enes");

        System.out.println("generalId = " + generalId);
        System.out.println("generalToken = " + generalToken);
    }
    @Test(priority = 3)
    public void UpdatePut(){
        String requestBody="{\n" +
                "    \"firstname\" : \"Enes\",\n" +
                "    \"lastname\" : \"Kral67\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";
        Response response = given().log().all()
                .cookie("token",generalToken)
                .contentType(ContentType.JSON) //what we are sending to api, which is JSON request body
                .body(requestBody)
                .and()
                .pathParam("id",generalId)
                .when()
                .put("/booking/{id}");
        response.prettyPrint();

    }
    @Test(priority = 4)
    public void Patch(){
        Map<String,String> bodyChange=new LinkedHashMap<>();
        bodyChange.put("firstname","Kamil");
        bodyChange.put("lastname","USTA");
        Response response = given().log().all()
                .cookie("token",generalToken)//
                .contentType(ContentType.JSON) //what we are sending to api, which is JSON request body
                .body(bodyChange)
                .and()
                .pathParam("id",generalId)
                .when()
                .patch("/booking/{id}");
        response.prettyPrint();
    }

    @Test(priority = 5)
    public void Delete(){
        Response response = given().log().all()
                .cookie("token",generalToken)// what we are asking from api which is JSON response
                .contentType(ContentType.JSON) //what we are sending to api, which is JSON request body
                .and()
                .pathParam("id",generalId)
                .when()
                .delete("/booking/{id}");
        response.prettyPrint();
    }
}
