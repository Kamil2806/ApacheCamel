package com.tutorialCamel.camelTransform.route.xmlxstream;

import com.tutorialCamel.camelTransform.domain.Employee;
import com.tutorialCamel.camelTransform.route.xmlxstrem.MarshalUsingXtream;
import com.tutorialCamel.camelTransform.route.xmlxstrem.UnMarshalUsingXStream;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class UnMarshalUsingXStreamTest extends CamelTestSupport {

    public RoutesBuilder createRouteBuilder() {
        return new UnMarshalUsingXStream();
    }

    @Test
    public void unMarshalXStreamTest() throws InterruptedException {

        //String expected = "EmployeeWithAddress{name='kamil', id='123', joinName='12.01.2018'}";
        Employee employee = new Employee();
        employee.setName("kamil");
        employee.setJoinName("12.01.2018");
        employee.setId("123");

        MockEndpoint mock = getMockEndpoint("mock:output");
        mock.expectedBodiesReceived(employee.toString());

        template.requestBody("direct:xmlInput", "<?xml version='1.0' encoding='UTF-8'?><employee><name>kamil</name><id>123</id><joinName>12.01.2018</joinName></employee>");

        assertMockEndpointsSatisfied();
    }
}
