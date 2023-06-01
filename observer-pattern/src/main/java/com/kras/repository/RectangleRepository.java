package com.kras.repository;

import com.kras.entity.Rectangle;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ToString
public class RectangleRepository {
    private static RectangleRepository instance;
    private final List<Rectangle> rectangles;

    private RectangleRepository() {
        rectangles = new ArrayList<>();
    }

    public static RectangleRepository getInstance() {
        if (instance == null) {
            instance = new RectangleRepository();
        }
        return instance;
    }

    public boolean add(Rectangle rectangle) {
        return rectangles.add(rectangle);
    }

    public boolean remove(Rectangle rectangle) {
        return rectangles.remove(rectangle);
    }

    public Rectangle getRectangle(int index) {
        return rectangles.get(index);
    }

    public List<Rectangle> getRectangles() {
        return Collections.unmodifiableList(rectangles);
    }
}
