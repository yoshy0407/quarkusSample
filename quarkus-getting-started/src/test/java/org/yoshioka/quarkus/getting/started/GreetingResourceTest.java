package org.yoshioka.quarkus.getting.started;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class GreetingResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/helloworld")
          .then()
             .statusCode(200)
             .body(is("hello"));
    }

    @Test
    public void testHello2Endpoint() {
        given()
          .when().get("/helloworld/second")
          .then()
             .statusCode(200)
             .body(is("hello2"));
    }

    @Test
    public void testHello3Endpoint() {
        given()
          .when().get("/helloworld/third")
          .then()
             .statusCode(200)
             .body(is("hello3"));
    }
    
    @Test
    public void testGreetingEndpoint() {
        given()
          .when().get("/helloworld/greeting/name")
          .then()
             .statusCode(200)
             .body(is("Hello! name"));
    }

}