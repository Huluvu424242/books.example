package gh.funthomas424242.webapp.books.web;

/*
 * #%L
 * Books.App - Selenium Webdriver Tests
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

import java.util.Locale;

import org.openqa.selenium.Capabilities;
import org.springframework.test.web.servlet.htmlunit.webdriver.WebConnectionHtmlUnitDriver;

import com.gargoylesoftware.htmlunit.WebClient;




public class MyWebConnectionHtmlUnitDriver extends WebConnectionHtmlUnitDriver {
	
	public MyWebConnectionHtmlUnitDriver(){
		super(true);
	}
	
	public MyWebConnectionHtmlUnitDriver(final Capabilities capabilities){
		super(capabilities);
	}
	
	public void changeLocaleTo(final Locale locale){
		final WebClient client = getWebClient();
		final String language=locale.getLanguage();
		client.addRequestHeader("Accept-Language" , language);
	}

	

}
