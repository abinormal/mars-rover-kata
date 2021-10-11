package com.siddy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {

        System.out.println("Welcome to Mars!");
        System.out.println("How large is the plateau? Enter two numbers separated by a space. ");
        int[] pSize = getCMDNumbers();
        Plateau plateau = new Plateau(pSize[0], pSize[1]);

        do {
            System.out.println("Enter the vehicle coordinates (x y) separated by a space");
            int[] coords = getCMDNumbers();
            Direction d = Direction.NORTH; //getDirection();
            Vehicle rover = new Rover(coords[0], coords[1], d, plateau);

            System.out.println("Position of the rover: x" + rover.getPosX() + " y" + rover.getPosY() + " " + rover.getDirection());
            Error error = rover.processMovement("MMMLM");
            System.out.println("Position of the rover: x" + rover.getPosX() + " y" + rover.getPosY() + " " + rover.getDirection());
            if (error == Error.ERROR_BAD_MOVEMENT_STRING) {
                System.out.println("Movement string can only contain the letters LRM.");
            }

        } while (addAnotherVehicle());

    }

    private static int[] getCMDNumbers() {
        String size = "";

        try {
            size = reader.readLine();
            if (!size.matches("^[0-9 ]+$")) {
                System.out.println("Must be a number.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        String[] pSize = size.split(" ");

        return new int[]{Integer.parseInt(pSize[0]), Integer.parseInt(pSize[1])};
    }


    private static boolean addAnotherVehicle() {
        String response = "n";
        boolean haveResponse = false;
        do {
            System.out.println("Would you like to add another vehicle? y/n");
            try {
                // Reading data using readLine
                response = reader.readLine();
                if (!response.matches("^[yn]")) {
                    System.out.println("Must be either y or n");
                } else {
                    haveResponse = true;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (!haveResponse);
        return response.equals("y");
    }
}
