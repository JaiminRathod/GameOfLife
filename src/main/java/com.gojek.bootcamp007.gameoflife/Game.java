package com.gojek.bootcamp007.gameoflife;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Game {

    private final Set<Point> livePoints = new HashSet<>();

    public Game(Point[] liveCells) {
        if (liveCells != null)
            this.livePoints.addAll(Arrays.asList(liveCells));
    }

    Set<Point> findNeighbours(Point point) {
        Set<Point> neighbours = new HashSet<>();
        neighbours.add(new Point(point.x - 1, point.y - 1));
        neighbours.add(new Point(point.x - 1, point.y));
        neighbours.add(new Point(point.x - 1, point.y + 1));
        neighbours.add(new Point(point.x, point.y + 1));
        neighbours.add(new Point(point.x + 1, point.y + 1));
        neighbours.add(new Point(point.x + 1, point.y));
        neighbours.add(new Point(point.x + 1, point.y - 1));
        neighbours.add(new Point(point.x, point.y - 1));
        return neighbours;
    }

    boolean isLive(Point point) {
        return livePoints.contains(point);
    }

    int countSurroundingLivePoints(Point point) {
        Set<Point> neighbours = findNeighbours(point);
        neighbours.retainAll(livePoints);
        return neighbours.size();
    }

    Set<Point> findNextPossibleLivePoints() {
        Set<Point> nextPossibleLivePoints = new HashSet<>();

        for (Point livePoint : livePoints) {
            nextPossibleLivePoints.add(livePoint);
            Set<Point> neighbours = findNeighbours(livePoint);
            nextPossibleLivePoints.addAll(neighbours);
        }

        return nextPossibleLivePoints;
    }

    Set<Point> findNextLivePoints() {
        return livePoints;
    }
}
