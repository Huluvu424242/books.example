package gh.funthomas424242.webapp.books.jbehave;

import java.util.Arrays;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.embedder.EmbedderControls;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryLoader;
import org.jbehave.core.io.StoryPathResolver;
import org.jbehave.core.io.UnderscoredCamelCaseResolver;
import org.jbehave.core.junit.JUnitStory;
import org.jbehave.core.reporters.FilePrintStreamFactory.ResolveToPackagedName;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.ParameterControls;
import org.jbehave.core.steps.spring.SpringStepsFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

public class AbstractSpringJBehaveStory extends JUnitStory {

	private static final int STORY_TIMEOUT = 120;

	@Autowired
	private ApplicationContext applicationContext;

	
	@Override
	public InjectableStepsFactory stepsFactory() {
		return new SpringStepsFactory(configuration(), applicationContext);
	}

	public AbstractSpringJBehaveStory() {
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
		return new MostUsefulConfiguration()
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
				.withCodeLocation(
						CodeLocations.codeLocationFromClass(this.getClass()))
				.withPathResolver(new ResolveToPackagedName())
				.withFailureTrace(true)
				.withDefaultFormats()
				.withFormats(StoryReporterBuilder.Format.IDE_CONSOLE,
						StoryReporterBuilder.Format.TXT,
						StoryReporterBuilder.Format.HTML);
	}

	private ParameterControls parameterControls() {
		return new ParameterControls().useDelimiterNamedParameters(true);
	}

}
