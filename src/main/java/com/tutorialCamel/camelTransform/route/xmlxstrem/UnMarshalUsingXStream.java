package com.tutorialCamel.camelTransform.route.xmlxstrem;

import com.tutorialCamel.camelTransform.domain.Employee;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.XStreamDataFormat;

import java.util.HashMap;
import java.util.Map;

public class UnMarshalUsingXStream extends RouteBuilder {

    public void configure() throws Exception {

        XStreamDataFormat xStreamDataFormat = new XStreamDataFormat();

        Map<String,String> aliases = new HashMap<String, String>();
        aliases.put("employee", Employee.class.getName());

        xStreamDataFormat.setAliases(aliases);
        xStreamDataFormat.setPermissions(Employee.class.getName());

        from("direct:xmlInput")
                .unmarshal(xStreamDataFormat)
                .to("log:?level=INFO&showBody=true")
                .to("mock:output");
    }
}
