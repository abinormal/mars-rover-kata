package com.siddy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {

        System.out.println("Welcome to Mars!");

        int[] pSize = getPlateauSize();
        Plateau plateau = new Plateau(pSize[0], pSize[1]);

        do {
            Vehicle rover = new Rover(1, 1, Direction.SOUTH, plateau);

            System.out.println("Position of the rover: x" + rover.getPosX() + " y" + rover.getPosY() + " " + rover.getDirection());
            Error error = rover.processMovement("MMMLM");
            System.out.println("Position of the rover: x" + rover.getPosX() + " y" + rover.getPosY() + " " + rover.getDirection());
            if (error == Error.ERROR_BAD_MOVEMENT_STRING) {
                System.out.println("Movement string can only contain the letters LRM.");
            }
            System.out.println("Would you like to add another vehicle? y/n");

        } while (addAnotherVehicle()); // todo - fix this to exit on command

    }
    private static int[] getPlateauSize(){
        String size = "7 7";
        // Enter data using BufferReader

        System.out.println("How large is the plateau? Enter two numbers separated by a space. ");
        try {
            // Reading data using readLine
            size = reader.readLine();
            if (!size.matches("^[0-9 ]+$")){
                System.out.println("Must be a number.");
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        String[] pSize = size.split(" ");

        return new int[]{Integer.parseInt(pSize[0]), Integer.parseInt(pSize[1])};
    }
    private static boolean addAnotherVehicle(){
        String response = "n";
        try {
            // Reading data using readLine
            response = reader.readLine();
            if (!response.matches("^[yn]")){
                System.out.println("Must be either y or n");
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return response.equals("y");
    }
}
