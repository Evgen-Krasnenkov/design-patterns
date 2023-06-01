package com.kras;

import java.util.ArrayList;
import java.util.List;

public class CompoundShape implements Shape {
    public int getId() {
        return id;
    }

    public int id;
    public List<Shape> children = new ArrayList<>();

    public CompoundShape(int id) {
        this.id = id;
    }

    @Override
    public void move(int x, int y) {

    }

    @Override
    public void draw() {

    }

    @Override
    public String accept(Visitor visitor) {
        return visitor.visitCompoundShape(this);
    }

    public void add(Shape shape){
        this.children.add(shape);
    }
}
