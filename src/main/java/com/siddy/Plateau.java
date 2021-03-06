package com.siddy;

public class Plateau {
    private final int X_MAX;
    private final int Y_MAX;

    public Plateau(int x, int y) throws IllegalArgumentException{
        if (x <= 0 || y <= 0) {
            throw new IllegalArgumentException("Plateau size must be greater than zero");
        }
        this.X_MAX = x;
        this.Y_MAX = y;
    }

    public int getYMax() {
        return this.Y_MAX;
    }

    public int getXMax() {
        return this.X_MAX;
    }

    public Status move(int x, int y, Direction d) {
        // Check the direction then see if the vehicle would go over the edge
        return edgeCheck(x, y, d);
        // If more than one vehicle do a collision check
    }

    private Status edgeCheck(int x, int y, Direction d) {
        Status status = Status.NO_ERROR;
        int x_MIN = 0;
        int y_MIN = 0;
        if ((d == Direction.NORTH && y >= this.Y_MAX) ||
            (d == Direction.EAST && x >= this.X_MAX)  ||
            (d == Direction.SOUTH && y <= y_MIN) ||
            (d == Direction.WEST && x <= x_MIN) ) {
            status = Status.ERROR_OVER_EDGE;
        }
        return status;
    }

    private Status collisionCheck(){
        // This bit is for when more than one Vehicle is introduced.
        return Status.NO_ERROR;
    }
}
