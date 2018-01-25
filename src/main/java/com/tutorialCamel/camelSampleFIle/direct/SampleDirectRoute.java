package com.tutorialCamel.camelSampleFIle.direct;

import org.apache.camel.builder.RouteBuilder;

public class SampleDirectRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("direct:sampleInput")
                .log("Received message is ${body} and headers are ${headers}")
        .to("input.txt:sampleOutput?fileName=output.txt");
    }
}
