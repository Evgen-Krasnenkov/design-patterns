package com.kras.repository;

import com.kras.entity.Rectangle;
import com.kras.entity.RectangleValues;
import com.kras.impl.RectangleObserver;
import com.kras.warehouse.RectangleWarehouse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RectangleRepositoryTest {

    @Test
    void givenThreeRectanglesAndThreeTheirValues_whenSidesChanged_thenValuesInWareHouseChangedAsWell() {
        //given
        RectangleRepository repository = RectangleRepository.getInstance();
        RectangleWarehouse warehouse = RectangleWarehouse.getInstance();
        Rectangle rectangle0 = new Rectangle(0, 3, 5);
        Rectangle rectangle1 = new Rectangle(1, 3, 5);
        Rectangle rectangle2 = new Rectangle(2, 3, 5);
        RectangleObserver observer = new RectangleObserver();
        rectangle0.addObserver(observer);
        rectangle1.addObserver(observer);
        rectangle2.addObserver(observer);
        repository.add(rectangle0);
        repository.add(rectangle1);
        repository.add(rectangle2);
        warehouse.put(rectangle0.getId(),
                new RectangleValues(rectangle0.getSideA() * rectangle0.getSideB(),
                        (2 * (rectangle0.getSideA() + rectangle0.getSideB()))));
        warehouse.put(rectangle1.getId(),
                new RectangleValues(rectangle1.getSideA() * rectangle1.getSideB(),
                        (2 * (rectangle1.getSideA() + rectangle1.getSideB()))));
        warehouse.put(rectangle2.getId(),
                new RectangleValues(rectangle2.getSideA() * rectangle2.getSideB(),
                        (2 * (rectangle2.getSideA() + rectangle2.getSideB()))));
        Assertions.assertEquals(16, warehouse.get(0).getPerimeter());
        Assertions.assertEquals(15, warehouse.get(0).getSquare());
        //when
        Rectangle rectangle = repository.getRectangle(0);
        rectangle.setSideA(2);
        rectangle.setSideB(4);
        //then
        Assertions.assertEquals(12, warehouse.get(0).getPerimeter());
        Assertions.assertEquals(8, warehouse.get(0).getSquare());
        //when
        rectangle = repository.getRectangle(1);
        rectangle.setSideA(6);
        rectangle.setSideB(7);
        //then
        Assertions.assertEquals(26, warehouse.get(1).getPerimeter());
        Assertions.assertEquals(42, warehouse.get(1).getSquare());
        //when
        rectangle = repository.getRectangle(2);
        rectangle.setSideA(7);
        rectangle.setSideB(6);
        //then
        Assertions.assertEquals(26, warehouse.get(1).getPerimeter());
        Assertions.assertEquals(42, warehouse.get(1).getSquare());

    }

}