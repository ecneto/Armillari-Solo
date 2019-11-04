package com.armillari.solo.grid;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class TileFactory {
    final static String START_TERRAIN = "Green";
    static Map<DirectionType, Point> DELTA_BY_DIRECTION;
    static {
        DELTA_BY_DIRECTION = new HashMap<DirectionType, Point>();
        DELTA_BY_DIRECTION.put(DirectionType.NEAST, new Point(1,-1));
        DELTA_BY_DIRECTION.put(DirectionType.EAST, new Point(2,0));
        DELTA_BY_DIRECTION.put(DirectionType.SEAST, new Point(1,1));
        DELTA_BY_DIRECTION.put(DirectionType.SWEST, new Point(-1,1));
        DELTA_BY_DIRECTION.put(DirectionType.WEST, new Point(-2,0));
        DELTA_BY_DIRECTION.put(DirectionType.NWEST, new Point(-1,-1));
    }
    Map<Integer, Map<Integer, Tile>> tilesByPosition;

    public TileFactory() {
    }

    public void registerTileMap(Map<Integer, Map<Integer, Tile>> tileMap) {
        this.tilesByPosition = tileMap;
    }

    public Tile makeStartTile() {
        Tile startTile = new Tile(START_TERRAIN, 0, 0);
        startTile.registerFactory(this);
        Grid.registerTile(tilesByPosition, startTile);
        return startTile;
    }

    public Tile makeTile(Point source, DirectionType directionType) {
        Point destination = getDestination(source, directionType);
        Tile exploredTile = getTileByPosition(destination.x, destination.y);
        if(exploredTile != null) {
            return exploredTile;
        } else {
            Tile newTile = new Tile("Green", destination.x, destination.y);
            newTile.registerFactory(this);
            Grid.registerTile(tilesByPosition, newTile);
            return newTile;
        }
    }

    private static Point getDestination(Point source, DirectionType directionType) {
        Point delta = DELTA_BY_DIRECTION.get(directionType);
        Point destination = new Point(source.x + delta.x, source.y + delta.y);
        return destination;
    }

    public Tile getTileByPosition(int x, int y) {
        if(!tilesByPosition.containsKey(x)) {
            return null;
        }
        Map<Integer, Tile> tilesOfXPosition = tilesByPosition.get(x);
        if(!tilesOfXPosition.containsKey(y)) {
            return null;
        }
        Tile tileOfXYPosition = tilesOfXPosition.get(y);
        return tileOfXYPosition;
    }
}
