package com.kras.entity;

public enum TextComponentType {
    SENTENCE(" "),
    WORD(""),
    SYMBOL("");

    private final String delimiter;

    TextComponentType(String delimiter) {
        this.delimiter = delimiter;
    }

    public String getDelimiter() {
        return delimiter;
    }
}
