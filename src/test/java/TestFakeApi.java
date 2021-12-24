

import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.net.HttpCookie;

import static io.restassured.RestAssured.*;
public class TestFakeApi {
    @Test
    public void test_get_01(){
        baseURI="http://localhost:3000";
        given().get("users").then().statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void test_post_01(){
        baseURI="http://localhost:3000";
        JSONObject jsonObject= new JSONObject();
        jsonObject.put("firstname", "Aniekeme");
        jsonObject.put("lastname", "Annie");
        jsonObject.put("subjectId", 1);
        given().contentType(ContentType.JSON).body(jsonObject.toJSONString()).post(
                "users").then().statusCode(HttpStatus.SC_CREATED);

    }
    @Test
    public void test_put_01(){
        baseURI="http://localhost:3000";
        JSONObject jsonObject= new JSONObject();
        jsonObject.put("firstname", "Stephen");
        jsonObject.put("subjectId", 1 );
        given().contentType(ContentType.JSON).body(jsonObject.toJSONString()).put(
                "users/2").then().statusCode(HttpStatus.SC_OK);


    }
    @Test
    public void test_patch_01(){
        baseURI="http://localhost:3000";
        JSONObject jsonObject= new JSONObject();
        jsonObject.put("firstname", " Sarika");
        given().contentType(ContentType.JSON).body(jsonObject.toJSONString()).patch("users/4")
                .then().statusCode(HttpStatus.SC_OK);
    }


}
