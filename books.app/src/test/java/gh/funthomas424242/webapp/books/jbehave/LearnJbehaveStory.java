package gh.funthomas424242.webapp.books.jbehave;

import gh.funthomas424242.webapp.books.Application;

import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { Application.class })
@AcceptanceTest
public class LearnJbehaveStory extends AbstractSpringJBehaveStory {
}
