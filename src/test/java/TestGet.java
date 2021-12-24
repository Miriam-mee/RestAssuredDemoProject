import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.apache.http.protocol.HTTP;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class TestGet {
    @Test
    void getRequest() {
        Response response = RestAssured.get("http://localhost:9191/productcatalog/products");
        System.out.println(response.getBody().asString());
        System.out.println(response.getStatusCode());
        System.out.println(response.getHeaders());
        System.out.println("Header ==" + response.getHeader("Content-Type"));
        String expectedOutput = "[{\"id\":4,\"name\":\"Laptop\",\"quantity\":3,\"price\":2400.0},{\"id\":7,\"name\":\"Samsung\",\"quantity\":6,\"price\":400.0},{\"id\":6,\"name\":\"Laptop\",\"quantity\":3,\"price\":2400.0},{\"id\":8,\"name\":\"Itel\",\"quantity\":5,\"price\":500.0},{\"id\":9,\"name\":\"Acer\",\"quantity\":6,\"price\":700.0}]";
        assertEquals(expectedOutput,response.getBody().asString());
        int actualStatusCode = response.getStatusCode();
        assertEquals(HttpStatus.SC_OK, actualStatusCode);
    }
    @Test
    void TestGet1(){
        given().get("http://localhost:9191/productcatalog/products").then().statusCode(HttpStatus.SC_OK);
    }



}