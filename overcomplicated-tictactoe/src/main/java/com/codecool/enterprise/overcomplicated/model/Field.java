package com.codecool.enterprise.overcomplicated.model;

public enum Field {
    CIRCLE("fa fa-circle-o"),
    X("fa fa-times"),
    EMPTY("");

    private final String value;

    private Field(String s) {
        value = s;
    }

    public String getValue() {
        return value;
    }
}
