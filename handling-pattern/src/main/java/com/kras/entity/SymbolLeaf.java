package com.kras.entity;

public class SymbolLeaf extends AbstractTextComponent {

    private char value;

    public void setValue(char value) {
        this.value = value;
    }

    public SymbolLeaf(TextComponentType componentType) {
        super(componentType);
    }

    @Override
    public String operation() {
        return String.valueOf(value);
    }

    @Override
    public void add(AbstractTextComponent textComponent) {
    }

    @Override
    public void remove(AbstractTextComponent textComponent) {

    }

    @Override
    public int getSize() {
        return 1;
    }

    @Override
    public String toString() {
        return " = " + value + " ";
    }
}
