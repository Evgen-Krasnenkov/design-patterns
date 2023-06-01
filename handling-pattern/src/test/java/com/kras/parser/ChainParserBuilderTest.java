package com.kras.parser;

import com.kras.entity.AbstractTextComponent;
import com.kras.entity.TextComponent;
import com.kras.entity.TextComponentType;
import com.kras.exception.HandlingException;
import com.kras.reader.DataReader;
import com.kras.reader.impl.DataReaderImpl;
import com.kras.validator.FileValidator;
import com.kras.validator.impl.FileValidatorImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ChainParserBuilderTest {
    public static final String TXT = "src/main/resources/data/textdata.txt";
    private FileValidator fileValidator;
    private DataReader dataReader;
    private String text;

    @BeforeEach
    void setUp() {
        fileValidator = new FileValidatorImpl();
        dataReader = new DataReaderImpl();
    }

    @Test
    void testChainBuilder() throws HandlingException {
        AbstractTextParser chain = new ChainParserBuilder()
                .setParser(new LexemeParser())
                .setParser(new LexemeParser())
                .setParser(new WordParser())
                .build();
        boolean isPathExists = fileValidator.validateFilePath(TXT);
        if (isPathExists) {
            this.text = dataReader.readFile(TXT);
        } else {
            throw new HandlingException("Either file or path has problems");
        }
        AbstractTextComponent textComponent = new TextComponent(TextComponentType.SENTENCE);
        chain.parse(textComponent, text);
        String composed = textComponent.operation();
        Assertions.assertEquals(text, composed + System.lineSeparator());
    }

}