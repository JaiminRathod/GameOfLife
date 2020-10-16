package com.gojek.bootcamp007.gameoflife;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointTest {
    @Test
    void testEqualsForPointsWithSameCoordinates() {
        Point point1 = new Point(1, 2);
        Point point2 = new Point(1, 2);
        assertEquals(point1, point2);
    }
}
