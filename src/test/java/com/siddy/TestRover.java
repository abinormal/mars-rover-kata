package com.siddy;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TestRover {

    Vehicle rover;

    @Before
    public void setup(){
        rover = new Rover(3, 5, Direction.EAST);
    }

    @Test
    public void checkPositionY() {
        assertEquals(3, rover.getPosY());
    }

    @Test
    public void checkPositionX() {
        assertEquals(5, rover.getPosX());
    }

    @Test
    public void checkDirection() {
        assertEquals(Direction.EAST, rover.getDirection());
    }

    @Test
    public void checkGoLeft(){
        // A
        String instruction = "L";
        // A
        Error error = rover.processMovement(instruction);
        if (error != Error.NO_ERROR) {
            System.out.println("Error: " + error);
        }
        Direction direction = rover.getDirection();

        // A
        assertEquals(Direction.NORTH, direction);
    }
}