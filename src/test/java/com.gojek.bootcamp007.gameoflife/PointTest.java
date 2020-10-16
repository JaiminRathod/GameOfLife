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

    @Test
    void testEqualsForPointsWithDifferentX() {
        Point point1 = new Point(1, 2);
        Point point2 = new Point(3, 2);
        assertNotEquals(point1, point2);
    }

    @Test
    void testEqualsForPointsWithDifferentY() {
        Point point1 = new Point(1, 2);
        Point point2 = new Point(1, 3);
        assertNotEquals(point1, point2);
    }

    @Test
    void testEqualsForPointComparedWithNull() {
        Point point1 = new Point(1, 2);
        Point point2 = null;
        assertNotEquals(point1, point2);
    }

    @Test
    void testEqualsForPointComparedWithNonPoint() {
        Point point1 = new Point(1, 2);
        String point2 = "Java";
        assertNotEquals(point1, point2);
    }

    @Test
    void testHashcodeForPointsWithSameEndPoints() {
        Point point1 = new Point(1, 2);
        Point point2 = new Point(1, 2);
        assertEquals(point1.hashCode(), point2.hashCode());
    }
}
