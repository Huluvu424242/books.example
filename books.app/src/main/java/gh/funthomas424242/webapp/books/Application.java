package gh.funthomas424242.webapp.books;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		final SpringApplication app = new SpringApplication(Application.class);
	    app.setShowBanner(true);
	    app.run(args);
		
		//SpringApplication.run(Application.class, args);
	}
}
