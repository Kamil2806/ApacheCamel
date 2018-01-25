package com.tutorialCamel.camelTransform.route.process;

import org.apache.camel.RoutesBuilder;
import java.io.File;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class camelModifyFileProcessorRouteTest extends CamelTestSupport{

    @Override
    public RoutesBuilder createRouteBuilder() throws Exception {
        return new CamelModifyFileProcessorRoute();
    }

    @Test
    public void processorTest() throws InterruptedException {

        String expectedValue = "123:159:561\n" +
                "kamil:csdas:asdsad:sadasds\n";

        MockEndpoint mock = getMockEndpoint("mock:output");
        mock.expectedBodiesReceived(expectedValue);

        Thread.sleep(5000);

        File file = new File("data/output");

        assertTrue(file.isDirectory());

        assertEquals(1, file.listFiles().length);

        assertMockEndpointsSatisfied();
    }
}
