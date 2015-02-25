package gh.funthomas424242.webapp.books;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		final SpringApplication app = new SpringApplication(Application.class);
	    app.setShowBanner(true);
	    final Map<String,Object> config=new HashMap<String,Object>();
	    config.put("spring.datasource.url","jdbc:h2:file:~/bookdb;DB_CLOSE_ON_EXIT=FALSE");
	    config.put("spring.jpa.hibernate.ddl-auto", "update");
	    app.setDefaultProperties(config);
	    app.run(args);
	}
}
