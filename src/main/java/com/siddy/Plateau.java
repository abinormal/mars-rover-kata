package com.siddy;

public class Plateau {
    int X_MIN = 0;
    int Y_MIN = 0;
    int X_MAX;
    int Y_MAX;

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
        Error error = edgeCheck(x, y, d);
        if (error == Error.NO_ERROR) {
            //Do collision check
        }
        return error;
    }

    public Error edgeCheck(int x, int y, Direction d) {
        if (d == Direction.NORTH && y >= this.Y_MAX) {
            return Error.ERROR_OVER_EDGE;
        } else if (d == Direction.EAST && x >= this.X_MAX) {
            return Error.ERROR_OVER_EDGE;
        } else if (d == Direction.SOUTH && y <= this.Y_MIN) {
            return Error.ERROR_OVER_EDGE;
        } else if (d == Direction.WEST && x <= this.X_MIN) {
            return Error.ERROR_OVER_EDGE;
        }
        return Error.NO_ERROR;
    }
}
