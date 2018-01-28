package com.tutorialCamel.camelTransformBindy.routes.fixedLength;

import com.tutorialCamel.camelTransformBindy.domain.EmployeeWithFixedLength;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;
import java.io.File;

import java.math.BigDecimal;
import java.time.LocalDate;

public class FixedPositionMarshalRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new FixedPositionMarshalRoute();
    }

    @Test
    public void FixedLengthMarshalTest() throws InterruptedException {

        EmployeeWithFixedLength employee = new EmployeeWithFixedLength();
        employee.setAge(30);
        employee.setId(1);
        employee.setJoinDate(LocalDate.now());
        employee.setName("Kamil");
        employee.setRole("Develope");
        employee.setSalary(new BigDecimal("10000.00"));

        template.sendBody("direct:input", employee);

        Thread.sleep(5000);

        File file = new File("data/fixedLength/output");
        assertTrue(file.isDirectory());
    }
}
