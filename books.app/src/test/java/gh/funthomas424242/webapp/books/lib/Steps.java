package gh.funthomas424242.webapp.books.lib;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.stereotype.Component;
@Target(value = ElementType.TYPE)
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
@Component
@WebIntegrationTest({ "server.port=8080" })
public @interface Steps {
}