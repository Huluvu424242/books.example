package gh.funthomas424242.webapp.books.web;

import static org.springframework.test.context.TestExecutionListeners.MergeMode.MERGE_WITH_DEFAULTS;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.test.context.TestExecutionListeners;

@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@TestExecutionListeners(listeners = SeleniumTestExecutionListener.class, mergeMode = MERGE_WITH_DEFAULTS)
public @interface SeleniumTest {

	public enum LANGUAGE {
		DEUTSCH , ENGLISH
	}
	
	LANGUAGE lang() default LANGUAGE.ENGLISH;

	String baseUrl() default "http://localhost:8080";
}