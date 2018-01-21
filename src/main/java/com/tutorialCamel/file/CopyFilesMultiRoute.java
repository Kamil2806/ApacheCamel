package com.tutorialCamel.file;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class CopyFilesMultiRoute {

    public static void main(String[] args) {

        CamelContext context = new DefaultCamelContext();

        try{
            context.addRoutes(new RouteBuilder() {
                @Override
                public void configure() throws Exception {
                    from("file:data/input?noop=true")
                            .log("Received Message is ${body} and Headers are ${headers}")
                            .to("file:data/output")
                            .to("file:data/anotherDestination");

                    from("file:data/input1?noop=true")
                            .to("file:data/nextOutput");
                }
            });

            context.start();
            Thread.sleep(5000);
            context.stop();

        } catch (Exception e) {
            System.out.println("Inside Exception " +e);
        }
    }
}
