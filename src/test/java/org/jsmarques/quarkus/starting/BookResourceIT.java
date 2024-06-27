package org.jsmarques.quarkus.starting;

import io.quarkus.test.junit.QuarkusIntegrationTest;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusIntegrationTest
class BookResourceIT extends BookResourceTest {
    @Test
    public void shouldGetABook() {
        given()
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
                .pathParam("id", 1).
                when()
                .get("/api/books/{id}").
                then()
                .statusCode(Response.Status.OK.getStatusCode())
                .body("title", is("Understanding Quarkus"))
                .body("author", is("João"))
                .body("yearOfPublication", is(2024))
                .body("genre", is("Information Technology"));
    }
}
