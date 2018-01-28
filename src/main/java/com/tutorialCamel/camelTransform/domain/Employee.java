package com.tutorialCamel.camelTransform.domain;

public class Employee {

    String name;
    String id;
    String joinName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJoinName() {
        return joinName;
    }

    public void setJoinName(String joinName) {
        this.joinName = joinName;
    }

    @Override
    public String toString() {
        return "EmployeeWithAddress{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", joinName='" + joinName + '\'' +
                '}';
    }
}
