package com.kras.impl;

import com.kras.Observer;
import com.kras.entity.Rectangle;
import com.kras.entity.RectangleValues;
import com.kras.event.RectangleEvent;
import com.kras.warehouse.RectangleWarehouse;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
public class RectangleObserver implements Observer {
    private final RectangleWarehouse warehouse = RectangleWarehouse.getInstance();
    List<RectangleEvent> events = new ArrayList<>();

    @Override
    public void handleEvent(RectangleEvent event) {
        events.add(event);
        Rectangle source = event.getSource();
        RectangleValues rectangleValues = warehouse.get(source.getId());
        rectangleValues.setPerimeter(2 * (source.getSideA() + source.getSideB()));
        rectangleValues.setSquare(source.getSideA() * source.getSideB());
    }
}
