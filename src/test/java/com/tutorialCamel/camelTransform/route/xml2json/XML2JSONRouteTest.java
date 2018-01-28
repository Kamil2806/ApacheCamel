package com.tutorialCamel.camelTransform.route.xml2json;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class XML2JSONRouteTest extends CamelTestSupport{

    @Override
    public RoutesBuilder createRouteBuilder() {
        return new XML2JSONRoute();
    }


    @Test
    public void xml2jsonTest(){

        String expected = "{\"name\":\"kamil\",\"id\":\"123\",\"joinName\":\"12.01.2018\"}";
        String response = template.requestBody("direct:marshalEmployeeXml2Json", "<?xml version='1.0' encoding='UTF-8'?><employee><name>kamil</name><id>123</id><joinName>12.01.2018</joinName></employee>", String.class);

        assertEquals(expected, response);
    }

    @Test
    public void json2xmlTest(){

        String expected = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" +
                "<EmployeeWithAddress><id>123</id><joinName>12.01.2018</joinName><name>kamil</name></EmployeeWithAddress>\r\n";
        String response = template.requestBody("direct:unMarshalEmployeeJson2Xml", "{\"name\":\"kamil\",\"id\":\"123\",\"joinName\":\"12.01.2018\"}", String.class);

        System.out.println("***respone****: " + response);
        assertEquals(expected, response);
    }
}
