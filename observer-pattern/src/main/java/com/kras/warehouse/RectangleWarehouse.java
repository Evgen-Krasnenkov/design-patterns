package com.kras.warehouse;


import com.kras.entity.RectangleValues;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@ToString
public class RectangleWarehouse {
    private static RectangleWarehouse instance;
    private final Map<Integer, RectangleValues> valueMap;

    private RectangleWarehouse() {
        this.valueMap = new HashMap<>();
    }

    public static RectangleWarehouse getInstance() {
        if (instance == null) {
            instance = new RectangleWarehouse();
        }
        return instance;
    }

    public RectangleValues get(Integer rectangleId) {
        return valueMap.get(rectangleId);
    }

    public RectangleValues put(Integer rectangleId, RectangleValues rectangleValues) {
        return valueMap.put(rectangleId, rectangleValues);
    }

    public boolean remove(Integer rectangleId, RectangleValues rectangleValues) {
        return valueMap.remove(rectangleId, rectangleValues);
    }
}
