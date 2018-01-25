package com.tutorialCamel.camelTransform.route.gson;

import com.tutorialCamel.camelTransform.domain.Student;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class MarshalUsingGsonTest extends CamelTestSupport{

    @Override
    public RoutesBuilder createRouteBuilder() {
        return new MarshalUsingGson();
    }

    @Test
    public void marshalUsingGsonTest() {

        String expected = "{\"id\":1,\"name\":\"Kamil\",\"phoneNumber\":\"123-789-159\"}";

        Student student = new Student();
        student.setId(1);
        student.setName("Kamil");
        student.setPhoneNumber("123-789-159");

        String output = template.requestBody("direct:gsonInput", student, String.class);

        assertEquals(expected, output);
    }
}
