package com.kras;

public class Circle extends Dot {
    private int radius;

    public Circle(int id, int x, int y, int radius) {
        super(id, x, y);
        this.radius = radius;
    }

    @Override
    public String accept(Visitor visitor) {
        return super.accept(visitor);
    }

    public int getRadius() {
        return radius;
    }
}
