package com.sg.tondeuse.model;

public class Terrain {
    private final int x;
    private final int y;

    public Terrain(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isInside(int x, int y) {
        return x > -1 && x < this.x + 1 && y > -1 && y < this.y + 1;
    }

}
