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
