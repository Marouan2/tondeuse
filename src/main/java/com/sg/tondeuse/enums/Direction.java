package com.sg.tondeuse.enums;

import com.sg.tondeuse.model.Position;
import com.sg.tondeuse.model.Terrain;

public enum Direction {
    N("N") {
        @Override
        public Position move(Position position) {
            if(this.getTerrain().isInside(position.getX(), position.getY()+1)) {
                return position.moveToNorth();
            }
            return position;
        }

        @Override
        public Direction pivotLeft() {
            return W;
        }

        @Override
        public Direction pivotRight() {
            return E;
        }
    },

    E("E") {
        public Position move(Position position) {
            if(this.getTerrain().isInside(position.getX()+1, position.getY())) {
                return position.moveToEast();
            }
            return position;
        }

        public Direction pivotLeft() {
            return N;
        }

        @Override
        public Direction pivotRight() {
            return S;
        }

    },


    S("S") {
        public Position move(Position position) {
            if(this.getTerrain().isInside(position.getX(), position.getY()-1)) {
                return position.moveToSouth();
            }
            return position;
        }

        public Direction pivotLeft() {
            return E;
        }

        @Override
        public Direction pivotRight() {
            return W;
        }

    },

    W("W") {
        public Position move(Position position) {
            if(this.getTerrain().isInside(position.getX()-1, position.getY())) {
                return position.moveToWest();
            }
            return position;
        }

        public Direction pivotLeft() {
            return S;
        }

        @Override
        public Direction pivotRight() {
            return N;
        }
    };


    Direction(final String code) {
        this.code = code;
    }

    public abstract Position move(Position position);

    public abstract Direction pivotLeft();

    public abstract Direction pivotRight();
    
    private final String code;

    private Terrain terrain;

    public String getCode() {
        return code;
    }

    public void setTerrain(Terrain terrain) {
        this.terrain = terrain;
    }

    public Terrain getTerrain() {
        return terrain;
    }
}
