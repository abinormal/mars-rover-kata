package com.siddy;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TestRover {

    Vehicle rover;

    @Before
    public void setup() {
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
    public void checkGoLeft() {
        Error error = rover.processMovement("L");
        if (error != Error.NO_ERROR) {
            System.out.println("Error: " + error);
        }
        assertEquals(Direction.NORTH, rover.getDirection());
    }

    @Test
    public void checkGoRight() {
        Error error = rover.processMovement("R");
        if (error != Error.NO_ERROR) {
            System.out.println("Error: " + error);
        }
        assertEquals(Direction.SOUTH, rover.getDirection());
    }

    @Test
    public void checkMove() {
        Error error = rover.processMovement("M");
        if (error != Error.NO_ERROR) {
            System.out.println("Error: " + error);
        }
        assertEquals(6, rover.getPosX());
    }

    @Test
    public void checkTurnLeftMove() {
        Error error = rover.processMovement("LM");
        if (error != Error.NO_ERROR) {
            System.out.println("Error: " + error);
        }
        assertEquals(4, rover.getPosY());
    }

    @Test
    public void checkTurnRightMove() {
        Error error = rover.processMovement("RM");
        if (error != Error.NO_ERROR) {
            System.out.println("Error: " + error);
        }
        assertEquals(2, rover.getPosY());
    }

    @Test
    public void checkTurnRightRightMove() {
        Error error = rover.processMovement("RRM");
        if (error != Error.NO_ERROR) {
            System.out.println("Error: " + error);
        }
        assertEquals(4, rover.getPosX());
    }

    @Test
    public void checkLongInstruction() {
        Error error = rover.processMovement("LMLMMMLMRM");
        if (error != Error.NO_ERROR) {
            System.out.println("Error: " + error);
        }
        assertEquals(1, rover.getPosX());
        assertEquals(3, rover.getPosY());
        assertEquals(Direction.WEST, rover.getDirection());
    }

    @Test
    public void checkInvalidInstructionString(){
        assertEquals(Error.ERROR_BAD_MOVEMENT_STRING, rover.processMovement("LMRFHLMMRMRLLMRL"));
    }
}