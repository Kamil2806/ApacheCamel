package com.tutorialCamel.camelTransformBindy.routes.csv;

import com.tutorialCamel.camelTransformBindy.domain.EmployeeWithAddress;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.spi.DataFormat;

public class CSVUnMarshalRoute extends RouteBuilder{

    public void configure() throws Exception {

        DataFormat bindy = new BindyCsvDataFormat(EmployeeWithAddress.class);

        from("file:data/csv/input?fileName=file-with-adress.txt&noop=true")
                .unmarshal(bindy)
                .log("Unmarshaled body is ${body}")
                .to("direct:output");
    }
}
