package com.sg.tondeuse.utils;

import com.sg.tondeuse.enums.Direction;
import com.sg.tondeuse.enums.Movement;
import com.sg.tondeuse.model.Position;
import com.sg.tondeuse.model.Terrain;
import com.sg.tondeuse.model.Tondeuse;

import java.io.*;

public class MowItNowUtils {
    private static final String SURFACE_REGEX = "^[0-9]+ [0-9]+";
    private static final String POSITION_REGEX = "^[0-9]+ [0-9]+ [NESW]$";
    private static final String MOVEMENT_REGEX = "^[ADG]+";

    public static void parseFile(String path) throws IOException {
        InputStream is = new FileInputStream(path);
        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        String line;
        Tondeuse currentTondeuse;
        Position position = null;
        Direction direction = null;
        Terrain terrain = null;
        while ((line = br.readLine()) != null) {
            if (line.matches(SURFACE_REGEX)) {
                final String[] surface = line.split(" ");
                final int x = Integer.valueOf(surface[0]);
                final int y = Integer.valueOf(surface[1]);
                terrain = new Terrain(x, y);
            }
            if (line.matches(POSITION_REGEX)) {
                String[] coordonates = line.split(" ");
                int x = Integer.valueOf(coordonates[0]);
                int y = Integer.valueOf(coordonates[1]);
                char code = coordonates[2].charAt(0);
                position = new Position(x, y);
                direction = Direction.valueOf(String.valueOf(code));
            }
            if (line.matches(MOVEMENT_REGEX)) {
                currentTondeuse = new Tondeuse(position,direction);
                currentTondeuse.setTerrain(terrain);
                for (char c : line.toCharArray()) {
                    currentTondeuse
                            .move(Movement.valueOf(Character.toString(c)),currentTondeuse.getDirection());
                }
                System.out.println(currentTondeuse);
            }
        }
        br.close();
    }
}
