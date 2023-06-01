package com.kras.reader;


import com.kras.exception.HandlingException;

public interface DataReader {
    String readFile(String path) throws HandlingException;

}
