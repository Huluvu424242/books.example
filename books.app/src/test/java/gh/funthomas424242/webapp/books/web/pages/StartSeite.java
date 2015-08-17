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

import gh.funthomas424242.webapp.books.domain.Book;
import gh.funthomas424242.webapp.books.domain.ISBN;
import gh.funthomas424242.webapp.books.domain.InvalidISBNException;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class StartSeite extends SeleniumPage {

	public static final String SERVER_URL = "http://localhost:";

	//@Value("${local.server.port}")
	protected int serverPort = 8080;

	@Override
	public String getPageUrl() {
		return SERVER_URL + serverPort + "/books";
	}

	@FindBy(id = "erfasseBuch")
	WebElement buttonErfasseBuch;

	public void pressButtonErfasseBuch() {
		buttonErfasseBuch.click();
	}

	@FindBy(tagName="h1")
	WebElement ueberschrift;
	
	public String getUeberschrift(){
		return ueberschrift.getText();
	}
	
	@FindBys({ @FindBy(tagName = "tr"),@FindBy(tagName = "th") })
	protected List<WebElement> spaltenKoepfe;
	
	public Object getSpaltennamenDerTabelle() {
		final List<String> spaltenNamen=new ArrayList<String>();
		for(final WebElement element:spaltenKoepfe){
			spaltenNamen.add(element.getText());
		}
		return spaltenNamen;
	}
	
	@FindBys({ @FindBy(tagName = "tbody"),@FindBy(tagName = "tr") })
	List<WebElement> buchListe;

	public int getBuchanzahl() {
		if (buchListe != null) {
			return buchListe.size();
		} else {
			return -1;
		}
	}

	public List<Book> getBuchliste() {
		final List<Book> buecher = new ArrayList<Book>();
		for (final WebElement element : buchListe) {
			System.out.println("TR: " + element.getText());
						final List<WebElement> children = element.findElements(By
					.tagName("td"));
			//header
			if(children.size()<1){
				continue;
			}
			final String titel = children.get(1).getText();
			final String isbnRaw = children.get(2).getText();
			try {
				final ISBN isbn = ISBN.parseFromString(isbnRaw);
				final Book buch = new Book(titel, isbn);
				buecher.add(buch);
			} catch (InvalidISBNException e) {
				e.printStackTrace();
			}
		}
		return buecher;
	}


}
