package com.tutorialCamel.camelTransformBindy.routes.fixedLength;

import com.tutorialCamel.camelTransformBindy.domain.EmployeeWithFixedLength;
import com.tutorialCamel.camelTransformBindy.routes.fixedLength.FixedPositionUnMarshalRouteDelimiterSalaryDate;
import org.apache.camel.Exchange;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class FixedPositionUnMarshalRouteDelimiterSalaryDateTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {

        return new FixedPositionUnMarshalRouteDelimiterSalaryDate();
    }

    @Test
    public void fixedPositionTest() throws InterruptedException {

        Exchange exchange = consumer.receive("direct:output");
        Thread.sleep(5000);
        List<EmployeeWithFixedLength> employeeWithFixedLengths = (List<EmployeeWithFixedLength>) exchange.getIn().getBody();

        System.out.println(employeeWithFixedLengths);
        assertNotNull(employeeWithFixedLengths);
        assertEquals("dilip", employeeWithFixedLengths.get(0).getName().trim());
        assertEquals(30, employeeWithFixedLengths.get(0).getAge());
        BigDecimal salaryExpected = new BigDecimal("100000.00");
        assertEquals(salaryExpected, employeeWithFixedLengths.get(0).getSalary());
        LocalDate dateExpected = LocalDate.of(2017,01,12);
        assertEquals(dateExpected.getYear(), employeeWithFixedLengths.get(0).getJoinDate().getYear());
    }
}
