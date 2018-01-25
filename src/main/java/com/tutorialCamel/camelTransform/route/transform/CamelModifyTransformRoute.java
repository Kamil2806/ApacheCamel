package com.tutorialCamel.camelTransform.route.transform;

import org.apache.camel.builder.RouteBuilder;

public class CamelModifyTransformRoute extends RouteBuilder {

    public void configure() throws Exception {

        from("direct:transformInput")
                .transform(body().regexReplaceAll(",","*"))
                .to("mock:output");
    }
}
