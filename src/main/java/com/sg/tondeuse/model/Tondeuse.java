package com.sg.tondeuse.model;

import com.sg.tondeuse.enums.Direction;
import com.sg.tondeuse.enums.Movement;

public class Tondeuse {

    private Position position ;

    private Direction direction ;

    private Terrain terrain;

    public Tondeuse(Position initialPosition, Direction direction) {
        this.position = initialPosition;
        this.direction = direction;
    }

    public Position getPosition() {
        return this.position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void orient(Direction direction) {
        this.direction = direction;
    }

    public void move() {
        direction.setTerrain(this.terrain);
        this.position = direction.move(position);
    }

    public void pivotLeft() {
        this.direction = direction.pivotLeft();
    }

    public void pivotRight() {
        this.direction = direction.pivotRight();
    }

    public Direction getDirection() {
        return direction;
    }

    public void move(Movement movement, Direction direction) {
        if (movement == null) {
            return;
        }
        movement.move(this,direction);
    }

    public Terrain getTerrain() {
        return terrain;
    }

    public void setTerrain(Terrain terrain) {
        this.terrain = terrain;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(this.position.getX());
        sb.append(' ');
        sb.append(this.position.getY());
        sb.append(' ');
        sb.append(this.direction);
        return sb.toString();
    }

}
