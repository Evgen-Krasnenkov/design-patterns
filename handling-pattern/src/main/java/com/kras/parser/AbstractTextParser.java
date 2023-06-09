package com.kras.parser;

import com.kras.entity.AbstractTextComponent;

public abstract class AbstractTextParser {
    protected AbstractTextParser nextParser;

    public AbstractTextParser() {
    }

    public AbstractTextParser(AbstractTextParser nextParser) {
        this.nextParser = nextParser;
    }


    public abstract void parse(AbstractTextComponent abstractTextComponent, String string);

    protected void setNextParser(AbstractTextParser nextParser) {
        this.nextParser = nextParser;
    }
}
