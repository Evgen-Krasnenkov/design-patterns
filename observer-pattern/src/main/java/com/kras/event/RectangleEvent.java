package com.kras.event;


import com.kras.entity.Rectangle;
import lombok.ToString;

import java.util.EventObject;
@ToString
public class RectangleEvent extends EventObject {

    public RectangleEvent(Object source) {
        super(source);
    }

    @Override
    public Rectangle getSource() {
        return (Rectangle) super.getSource();
    }
}
