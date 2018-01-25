package com.tutorialCamel.camelTransform.route.gson;

import com.tutorialCamel.camelTransform.domain.Student;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.gson.GsonDataFormat;

public class MarshalUsingGson extends RouteBuilder {

    public void configure() throws Exception {

        GsonDataFormat gsonDataFormat = new GsonDataFormat(Student.class);

        from("direct:gsonInput")
                .log("Received message is ${body} and headers are ${headers}")
                .marshal(gsonDataFormat)
                .log("Received message is ${body} and headers are ${headers}");
    }
}
