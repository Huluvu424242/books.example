package gh.funthomas424242.webapp.books.web;

import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.RestAssured.when;
import static com.jayway.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

import gh.funthomas424242.webapp.books.Application;
import gh.funthomas424242.webapp.books.domain.Book;
import gh.funthomas424242.webapp.books.domain.ISBN;
import gh.funthomas424242.webapp.books.service.BookService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { Application.class })
@WebIntegrationTest
@ActiveProfiles("resttest")
public class BookControllerTest {

    // @Value("${local.server.port}")
    // int port;

    @Autowired
    BookService bookServiceMock;

    @Before
    public void setUp() throws Exception {

        final List<Book> books = new ArrayList<>();
        final Book bookDasBoot = new Book("Das Boot",
                ISBN.parseFromString("3-3-3"));
        books.add(bookDasBoot);
        Mockito.when(bookServiceMock.findAll()).thenReturn(books);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testValidResponses() {

        final Response response = when().get("/books").then()
                .contentType(ContentType.JSON). // check that the content type
                                                // return from the API is JSON
        extract().response();
        assertNotNull(response);
        final String jsonContent = response.asString();
        assertThat(jsonContent,
                matchesJsonSchemaInClasspath("books-schema.json"));

        given().contentType("application/hal+json").and()
                .body(new String("hallo")).when().get("/books");
        // expect().body("").when().get("/books");
        // assertNotNull(response);
    }

    @Test
    public void validierteSchema() {
        get("/books").then().assertThat()
                .body(matchesJsonSchemaInClasspath("books-schema.json"));
        // // Given
        // final String json = null;
        // // Then
        // assertThat(json,
        // matchesJsonSchemaInClasspath("greeting-schema.json"));
    }

}
