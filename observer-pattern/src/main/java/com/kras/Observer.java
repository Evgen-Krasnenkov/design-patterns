package com.kras;

import com.kras.event.RectangleEvent;

public interface Observer {
    void handleEvent(RectangleEvent event);
}

