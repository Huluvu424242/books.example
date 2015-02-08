package gh.funthomas424242.webapp.books.tests;

import gh.funthomas424242.webapp.books.Application;
import gh.funthomas424242.webapp.books.domain.DomainConfiguration;
import gh.funthomas424242.webapp.books.infrastructure.InfrastructureConfiguration;
import gh.funthomas424242.webapp.books.service.ServiceConfiguration;
import gh.funthomas424242.webapp.books.web.WebConfiguration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@EnableAutoConfiguration
@Import({ Application.class, WebConfiguration.class,
		ServiceConfiguration.class, DomainConfiguration.class,
		InfrastructureConfiguration.class })
@ComponentScan
public class AcceptanceTestsConfiguration {
}
