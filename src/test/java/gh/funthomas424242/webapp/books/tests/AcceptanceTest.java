package gh.funthomas424242.webapp.books.tests;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.ImportResource;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = AcceptanceTestsConfiguration.class)
@ImportResource({"classpath:/application.properties", "classpath:/tests.properties"})
@ActiveProfiles("tests")
@DirtiesContext
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface AcceptanceTest {
}
