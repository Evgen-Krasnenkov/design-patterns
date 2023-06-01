# Handling task. (Task combines Composite and Chain of responsibility design patterns )

1. The sentence should be parsed into an object. This object should be a tree containing lexemes which should contain
   symbols. The lexeme is either word. Use Composite pattern.  
   You should extend the AbstractTextComponent class and implement methods for the TextComponent and SymbolLeaf classes.
   They are in the com.kras.entity package. You have an enum TextComponentType for all needed text component
   types.
   Use UnsupportedOperationException where appropriate.
2. Use regular expression to parse the text.
   Use Chain of Responsibility when parsing the sentences.  
   You should extend the AbstractTextParser class and implement methods for the LexemeParser and WordParser, also you
   have to create logic of appropriate methods in the ChainParserBuilder class. All needed classes are in the
   com.kras.parser package.

Sentence for task lays in resources/data/textdata.txt file.
Also you have some util packages reader and validator, they are only for reading data from a file. Do nothing with them.
