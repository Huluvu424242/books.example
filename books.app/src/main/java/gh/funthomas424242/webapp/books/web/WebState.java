package gh.funthomas424242.webapp.books.web;

/*
 * #%L
 * Books.App - REST Services
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

public class WebState {

	protected WebResource resource;
	protected WebResource[] resources;

	protected String baseURL;
	protected String selfURL;

	protected String newURL;
	protected String printURL;
	protected String nextURL;
	protected String prevURL;

	public WebState(final String baseURL, final String selfURL, final WebResource resource) {
		this.baseURL = baseURL;
		this.selfURL = selfURL;
		this.resource = resource;
		resource.computeAndSetSelfURL(baseURL);
	}

	public WebState(final String baseURL, final String selfURL, final WebResource[] resources) {
		this.baseURL = baseURL;
		this.selfURL = selfURL;
		this.resources = resources;
		for (final WebResource resource : resources) {
			resource.computeAndSetSelfURL(baseURL);
		}
	}

	public WebResource getResource() {
		return this.resource;
	}

	public WebResource[] getResources() {
		return this.resources;
	}

	public String getBaseURL() {
		return this.baseURL;
	}

	public String getSelfURL() {
		return this.selfURL;
	}

	public String getNewURL() {
		return this.newURL;
	}

	public void setNewURL(String newURL) {
		this.newURL = newURL;
	}

	public String getPrintURL() {
		return this.printURL;
	}

	public void setPrintURL(String printURL) {
		this.printURL = printURL;
	}

	public String getNextURL() {
		return this.nextURL;
	}

	public void setNextURL(String nextURL) {
		this.nextURL = nextURL;
	}

	public String getPrevURL() {
		return this.prevURL;
	}

	public void setPrevURL(String prevURL) {
		this.prevURL = prevURL;
	}

}
