package gh.funthomas424242.webapp.books.web;

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

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class DashBoardController {

	public DashBoardController() {

	}
	
	// Bücher: ->BookController
	
	@RequestMapping({ "/" })
	public ModelAndView listeBuecher() {
		return new ModelAndView("redirect:/books");
	}


	@RequestMapping("${link.settings}")
	public ModelAndView zeigeEinstellungen() {
		return new ModelAndView("einstellungen");
	}

	@RequestMapping("${link.user}")
	public ModelAndView zeigeNutzerdaten() {
		return new ModelAndView("user");
	}

	@RequestMapping("${link.impressum}")
	public ModelAndView zeigeImpressum() {
		return new ModelAndView("impressum");
	}

}
