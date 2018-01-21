package com.tutorialCamel.file;

import java.io.*;

public class CopyFIlesWithoutCamel {

    public static void main(String[] args) throws IOException {

        File inputDirectory = new File("data/input");
        File outputDirectory = new File("data/output");

        outputDirectory.mkdir();

        File[] files = inputDirectory.listFiles();

        for (File source : files) {
            if(source.isFile()) {
                File dest = new File(
                        outputDirectory.getPath()
                                + File.separator
                                + source.getName());

                OutputStream oStream = new FileOutputStream(dest);
                byte[] buffer = new byte[(int) source.length()];
                FileInputStream iStream = new FileInputStream(source);
                iStream.read(buffer);
                try{
                    oStream.write(buffer);
                } finally {
                    oStream.close();
                    iStream.close();
                }
            }
        }

    }
}
