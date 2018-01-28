package com.tutorialCamel.camelTransformBindy.routes.csv;

import com.tutorialCamel.camelTransformBindy.domain.EmployeeWithAddress;
import org.apache.camel.Exchange;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class CSVUnMarshalRouteTest extends CamelTestSupport {

    @Override
    public RoutesBuilder createRouteBuilder() {
        return new CSVUnMarshalRoute();
    }

    @Test
    public void csvUmMarshalTest() {

        Exchange exchange = consumer.receive("direct:output");

        EmployeeWithAddress employeeWithAddress = (EmployeeWithAddress) exchange.getIn().getBody();

        System.out.println(employeeWithAddress);

        assertEquals("USA", employeeWithAddress.getAddress().getCountry());
    }
}
