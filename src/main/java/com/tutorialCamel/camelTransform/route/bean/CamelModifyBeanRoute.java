package com.tutorialCamel.camelTransform.route.bean;

import com.tutorialCamel.camelTransform.bean.CamelBean;
import org.apache.camel.builder.RouteBuilder;

public class CamelModifyBeanRoute extends RouteBuilder{

    @Override

    public void configure() throws Exception {
        from("direct:beanInput")
                .bean(new CamelBean(), "map2")
                .log("Received message is ${body} and headers are ${headers}")
                .to("mock:output");
    }
}
