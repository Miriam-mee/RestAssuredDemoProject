import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestDataDrivenRestAssuredDemo {


    @Test
            (dataProvider = "productdata")

    public void test_post(String productName, Integer quantity, Integer price){
        baseURI="http://localhost:9191";
        JSONObject jsonObject= new JSONObject();
        jsonObject.put("name", productName);
        jsonObject.put("quantity", quantity);
        jsonObject.put("price", price);
        System.out.println(jsonObject.toJSONString());


//        creating request specification
        RequestSpecification request= given();
        request.contentType(ContentType.JSON);
        request.body(jsonObject.toJSONString());

        //Response
        Response response = request.post("productcatalog/products");

        String responseAsString = response.getBody().asString();
        System.out.println("Response : "+ responseAsString);

        //Assertions
        assertTrue(responseAsString.contains(productName));
        assertTrue(responseAsString.contains(quantity.toString()));
        assertTrue(responseAsString.contains(price.toString()));
        assertEquals(HttpStatus.SC_CREATED, response.getStatusCode());

    }

    @DataProvider(name = "productdata")
    public Object[][] getProductData(){
     Object productInfo [][] = {{"tablet",Integer.valueOf(2), Integer.valueOf(200)},{"Desktop", Integer.valueOf(12), Integer.valueOf(400)},{"Iphone", Integer.valueOf(4), Integer.valueOf(15000)}};
     return productInfo;
}
}