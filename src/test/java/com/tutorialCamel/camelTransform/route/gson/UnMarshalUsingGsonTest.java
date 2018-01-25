package com.tutorialCamel.camelTransform.route.gson;

import com.tutorialCamel.camelTransform.domain.Student;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class UnMarshalUsingGsonTest extends CamelTestSupport{

    @Override
    public RoutesBuilder createRouteBuilder() {
        return new UnMarshalUsingGson();
    }

    @Test
    public void unMarshalUsingGsonTest() {

        String expected = "Student{id='1', name='Kamil', phoneNumber='123-789-159'}";
        String input = "{\"id\":1,\"name\":\"Kamil\",\"phoneNumber\":\"123-789-159\"}";

        String output = template.requestBody("direct:gsonInput", input, String.class);

        assertEquals(expected, output);
    }
}
