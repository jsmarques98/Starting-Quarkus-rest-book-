package org.jsmarques.quarkus.starting;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class BookResourceTest {
    @Test
    void shouldGetAllBooks() {
        given()
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON).
                when()
                .get("api/books").
                then()
                .statusCode(200)
                .body("size()",is(4));
    }

    @Test
    void shouldCountAllBooks() {
        given()
                .header(HttpHeaders.ACCEPT, MediaType.TEXT_PLAIN).
                when()
                .get("api/books/count").
                then()
                .statusCode(200)
                .body(is("4"));
    }

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
                .body("genre", is("IT"));
    }


}