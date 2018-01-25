package com.tutorialCamel.camelTransform.processor;

import org.apache.camel.Exchange;
import org.apache.camel.component.file.GenericFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class CamelFileExampleProcessor implements org.apache.camel.Processor {

    public void process(Exchange exchange) throws Exception {

        System.out.println("Exchange in Processor is: " + exchange.getIn().getBody());

        String readLine = null;
        String newValue = "";

        GenericFile<File> file = (GenericFile<File>) exchange.getIn().getBody();

        if(file != null) {

            FileReader file1 = new FileReader(file.getFile());
            BufferedReader reader = new BufferedReader(file1);

            while((readLine = reader.readLine()) != null) {

                System.out.println("Read line is: " + readLine);

                String oldValue = readLine;

                System.out.println("Old value is: " + oldValue);

                newValue = newValue.concat(oldValue.replace(",",":")).concat("\n");

                System.out.println("New value is: " + newValue);

                exchange.getIn().setBody(newValue);
            }
        }
    }
}
