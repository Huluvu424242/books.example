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


import static org.springframework.core.annotation.AnnotationUtils.findAnnotation;
//import gh.funthomas424242.webapp.books.lib.MyHtmlUnitDriver;
import gh.funthomas424242.webapp.books.web.SeleniumTest.LANGUAGE;

import java.util.Locale;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.support.AbstractTestExecutionListener;

public class SeleniumTestExecutionListener extends AbstractTestExecutionListener {

    private WebDriver webDriver;

    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }

    @Override
    public void prepareTestInstance(TestContext testContext) throws Exception {
        if (webDriver != null) {
            return;
        }
        ApplicationContext context = testContext.getApplicationContext();
        if (context instanceof ConfigurableApplicationContext) {

            SeleniumTest annotation = findAnnotation(
                    testContext.getTestClass(), SeleniumTest.class);
            
//    		final DesiredCapabilities capabilities = DesiredCapabilities
//    				.htmlUnitWithJs();
    		final MyWebConnectionHtmlUnitDriver newDriver = new MyWebConnectionHtmlUnitDriver();
    		
    		
            if(annotation.lang().equals(LANGUAGE.DEUTSCH)){
            	newDriver.changeLocaleTo(Locale.GERMAN);
            }else{
            	newDriver.changeLocaleTo(Locale.US);
            }
            webDriver = newDriver;

            ConfigurableApplicationContext configurableApplicationContext = (ConfigurableApplicationContext) context;
            ConfigurableListableBeanFactory bf = configurableApplicationContext.getBeanFactory();
            bf.registerResolvableDependency(WebDriver.class, webDriver);
        }
    }

    @Override
    public void beforeTestMethod(TestContext testContext) throws Exception {
        if (webDriver != null) {
            SeleniumTest annotation = findAnnotation(
                    testContext.getTestClass(), SeleniumTest.class);
            webDriver.get(annotation.baseUrl());
        }
    }

    @Override
    public void afterTestClass(TestContext testContext) throws Exception {
        if (webDriver != null) {
            webDriver.quit();
        }
    }

    @Override
    public void afterTestMethod(TestContext testContext) throws Exception {
        if (testContext.getTestException() == null) {
            return;
        }

//        File screenshot = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
//        String testName = testContext.getTestClass().getSimpleName();
//        String methodName = testContext.getTestMethod().getName();
//
//        Files.copy(screenshot.toPath(),
//                Paths.get("screenshots", testName + "_" + methodName + "_" + screenshot.getName()));
    }
}
