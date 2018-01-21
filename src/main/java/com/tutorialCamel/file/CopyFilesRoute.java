package com.tutorialCamel.file;

import org.apache.camel.builder.RouteBuilder;

public class CopyFilesRoute extends RouteBuilder {

    public void configure() throws Exception {
        from("file:data/input?noop=true")
                .to("file:data/output");
    }
}
