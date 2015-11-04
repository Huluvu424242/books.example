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

import gh.funthomas424242.webapp.books.domain.Resource;

public class ResourceRepraesentation {

	protected Resource resource;
	protected Resource[] resources;

	protected String baseURL;
	protected String selfURL;

	public ResourceRepraesentation(final String baseURL, final String selfURL, final Resource resource) {
		this.baseURL = baseURL;
		this.selfURL = selfURL;
		this.resource = resource;
		resource.computeAndSetSelfURL(baseURL);
	}

	public ResourceRepraesentation(final String baseURL, final String selfURL, final Resource[] resources) {
		this.baseURL = baseURL;
		this.selfURL = selfURL;
		this.resources = resources;
		for (final Resource resource : resources) {
			resource.computeAndSetSelfURL(baseURL);
		}
	}

	public Resource getResource() {
		return resource;
	}

	public Resource[] getResources() {
		return resources;
	}

	public String getBaseURL() {
		return baseURL;
	}

	public String getSelfURL() {
		return selfURL;
	}

}
