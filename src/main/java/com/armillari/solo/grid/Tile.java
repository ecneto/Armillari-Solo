package com.armillari.solo.grid;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Tile {
    String terrain;
    int x;
    int y;
    TileFactory factory;

    Map<DirectionType, Tile> neighbors;

    public Tile(String terrain, int x, int y) {
        this.terrain = terrain;
        neighbors = new HashMap<DirectionType, Tile>();
        neighbors.put(DirectionType.NEAST, null);
        neighbors.put(DirectionType.EAST, null);
        neighbors.put(DirectionType.SEAST, null);
        neighbors.put(DirectionType.SWEST, null);
        neighbors.put(DirectionType.WEST, null);
        neighbors.put(DirectionType.NWEST, null);

        this.x = x;
        this.y = y;
    }

    Tile neast() { return neighbors.get(DirectionType.NEAST); }
    Tile east() { return neighbors.get(DirectionType.EAST); }
    Tile seast() { return neighbors.get(DirectionType.SEAST); }
    Tile swest() { return neighbors.get(DirectionType.SWEST); }
    Tile west() { return neighbors.get(DirectionType.WEST); }
    Tile nwest() { return neighbors.get(DirectionType.NWEST); }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void registerFactory(TileFactory factory) {
        this.factory = factory;
    }

    public Rectangle getDimensions() {
        Rectangle rect = new Rectangle();

        rect.x = getLeft();
        rect.width = getRight() - rect.x;
        rect.y = getTop();
        rect.height = getBottom() - rect.y;

        return rect;
    }

    private int getLeft() {
        if(west() == null && swest() == null && nwest() == null) {
            return 0;
        }
        if(west() != null) {
            return west().getLeft() - 2;
        } else {
            int northLength = nwest() != null ? nwest().getLeft() - 1: 0;
            int southLength = swest() != null ? swest().getLeft() - 1 : 0;

            return Math.min(northLength, southLength);
        }
    }

    private int getRight() {
        if(east() == null && seast() == null && neast() == null) {
            return 0;
        }
        if(east() != null) {
            return east().getRight() + 2;
        } else {
            int northLength = neast() != null ? neast().getRight() + 1 : 0;
            int southLength = seast() != null ? seast().getRight() + 1 : 0;

            return Math.max(northLength, southLength);
        }
    }

    private int getTop() {
        if(neast() == null && nwest() == null) {
            return 0;
        } else {
            int neastLength = neast() != null ? neast().getTop() - 1 : 0;
            int nwestLength = nwest() != null ? nwest().getTop() - 1 : 0;

            return Math.min(neastLength, nwestLength);
        }
    }

    private int getBottom() {
        if(seast() == null && swest() == null) {
            return 0;
        } else {
            int seastLength = seast() != null ? seast().getBottom() + 1 : 0;
            int swestLength = swest() != null ? swest().getBottom() + 1 : 0;

            return Math.max(seastLength, swestLength);
        }
    }

    public Tile getNextTile(DirectionType directionType) {
        Tile nextTile = neighbors.get(directionType);
        if(nextTile == null) {
            Point source = new Point(x, y);
            nextTile = factory.makeTile(source, directionType);
            neighbors.put(directionType, nextTile);
        }
        return nextTile;
    }
}
