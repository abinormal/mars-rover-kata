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
}