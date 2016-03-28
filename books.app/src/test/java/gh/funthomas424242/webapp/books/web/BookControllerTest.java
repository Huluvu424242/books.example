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
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jayway.restassured.response.Response;

import gh.funthomas424242.webapp.books.Application;
import gh.funthomas424242.webapp.books.domain.Book;
import gh.funthomas424242.webapp.books.domain.ISBN;
import gh.funthomas424242.webapp.books.service.BookService;

/**
 * Die Test Schemata werden aus dem Response des ersten Test über
 * http://jsonschema.net/#/ manuell generiert.
 *
 *
 * @author huluvu424242
 *
 */
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

    // @Test
    // public void generiereJsonSchemata() throws JsonProcessingException {
    // final Response response = when().get("/books").then()
    // .contentType("application/hal+json").extract().response();
    // assertNotNull(response);
    //
    // final String jsonContent = response.asString();
    //
    // System.out.println(jsonContent);
    // final ObjectMapper m = new ObjectMapper();
    // m.gener
    // // final SchemaFactoryWrapper visitor = new SchemaFactoryWrapper();
    // // m.acceptJsonFormatVisitor(m.constructType(books.getClass()),
    // // visitor);
    // // final JsonSchema jsonSchema = visitor.finalSchema();
    // // final String log = m.writerWithDefaultPrettyPrinter()
    // // .writeValueAsString(jsonSchema);
    // // System.out.println(log);
    // }

    @Test
    public void testValidResponsesContentAndType() {

        final Response response = when().get("/books").then()
                .contentType("application/hal+json").extract().response();
        assertNotNull(response);

        final String jsonContent = response.asString();
        assertThat(jsonContent,
                matchesJsonSchemaInClasspath("books-schema.json"));

    }

    @Test
    @Ignore
    public void testAddABook() {

        // final Response response = when().get("/books").then()
        // .contentType("application/hal+json").extract().response();
        // assertNotNull(response);
        //
        // final String jsonContent = response.asString();
        // assertThat(jsonContent,
        // matchesJsonSchemaInClasspath("books-schema.json"));

        given().parameters("titel", "Das Boot").when().post("/book/new").then()
                .contentType("application/hal+json")
                .body(matchesJsonSchemaInClasspath("books-schema.json"));
    }

    @Test
    public void validierteSchemaUeberBody() {

        when().get("/books").then().assertThat()
                .body(matchesJsonSchemaInClasspath("books-schema.json"));

    }

    @Test
    public void validierteSchemaUeberAssertThat() {
        final Response response = get("/books");
        final String jsonObject = response.asString();

        assertThat(jsonObject,
                matchesJsonSchemaInClasspath("books-schema.json"));
    }

}
