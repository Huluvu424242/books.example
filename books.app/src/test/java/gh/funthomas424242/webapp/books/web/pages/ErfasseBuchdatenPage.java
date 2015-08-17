package gh.funthomas424242.webapp.books.web.pages;

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

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ErfasseBuchdatenPage extends SeleniumPage {
	
	@Override
	public String getPageUrl() {
		return "http://localhost:8080/book/add";
	}
	
	
	@FindBy(id = "registriereBuch")
	WebElement buttonRegistriereBuch;

	public void pressButtonRegistriereBuch() {
		buttonRegistriereBuch.click();
	}

	
	@FindBy(id="titel")
	protected WebElement inputTitel;
	
	@FindBy(id="isbn")
	protected WebElement inputISBN;
	
	public void setTitel(final String titel){
		inputTitel.sendKeys(titel);
	}

	
	public void setISBN(final String isbn){
		inputISBN.sendKeys(isbn);
	}

}
