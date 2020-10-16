package com.gojek.bootcamp007.gameoflife;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Game {

    private Set<Point> livePoints = new HashSet<>();

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
        Set<Point> nextLivePoints = new HashSet<>();
        Set<Point> nextPossibleLivePoints = findNextPossibleLivePoints();

        for (Point point : nextPossibleLivePoints) {
            if (isLive(point) && (countSurroundingLivePoints(point) == 2 || countSurroundingLivePoints(point) == 3))
                nextLivePoints.add(point);

            if (!isLive(point) && countSurroundingLivePoints(point) == 3)
                nextLivePoints.add(point);
        }

        return nextLivePoints;
    }

    void play() throws InterruptedException {
        printGrid();
        while (true) {
            Thread.sleep(100);
            livePoints = findNextLivePoints();
            printGrid();
        }
    }

    Point findTopLeftPoint() {
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        for (Point livePoint : livePoints) {
            if (livePoint.x < minX) {
                minX = livePoint.x;
            }
            if (livePoint.y < minY) {
                minY = livePoint.y;
            }
        }

        return new Point(minX, minY);
    }

    Point findBottomRightPoint() {
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        for (Point livePoint : livePoints) {
            if (livePoint.x > maxX) {
                maxX = livePoint.x;
            }
            if (livePoint.y > maxY) {
                maxY = livePoint.y;
            }
        }

        return new Point(maxX, maxY);
    }

    public void clearScreen() {
        try {
            System.out.print("\033[H\033[2J");
            System.out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void printGrid() {
        clearScreen();

        int gridBottomRightPointX = ((findBottomRightPoint().x + 99) / 100) * 100;
        int gridBottomRightPointY = ((findBottomRightPoint().y + 99) / 100) * 100;

        int gridTopLeftPointX = ((findTopLeftPoint().x - 99) / 100) * 100;
        int gridTopLeftPointY = ((findTopLeftPoint().y - 99) / 100) * 100;

        int xShift = gridTopLeftPointX * -1;
        int yShift = gridTopLeftPointY * -1;

        gridBottomRightPointX = gridBottomRightPointX + xShift;
        gridBottomRightPointY = gridBottomRightPointY + yShift;

        Set<Point> temp = new HashSet<>();

        for (Point livePoint : livePoints) {
            temp.add(new Point(livePoint.x + xShift, livePoint.y + yShift));
        }

        boolean[][] grid = new boolean[gridBottomRightPointX][gridBottomRightPointY];
        for (int i = 0; i < gridBottomRightPointX; i++) {
            for (int j = 0; j < gridBottomRightPointY; j++) {
                grid[i][j] = false;
            }
        }
        for (Point Point : temp) {
            grid[Point.x][Point.y] = true;
        }

        System.out.println("Board");

        for (int i = 0; i < gridBottomRightPointX; i++) {
            for (int j = 0; j < gridBottomRightPointY; j++) {
                if (!grid[i][j]) {
                    System.out.print("_");
                } else {
                    System.out.print("#");
                }
            }
            System.out.println();
        }
    }
}
