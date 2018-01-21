package com.tutorialCamel.direct;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class SampleMockRouteTest extends CamelTestSupport {

    @Override
    public RouteBuilder createRouteBuilder() throws Exception {
        return new SampleMockRoute();
    }

    @Test
    public void SampleRouteTest() throws InterruptedException {

        String expected = "Hello";

        MockEndpoint mock = getMockEndpoint("mock:output");
        mock.expectedBodiesReceived(expected);

        //Producer template
        template.sendBody("direct:sampleInput", "Hello");

        assertMockEndpointsSatisfied();
    }
}
