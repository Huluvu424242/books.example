package gh.funthomas424242.webapp.books.tests;

import gh.funthomas424242.webapp.books.BookController;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
//@Import({DomainConfiguration.class, InfrastructureConfiguration.class})
@Import ({BookController.class})
@ComponentScan
public class AcceptanceTestsConfiguration {
}

