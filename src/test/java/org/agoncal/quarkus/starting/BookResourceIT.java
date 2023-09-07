package org.agoncal.quarkus.starting;

import io.quarkus.test.junit.QuarkusIntegrationTest;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusIntegrationTest
public class BookResourceIT extends BookResourceTest {
    @Test
    public void shouldGetABooks() {
        given()
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
                .pathParam("id", 1).
                when()
                .get("/api/books/{id}").
                then()
                .statusCode(200)
                .body("title", is("Thinking in Java"))
                .body("author", is("Bruce Eckel"))
                .body("yearOfPublication", is(1998))
                .body("genre", is("non-fiction"));
    }
}
