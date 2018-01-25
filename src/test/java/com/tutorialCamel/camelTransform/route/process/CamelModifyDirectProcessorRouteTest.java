package com.tutorialCamel.camelTransform.route.process;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class CamelModifyDirectProcessorRouteTest extends CamelTestSupport{

    @Override
    public RoutesBuilder createRouteBuilder() throws Exception {

        return new CamelModifyDirectProcessorRoute();
    }


    //In this case is using requestBody() method
    @Test
    public void processorTest() {

        String expected = "kamil:serafin:28.06.1995";

        String output = (String) template.requestBody("direct:processInput", "kamil,serafin,28.06.1995");

        System.out.println("Output: " + output);
        assertEquals(expected, output);
    }

    //in this case is using mock() method
    @Test
    public void processorTestUsingMock() throws InterruptedException {

        String expected = "kamil:serafin:28.06.1995";
        MockEndpoint mock = getMockEndpoint("mock:output");
        mock.expectedBodiesReceived(expected);

        String output = (String)template.requestBody("direct:processInput", "kamil,serafin,28.06.1995");

        System.out.println("Output:" + output);
        assertMockEndpointsSatisfied();
    }
}
