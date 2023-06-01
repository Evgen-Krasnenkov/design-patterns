package com.kras.parser;

import com.kras.entity.AbstractTextComponent;
import com.kras.entity.SymbolLeaf;
import com.kras.entity.TextComponent;
import com.kras.entity.TextComponentType;

public class LexemeParser extends AbstractTextParser {
    private static final String LEXEME_REGEX = "\\s+";
    private static final String WORD_REGEX = "(?<!\\p{L})|(?=\\p{Punct})|(?<=\\p{Punct})";

    @Override
    public void parse(AbstractTextComponent parent, String string) {
        if (parent.getComponentType().equals(TextComponentType.SENTENCE)) {
            String[] lexemes = string.split(LEXEME_REGEX);
            for (String lexeme : lexemes) {
                AbstractTextComponent child = new TextComponent(TextComponentType.WORD);
                parent.add(child);
                this.nextParser.parse(child, lexeme);
            }
        } else {
            String[] words = string.split(WORD_REGEX);
            for (String word : words) {
                AbstractTextComponent child = new TextComponent(TextComponentType.WORD);
                parent.add(child);
                this.nextParser.parse(child, word);
            }

        }
    }
}
