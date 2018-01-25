package com.tutorialCamel.camelTransform.route.process;

import com.tutorialCamel.camelTransform.processor.CamelFileExampleProcessor;
import org.apache.camel.builder.RouteBuilder;

public class CamelModifyFileProcessorRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("file:data/input?noop=true")
                .process(new CamelFileExampleProcessor())
                .log("Received message is ${body} and Headers are ${headers}")
                .to("file:data/output?fileName=output.txt")
        .to("mock:output");
    }
}
