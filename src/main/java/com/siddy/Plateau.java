package com.siddy;

public class Plateau {
    private final int X_MIN = 0;
    private final int Y_MIN = 0;
    private int X_MAX;
    private int Y_MAX;

    public Error Plateau(int x, int y) {
        if (x <= 0 || y <= 0) {
            return Error.ERROR_INVALID_PLATEAU_SIZE;
        }
        this.X_MAX = x;
        this.Y_MAX = y;
        return Error.NO_ERROR;
    }

    public int getYMax() {
        return this.Y_MAX;
    }

    public int getXMax() {
        return this.X_MAX;
    }

    public Error move(int x, int y, Direction d) {
        // Check the direction then see if the vehicle would go over the edge
        return edgeCheck(x, y, d);
        // If more than one vehicle do a collision check
    }

    private Error edgeCheck(int x, int y, Direction d) {
        Error error = Error.NO_ERROR;
        if ((d == Direction.NORTH && y >= this.Y_MAX) ||
            (d == Direction.EAST && x >= this.X_MAX)  ||
            (d == Direction.SOUTH && y <= this.Y_MIN) ||
            (d == Direction.WEST && x <= this.X_MIN) ) {
                error = Error.ERROR_OVER_EDGE;
        }
        return error;
    }

    private Error collisionCheck(){
        // This bit is for when more than one Vehicle is introduced.
        return Error.NO_ERROR;
    }
}
