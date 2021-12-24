import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class TestPutPatchDelete {

    @Test
    public void test_put_1(){
        baseURI= "http://localhost:9191";
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "Minitab");
        jsonObject.put("quantity", Integer.valueOf(1));
        System.out.println("jsonObject :" +jsonObject);
        given().contentType(ContentType.JSON).body(jsonObject.toJSONString()).
        when().put("productcatalog/product/update/8")
        .then().statusCode(HttpStatus.SC_OK).log().all();
    }
    @Test
    public void test_patch_1(){
        baseURI= "http://localhost:9191";
        JSONObject jsonObject= new JSONObject();
        jsonObject.put("name", " Majortab");
        System.out.println("jsonObject :" +jsonObject);
        given().contentType(ContentType.JSON).body(jsonObject.toJSONString()).
                when().patch("productcatalog/product/update/8")
                .then().statusCode(HttpStatus.SC_OK).log().all();


    }
    @Test
        public void test_delete_1(){
        baseURI= "http://localhost:9191";
        given().when().delete("productcatalog/delete/6")
                .then().statusCode(HttpStatus.SC_OK).log().all();

        }
    }

