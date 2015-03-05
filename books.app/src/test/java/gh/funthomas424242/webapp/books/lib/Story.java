package gh.funthomas424242.webapp.books.lib;

import gh.funthomas424242.webapp.books.Application;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.annotation.DirtiesContext;


@SpringApplicationConfiguration(classes = { Application.class })
@DirtiesContext
@WebIntegrationTest({ "server.port=8080" })
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Story {
}
