package com.tutorialCamel.camelTransform.route.process;

import com.tutorialCamel.camelTransform.processor.CamelDirectExampleProcessor;
import org.apache.camel.builder.RouteBuilder;

public class CamelModifyDirectProcessorRoute extends RouteBuilder{

    @Override
    public void configure() throws Exception {
        from("direct:processInput")
                .log("Received message is ${body} and headers are ${headers}")
                .process(new CamelDirectExampleProcessor())
                .log("Received message is ${body} and headers are ${headers}")
                //.to("file:data/output?fileName=output.txt")
                .to("mock:output");
    }
}
