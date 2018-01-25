package com.tutorialCamel.camelSampleFIle.file;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class CopyFilesCamelLogging {

    public static void main(String[] args) {

        CamelContext context = new DefaultCamelContext();

        try{
            context.addRoutes(new RouteBuilder() {
                @Override
                public void configure() throws Exception {
                    from("input.txt:data/input?noop=true")
                            .to("log:?level=INFO&showBody=true&showHeaders=true")
                            .log("Received message is ${body} and Headers are ${headers}")
                            .to("input.txt:data/output");
                }
            });

            context.start();
            Thread.sleep(5000);
            context.stop();

        } catch(Exception e) {
            System.out.println("Inside Exception " + e);
        }
    }
}
