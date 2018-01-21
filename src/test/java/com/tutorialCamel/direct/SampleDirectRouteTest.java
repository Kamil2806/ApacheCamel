package com.tutorialCamel.direct;

import org.apache.camel.Exchange;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

public class SampleDirectRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new SampleDirectRoute();
    }

    @Test
    public void SampleRouteTest() throws InterruptedException {

        //Producer template
        template.sendBody("direct:sampleInput", "Hello");

        Thread.sleep(5000);

        File file = new File("sampleOutput");

        assertTrue(file.isDirectory());



        //ConsumerTemplate
        Exchange exchange = consumer.receive("file:sampleOutput");

        System.out.println("Received body is :" + exchange.getIn().getBody());
        System.out.println("File name is :" + exchange.getIn().getHeader("CamelFileName"));

        assertEquals("output.txt", exchange.getIn().getHeader("CamelFileName"));
    }
}
