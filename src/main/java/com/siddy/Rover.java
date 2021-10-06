package com.siddy;

public class Rover extends Vehicle {

    public Rover(int y, int x, Direction d) {
        super(y, x, d);
    }

    public Rover(int y, int x, Direction d, Plateau p) {
        super(y, x, d, p);
    }
}
