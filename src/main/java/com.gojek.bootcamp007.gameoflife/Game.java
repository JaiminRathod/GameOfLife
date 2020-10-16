package com.gojek.bootcamp007.gameoflife;

import java.util.HashSet;
import java.util.Set;

public class Game {
    public Game(Point[] liveCells) {
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
}
