//package gh.funthomas424242.webapp.books.web;
//
//
//import static org.springframework.core.annotation.AnnotationUtils.findAnnotation;
////import gh.funthomas424242.webapp.books.lib.MyHtmlUnitDriver;
//import gh.funthomas424242.webapp.books.web.SeleniumTest.LANGUAGE;
//
//import java.util.Locale;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.ConfigurableApplicationContext;
//import org.springframework.core.Ordered;
//import org.springframework.test.context.TestContext;
//import org.springframework.test.context.support.AbstractTestExecutionListener;
//
//import org.apache.http.cookie.CookieAttributeHandler;
//
//public class SeleniumTestExecutionListener extends AbstractTestExecutionListener {
//
//    private WebDriver webDriver;
//
//    public int getOrder() {
//        return Ordered.HIGHEST_PRECEDENCE;
//    }
//
//    @Override
//    public void prepareTestInstance(TestContext testContext) throws Exception {
//        if (webDriver != null) {
//            return;
//        }
//        ApplicationContext context = testContext.getApplicationContext();
//        if (context instanceof ConfigurableApplicationContext) {
//
//            SeleniumTest annotation = findAnnotation(
//                    testContext.getTestClass(), SeleniumTest.class);
//            
////    		final DesiredCapabilities capabilities = DesiredCapabilities
////    				.htmlUnitWithJs();
//            CookieAttributeHandler handler = null;
//    		final MyWebConnectionHtmlUnitDriver newDriver = new MyWebConnectionHtmlUnitDriver();
//    		
//    		
//            if(annotation.lang().equals(LANGUAGE.DEUTSCH)){
//            	newDriver.changeLocaleTo(Locale.GERMAN);
//            }else{
//            	newDriver.changeLocaleTo(Locale.US);
//            }
//            webDriver = newDriver;
//
//            ConfigurableApplicationContext configurableApplicationContext = (ConfigurableApplicationContext) context;
//            ConfigurableListableBeanFactory bf = configurableApplicationContext.getBeanFactory();
//            bf.registerResolvableDependency(WebDriver.class, webDriver);
//        }
//    }
//
//    @Override
//    public void beforeTestMethod(TestContext testContext) throws Exception {
//        if (webDriver != null) {
//            SeleniumTest annotation = findAnnotation(
//                    testContext.getTestClass(), SeleniumTest.class);
//            webDriver.get(annotation.baseUrl());
//        }
//    }
//
//    @Override
//    public void afterTestClass(TestContext testContext) throws Exception {
//        if (webDriver != null) {
//            webDriver.quit();
//        }
//    }
//
//    @Override
//    public void afterTestMethod(TestContext testContext) throws Exception {
//        if (testContext.getTestException() == null) {
//            return;
//        }
//
////        File screenshot = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
////        String testName = testContext.getTestClass().getSimpleName();
////        String methodName = testContext.getTestMethod().getName();
////
////        Files.copy(screenshot.toPath(),
////                Paths.get("screenshots", testName + "_" + methodName + "_" + screenshot.getName()));
//    }
//}
