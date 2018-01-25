package com.tutorialCamel.camelSampleFIle.file;

import org.apache.camel.builder.RouteBuilder;

public class CopyFilesRoute extends RouteBuilder {

    public void configure() throws Exception {
        from("input.txt:data/input?noop=true")
                .to("input.txt:data/output");
    }
}
