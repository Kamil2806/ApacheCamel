package com.tutorialCamel.camelTransform.route.xmlxstream;

import com.tutorialCamel.camelTransform.route.xmlxstrem.MarshalUsingXtream;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class MarshalUsingXtreamTest extends CamelTestSupport {

    public RoutesBuilder createRouteBuilder() {
        return new MarshalUsingXtream();
    }

    @Test
    public void marshalXstreamTest() throws InterruptedException {

        String expected = "<?xml version='1.0' encoding='UTF-8'?><employee><name>kamil</name><id>123</id><joinName>12.01.2018</joinName></employee>";

        MockEndpoint mock = getMockEndpoint("mock:output");
        mock.expectedBodiesReceived(expected);

        template.requestBody("direct:csvInput", "123,12.01.2018,kamil");

        assertMockEndpointsSatisfied();
    }
}
