package gh.funthomas424242.webapp.books.web;

/*
 * #%L
 * Books.App - JBehave Selenium Webdriver Tests
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

import java.util.Arrays;
import java.util.Locale;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.Keywords;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.embedder.EmbedderControls;
import org.jbehave.core.i18n.LocalizedKeywords;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryLoader;
import org.jbehave.core.io.StoryPathResolver;
import org.jbehave.core.io.UnderscoredCamelCaseResolver;
import org.jbehave.core.junit.JUnitStory;
import org.jbehave.core.reporters.FilePrintStreamFactory.ResolveToPackagedName;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.ParameterControls;
import org.jbehave.core.steps.spring.SpringStepsFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

public class AbstractStory extends JUnitStory {

	private static final int STORY_TIMEOUT = 120;

	final static Keywords KEYWORDS_DE = new LocalizedKeywords(Locale.GERMAN);
	final static Keywords KEYWORDS_EN = new LocalizedKeywords(Locale.ENGLISH);

	@Autowired
	private ApplicationContext applicationContext;

	@Override
	public InjectableStepsFactory stepsFactory() {
		return new SpringStepsFactory(configuration(), applicationContext);
	}

	public AbstractStory() {
		Embedder embedder = new Embedder();
		embedder.useEmbedderControls(embedderControls());
		embedder.useMetaFilters(Arrays.asList("-skip"));
		useEmbedder(embedder);
	}

	private EmbedderControls embedderControls() {
		return new EmbedderControls().doIgnoreFailureInView(true)
				.useStoryTimeoutInSecs(STORY_TIMEOUT);
	}

	@Override
	public Configuration configuration() {
		return new MostUsefulConfiguration().useKeywords(KEYWORDS_EN)
				.useStoryPathResolver(storyPathResolver())
				.useStoryLoader(storyLoader())
				.useStoryReporterBuilder(storyReporterBuilder())
				.useParameterControls(parameterControls());
	}

	private StoryPathResolver storyPathResolver() {
		return new UnderscoredCamelCaseResolver();
	}

	private StoryLoader storyLoader() {
		return new LoadFromClasspath();
	}

	private StoryReporterBuilder storyReporterBuilder() {
		return new StoryReporterBuilder()
				.withKeywords(KEYWORDS_DE)
				.withCodeLocation(
						CodeLocations.codeLocationFromClass(this.getClass()))
				.withPathResolver(new ResolveToPackagedName())
				.withFailureTrace(true).withDefaultFormats()
				.withFormats(Format.IDE_CONSOLE,Format.HTML);
	}

	private ParameterControls parameterControls() {
		return new ParameterControls().useDelimiterNamedParameters(true);
	}

}
