package com.tutorialCamel.camelTransform.bean;

public class CamelBean {

    public String map1(String input) {

        String newBody = input.replace(",","*");

        return newBody;
    }

    public String map2(String input) {

        String newBody = input.replace(",","~");

        return newBody;
    }
}
