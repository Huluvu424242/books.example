package gh.funthomas424242.webapp.books.jbehave;

import gh.funthomas424242.webapp.books.Application;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;


@SpringApplicationConfiguration(classes = { Application.class })
//@ContextConfiguration(classes = Application.class)
//@ImportResource({"classpath:/application.properties"})
//@ActiveProfiles("tests")
@DirtiesContext
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@WebIntegrationTest({ "server.port=8080" })
public @interface Story {
}
