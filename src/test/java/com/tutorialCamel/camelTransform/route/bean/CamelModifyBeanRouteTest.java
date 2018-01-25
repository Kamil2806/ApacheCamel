package com.tutorialCamel.camelTransform.route.bean;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class CamelModifyBeanRouteTest extends CamelTestSupport {

    @Override
    public RoutesBuilder createRouteBuilder() {
        return new CamelModifyBeanRoute();
    }

    @Test
    public void beanRouteTest() {

        String expected = "kamil~ser~2011";

        String output = (String)template.requestBody("direct:beanInput", "kamil,ser,2011");

        System.out.println("Output: " + output);

        assertEquals(expected, output);
    }
}
