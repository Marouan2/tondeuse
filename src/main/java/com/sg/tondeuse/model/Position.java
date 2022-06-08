package com.sg.tondeuse.model;

import com.sg.tondeuse.enums.Direction;

public class Position {

    private final int x;

    private final int y;

    private Direction direction;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position moveToNorth() {
        return new Position(x, y + 1);
    }

    public Position moveToEast() {
        return new Position(x + 1, y);
    }

    public Position moveToWest() {
        return new Position(x - 1, y);
    }

    public Position moveToSouth() {
        return new Position(x, y - 1);
    }

    public static Position originPosition() {
        return new Position(0, 0);
    }

    @Override
    public int hashCode() {
        final int hash = 31;
        int result = 17;
        result = hash * result + x;
        result = hash * result + y;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Position other = (Position) obj;
        if (x != other.x)
            return false;
        if (y != other.y)
            return false;
        return true;
    }
}
