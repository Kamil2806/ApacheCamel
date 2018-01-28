package com.tutorialCamel.camelErrorHandlerTest.route;

import com.tutorialCamel.camelErrorHandler.route.onException.OnExceptionHandlerRoute;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class OnExceptionHandlerRouteTest extends CamelTestSupport {

    @Override
    protected RouteBuilder createRouteBuilder() throws Exception {
        return new OnExceptionHandlerRoute();
    }

    @Test(expected = RuntimeException.class)
    public void exceptionCheck_nohandled() {

        String request = null;
        final String response = template.requestBody("direct:exception", request, String.class);
        System.out.println("Response is  : " + response);

    }

    @Test
    public void exceptionCheck_handled_in_processor() {

        String request = null;
        String expected = "Exception happened in the route.";
        final String response = template.requestBody("direct:exception", request, String.class);
        System.out.println("Response is  : " + response);
        assertEquals(expected, response);
    }

    @Test
    public void exceptionCheck_continue() {

        String request = null;
        String expected = null;
        final String response = template.requestBody("direct:exception", request, String.class);
        System.out.println("Response is  : " + response);
        assertEquals(expected, response);
    }
}

