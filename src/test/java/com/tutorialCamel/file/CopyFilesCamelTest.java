package com.tutorialCamel.file;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

public class CopyFilesCamelTest extends CamelTestSupport{

    @Override
    public RouteBuilder createRouteBuilder() {
        return new CopyFilesRoute();
    }

    @Test
    public void checkFileExistsInOutputDirectory() throws InterruptedException {

        Thread.sleep(5000);

        File file = new File("data/output");

        assertTrue(file.isDirectory());
        System.out.println("Total no of files in the output directory : " + file.listFiles().length);
        assertEquals(2, file.listFiles().length);
    }
}
