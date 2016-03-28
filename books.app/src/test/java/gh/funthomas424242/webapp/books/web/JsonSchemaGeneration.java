package gh.funthomas424242.webapp.books.web;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.jsonSchema.JsonSchema;
import com.fasterxml.jackson.module.jsonSchema.factories.SchemaFactoryWrapper;

import gh.funthomas424242.webapp.books.domain.Book;

public class JsonSchemaGeneration {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void generiereJsonSchemata() throws JsonProcessingException {
        final ObjectMapper m = new ObjectMapper();
        final SchemaFactoryWrapper visitor = new SchemaFactoryWrapper();
        m.acceptJsonFormatVisitor(m.constructType(Book.class), visitor);
        final JsonSchema jsonSchema = visitor.finalSchema();
        final String log = m.writerWithDefaultPrettyPrinter()
                .writeValueAsString(jsonSchema);
        System.out.println(log);
    }

}
