package com.tutorialCamel.camelErrorHandlerTest.route;

import com.tutorialCamel.camelErrorHandler.route.defaultErrorHandler.DefaultErrorHandlerRoute;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class defaultErrorHandlerTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new DefaultErrorHandlerRoute();
    }

    @Test(expected = RuntimeException.class)
    public void exceptionCheck() throws InterruptedException {

        String exceptedOutput = "123*dilip*12Jan17";
        String input = null;

        String output = template.requestBody("direct:exception", input, String.class);

        assertEquals(exceptedOutput, output);
    }
}
