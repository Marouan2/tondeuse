package com.sg.tondeuse.enums;

import com.sg.tondeuse.model.Position;
import com.sg.tondeuse.model.Tondeuse;

public enum Movement {
    D{
        @Override
        public void move(Tondeuse tondeuse, Direction direction) {
            tondeuse.pivotRight();
        }
    },
    G{
        @Override
        public void move(Tondeuse tondeuse, Direction direction) {
            tondeuse.pivotLeft();
        }
    },
    A{
        @Override
        public void move(Tondeuse tondeuse, Direction direction) {
            if (direction == null) {
                return;
            }
            direction.setTerrain(tondeuse.getTerrain());
            Position position = direction.move(tondeuse.getPosition());
            tondeuse.setPosition(position);
        }
    };

    public abstract void move(Tondeuse tondeuse, Direction direction);

    }
