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

    @Test
    void testFindNextPossibleLivePoints() {
        Point[] initialLivePoints = new Point[2];
        initialLivePoints[0] = new Point(1, 2);
        initialLivePoints[1] = new Point(2, 1);

        Game game = new Game(initialLivePoints);
        Set<Point> actualNextPossibleLivePoints = game.findNextPossibleLivePoints();
        Set<Point> expectedNextPossibleLivePoints = new HashSet<>();

        expectedNextPossibleLivePoints.add(new Point(0, 1));
        expectedNextPossibleLivePoints.add(new Point(0, 2));
        expectedNextPossibleLivePoints.add(new Point(0, 3));
        expectedNextPossibleLivePoints.add(new Point(1, 0));
        expectedNextPossibleLivePoints.add(new Point(1, 1));
        expectedNextPossibleLivePoints.add(new Point(1, 2));
        expectedNextPossibleLivePoints.add(new Point(1, 3));
        expectedNextPossibleLivePoints.add(new Point(2, 0));
        expectedNextPossibleLivePoints.add(new Point(2, 1));
        expectedNextPossibleLivePoints.add(new Point(2, 2));
        expectedNextPossibleLivePoints.add(new Point(2, 3));
        expectedNextPossibleLivePoints.add(new Point(3, 0));
        expectedNextPossibleLivePoints.add(new Point(3, 1));
        expectedNextPossibleLivePoints.add(new Point(3, 2));

        assertEquals(expectedNextPossibleLivePoints, actualNextPossibleLivePoints);
    }

    @Test
    void testIsLiveForLivePoint() {
        Point[] initialLivePoints = new Point[2];
        initialLivePoints[0] = new Point(1, 2);
        initialLivePoints[1] = new Point(2, 1);

        Game game = new Game(initialLivePoints);
        boolean isLive = game.isLive(new Point(1, 2));
        assertTrue(isLive);
    }

    @Test
    void testIsLiveForNonLivePoint() {
        Point[] initialLivePoints = new Point[2];
        initialLivePoints[0] = new Point(1, 2);
        initialLivePoints[1] = new Point(2, 1);

        Game game = new Game(initialLivePoints);
        boolean isLive = game.isLive(new Point(3, 4));
        assertFalse(isLive);
    }
}
