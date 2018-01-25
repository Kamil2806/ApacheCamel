package com.tutorialCamel.camelTransform.route.transform;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class CamelModifyTransformRouteTest extends CamelTestSupport {

    @Override
    public RoutesBuilder createRouteBuilder() {
        return new CamelModifyTransformRoute();
    }

    //test using requestBody() method
    @Test
    public void transformTest() {

        String expected = "kami*serafin*123121";

        String output = (String)template.requestBody("direct:transformInput", "kami,serafin,123121");

        System.out.println("Output: " + output);

        assertEquals(expected, output);
    }

    //test using Mock() method
    @Test
    public void transformUsingMockTest() throws InterruptedException {

        String expected = "kami*serafin*123121";
        MockEndpoint mock = getMockEndpoint("mock:output");
        mock.expectedBodiesReceived(expected);

        String output = (String)template.requestBody("direct:transformInput", "kami,serafin,123121");

        System.out.println("Output: " + output);

        assertMockEndpointsSatisfied();
    }

}
