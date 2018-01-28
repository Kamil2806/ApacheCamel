package com.tutorialCamel.camelTransformBindy.routes.csv;

import java.io.File;

import com.tutorialCamel.camelTransformBindy.domain.Address;
import com.tutorialCamel.camelTransformBindy.domain.EmployeeWithAddress;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class CSVMarshalRouteTest extends CamelTestSupport{

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new CSVMarshalRoute();
    }

    @Test
    public void CSVMarshalTest() throws InterruptedException {

        EmployeeWithAddress employee = new EmployeeWithAddress();
        employee.setId("1");
        employee.setName("Kamil");
        employee.setSurname("Serafin");
        Address address = new Address();
        address.setAddressLine("haba baba 123");
        address.setCity("Menchester");
        address.setCountry("USA");
        address.setState("Nebraska");
        address.setZip("13456");
        employee.setAddress(address);

        template.sendBody("direct:input", employee);

        Thread.sleep(3000);
        File file = new File("data/csv/output/output.txt");
        assertTrue(file.exists());
    }
}
