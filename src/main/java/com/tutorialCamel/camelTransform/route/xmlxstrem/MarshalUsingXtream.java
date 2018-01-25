package com.tutorialCamel.camelTransform.route.xmlxstrem;

import com.tutorialCamel.camelTransform.domain.Employee;
import com.tutorialCamel.camelTransform.processor.CustomProcessorXstream;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.XStreamDataFormat;

import java.util.HashMap;
import java.util.Map;

public class MarshalUsingXtream  extends RouteBuilder{

    @Override
    public void configure() throws Exception{
        from("direct:csvInput")
                .process(new CustomProcessorXstream())
                .marshal(populateStreamDef())
                .to("log:?level=INFO&showBody=true")
                .to("mock:output");
    }

    private XStreamDataFormat populateStreamDef() {

        XStreamDataFormat xStreamDataFormat = new XStreamDataFormat();

        Map<String,String> aliases = new HashMap<String, String>();

        aliases.put("employee", Employee.class.getName());

        xStreamDataFormat.setAliases(aliases);

        return xStreamDataFormat;
    }
}
