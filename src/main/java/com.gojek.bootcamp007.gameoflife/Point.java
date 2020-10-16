package com.gojek.bootcamp007.gameoflife;

public class Point {
    public final int x;
    public Point(int x, int y) {
        this.x = x;
    }

    @Override
    public boolean equals(Object obj) {
        Point other = (Point) obj;
        return x == other.x;
    }
}
