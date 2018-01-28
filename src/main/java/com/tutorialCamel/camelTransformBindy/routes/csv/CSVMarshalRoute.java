package com.tutorialCamel.camelTransformBindy.routes.csv;

import com.tutorialCamel.camelTransformBindy.domain.EmployeeWithAddress;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.spi.DataFormat;

public class CSVMarshalRoute extends RouteBuilder {

    public void configure() throws Exception {

        DataFormat bindy = new BindyCsvDataFormat(EmployeeWithAddress.class);

        from("direct:input")
                .marshal(bindy)
                .log("Marshal body is ${body} and headers are ${headers}")
                .to("file:data/csv/output?fileName=output.txt");
    }
}
