package gh.funthomas424242.webapp.books.web;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import gh.funthomas424242.webapp.books.service.BookService;

@Profile("resttest")
@Configuration
public class RestTestConfiguration {

    @Bean
    @Primary
    public BookService getBookSerive() {
        return Mockito.mock(BookService.class);
    }
}