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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    private static final String BOOKS_DB_PORT_1521_TCP = "BOOKS_DB_PORT_1521_TCP";
    private static final Logger LOG = LoggerFactory
            .getLogger(Application.class);

    public static void main(String[] args) {
        final Application app = new Application();
        app.start(args);
    }

    private void start(String[] args) {
        final SpringApplication app = new SpringApplication(Application.class);
        app.setBannerMode(Banner.Mode.CONSOLE);
        final Map<String, String> env = System.getenv();
        final String envValue = env.get(BOOKS_DB_PORT_1521_TCP); // "tcp://localhost:1521";
        LOG.debug("BOOKS_DB_PORT_1521_TCP: " + envValue);

        final String dbConnectionURL;
        if (envValue == null) {
            dbConnectionURL = "jdbc:h2:~/test";
        } else {
            dbConnectionURL = "jdbc:h2:" + envValue
                    + "//opt/h2-data/bookdb;DB_CLOSE_ON_EXIT=FALSE";
        }
        LOG.info("DB CONNECTION URL: " + dbConnectionURL);

        final Map<String, Object> config = new HashMap<String, Object>();
        config.put("spring.datasource.url", dbConnectionURL);
        config.put("spring.jpa.hibernate.ddl-auto", "update");
        app.setDefaultProperties(config);
        app.run(args);
    }

    // Lösung wenn WebMvc genutzt wird
    // @Bean
    // public WebMvcConfigurer corsConfigurer() {
    // return new WebMvcConfigurerAdapter() {
    // @Override
    // public void addCorsMappings(CorsRegistry registry) {
    // registry.addMapping("/greeting-javaconfig")
    // .allowedOrigins("http://localhost:9000");
    // }
    // };
    // }

}
