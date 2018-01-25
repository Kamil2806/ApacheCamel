package com.tutorialCamel.camelTransform.route.xml2json;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.XmlJsonDataFormat;

public class XML2JSONRoute extends RouteBuilder{

    public void configure() throws Exception {

        from("direct:marshalEmployeeXml2Json")
                .to("log:?level=INFO&showBody=true")
                .marshal().xmljson()
                .to("log:?level=INFO&showBody=true");

        final XmlJsonDataFormat xmlJsonDataFormat = new XmlJsonDataFormat();
        xmlJsonDataFormat.setRootName("Employee");

        from("direct:unMarshalEmployeeJson2Xml")
                //.unmarshal().xmljson()
                .unmarshal(xmlJsonDataFormat)
                .to("log:?level=INFO&showBody=true");
    }
}
