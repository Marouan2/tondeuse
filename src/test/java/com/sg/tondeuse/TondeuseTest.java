package com.sg.tondeuse;

import com.sg.tondeuse.enums.Direction;
import com.sg.tondeuse.enums.Movement;
import com.sg.tondeuse.model.Position;
import com.sg.tondeuse.model.Terrain;
import com.sg.tondeuse.model.Tondeuse;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TondeuseTest {

    @Test
    public void testInitialPosition00() {
        Tondeuse tondeuse = new Tondeuse(new Position(0, 0),Direction.N);
        assertEquals(new Position(0, 0), tondeuse.getPosition());
    }

    @Test
    public void testMowerPivotLeft() {
        Tondeuse tondeuse = new Tondeuse(new Position(0, 0),Direction.N);
        tondeuse.pivotLeft();
        assertEquals(tondeuse.getDirection(), Direction.W);
    }

    @Test
    public void testMowerPivotRight() {
        Tondeuse tondeuse = new Tondeuse(new Position(0, 0),Direction.N);
        tondeuse.pivotRight();
        assertEquals(tondeuse.getDirection(), Direction.E);
    }

    @Test
    public void testPosition12North() {
        Tondeuse tondeuse = new Tondeuse(new Position(1, 2),Direction.N);
        Terrain terrain = new Terrain(5,5);
        tondeuse.setTerrain(terrain);
        String movements = "GAGAGAGAA";
        for (char c : movements.toCharArray()) {
            tondeuse
                    .move(Movement.valueOf(Character.toString(c)),tondeuse.getDirection());
        }
        assertEquals(new Position(1, 3), tondeuse.getPosition());
        assertEquals(Direction.N, tondeuse.getDirection());
    }

    @Test
    public void testPosition33East() {
        Tondeuse tondeuse = new Tondeuse(new Position(3, 3),Direction.E);
        Terrain terrain = new Terrain(5,5);
        tondeuse.setTerrain(terrain);
        String movements = "AADAADADDA";
        for (char c : movements.toCharArray()) {
            tondeuse
                    .move(Movement.valueOf(Character.toString(c)),tondeuse.getDirection());
        }
        assertEquals(new Position(5, 1), tondeuse.getPosition());
        assertEquals(Direction.E, tondeuse.getDirection());
    }

}
