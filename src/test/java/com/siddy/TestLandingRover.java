package com.siddy;

import org.junit.Test;

public class TestLandingRover {

    @Test
    public void checkItWorks(){
        Plateau plateau = new Plateau(7,7);
        Vehicle rover = new Rover(1,1,Direction.SOUTH, plateau);

        System.out.println("Position of the rover: x"+rover.getPosX()+ " y"+rover.getPosY()+" "+rover.getDirection());
        Error error = rover.processMovement( "MMMLM");
        System.out.println("Position of the rover: x"+rover.getPosX()+ " y"+rover.getPosY()+" "+rover.getDirection());
        if (error == Error.ERROR_BAD_MOVEMENT_STRING){
            System.out.println("Movement string can only contain the letters LRM.");
        }

    }

}
