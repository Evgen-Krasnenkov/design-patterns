package com.kras.parser;


import com.kras.entity.AbstractTextComponent;
import com.kras.entity.SymbolLeaf;
import com.kras.entity.TextComponentType;

public class WordParser extends AbstractTextParser {
    @Override
    public void parse(AbstractTextComponent parent, String string) {
        for (int i = 0; i < string.length(); i++) {
            var symbolLeaf = new SymbolLeaf(TextComponentType.SYMBOL);
            symbolLeaf.setValue(string.charAt(i));
            parent.add(symbolLeaf);
        }
    }

}
