package com.gojek.bootcamp007.gameoflife;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    @Test
    void testFindNeighbours() {
        Point[] points = null;
        Game game = new Game(points);

        Set<Point> actualNeighbours = game.findNeighbours(new Point(3, 3));
        Set<Point> expectedNeighbours = new HashSet<>();
        expectedNeighbours.add(new Point(2, 2));
        expectedNeighbours.add(new Point(2, 3));
        expectedNeighbours.add(new Point(2, 4));
        expectedNeighbours.add(new Point(3, 4));
        expectedNeighbours.add(new Point(4, 4));
        expectedNeighbours.add(new Point(4, 3));
        expectedNeighbours.add(new Point(4, 2));
        expectedNeighbours.add(new Point(3, 2));
        assertEquals(expectedNeighbours, actualNeighbours);
    }
}
