package com.tutorialCamel.camelTransformBindy.routes.fixedLength;

import com.tutorialCamel.camelTransformBindy.domain.EmployeeWithFixedLength;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.fixed.BindyFixedLengthDataFormat;
import org.apache.camel.spi.DataFormat;

public class FixedPositionUnMarshalRouteDelimiterSalaryDate extends RouteBuilder{

    public void configure() throws Exception {

        DataFormat bindy = new BindyFixedLengthDataFormat(EmployeeWithFixedLength.class);

        from("file:data/fixedLength/input?fileName=input.txt&noop=true")
                .unmarshal(bindy)
                .log("UnMarshaled message is ${body} and headers are ${headers}")
                .to("direct:output");
    }
}
