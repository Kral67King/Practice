package ApiTest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Interview {
    @Test
    public void  interview(){
       Response response= RestAssured.get("https://parallelum.com.br/fipe/api/v1/carros/marcas/59/modelos");
       response.prettyPrint();
        List<Map<String,String>> list= response.path("modelos");
        Map<String, String> map = list.get(0);
        System.out.println("MAP = " + map);

        Map<String,String >result=new LinkedHashMap<>();
        List<String> listOfKeys=new ArrayList<>();
        for (String s : map.keySet()) {
           listOfKeys.add(s);
        }
        result.put(listOfKeys.get(0),listOfKeys.get(1));
        System.out.println("result = " + result);


    }
}
