package gh.funthomas424242.webapp.books;

/*
 * #%L
 * Books.App
 * %%
 * Copyright (C) 2015 Pivotal Software, Inc.
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Lesser Public License for more details.
 * 
 * You should have received a copy of the GNU General Lesser Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/lgpl-3.0.html>.
 * #L%
 */

import java.util.HashMap;
import java.util.Map;

import org.glassfish.jersey.servlet.ServletContainer;
import org.glassfish.jersey.servlet.ServletProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		final SpringApplication app = new SpringApplication(Application.class);
	    app.setShowBanner(true);
	    final Map<String,Object> config=new HashMap<String,Object>();
	    config.put("spring.datasource.url","jdbc:h2:tcp://books_db:1521//opt/h2-data/bookdb;DB_CLOSE_ON_EXIT=FALSE");
	    config.put("spring.jpa.hibernate.ddl-auto", "update");
	    app.setDefaultProperties(config);
	    app.run(args);
	}
	
	@Bean
	public ServletRegistrationBean jerseyServlet() {
	    ServletRegistrationBean registration = new ServletRegistrationBean(new ServletContainer(), "/*");
	    // our rest resources will be available in the path /rest/*
	    registration.addInitParameter(ServletProperties.JAXRS_APPLICATION_CLASS, JerseyConfig.class.getName());
	    return registration;
	}

}
