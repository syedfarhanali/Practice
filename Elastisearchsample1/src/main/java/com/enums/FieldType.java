package com.enums;

/**
 * Created by farhans on 04/09/16.
 */
public enum FieldType {
   STRING("string"),
   BOOLEAN("boolean"),
    LONG("long"),
    DATE("date"),
    DOUBLE("double");

    private String type;

    FieldType(String type) {
        this.type=type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}


