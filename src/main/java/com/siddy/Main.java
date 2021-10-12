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

            Vehicle rover = new Rover(coords[0], coords[1], getDirection(), plateau); // todo - Must check rover lands on the plateau

            System.out.println("Position of the rover: x" + rover.getPosX() + " y" + rover.getPosY() + " " + rover.getDirection());
            Error error = rover.processMovement(getMovement());
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
            if (!size.matches("^[0-9 ]+$")) { // todo - Alter the regex to only accept two ints here
                System.out.println("Must be two numbers separated by a single space.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        String[] pSize = size.split(" ");
        return new int[]{Integer.parseInt(pSize[0]), Integer.parseInt(pSize[1])};
    }

    private static Direction getDirection(){
        System.out.println("Enter the direction the rover is facing - n/s/e/w : ");
        String dir = "";
        boolean haveResponse = false;
        do {
            try {
                dir = reader.readLine();
                if (!dir.matches("^[nsew]")) {
                    System.out.println("Must be single character: n/s/e/w ");
                } else {
                    haveResponse = true;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (!haveResponse);
        return switch (dir) {
            case "n" -> Direction.NORTH;
            case "e" -> Direction.EAST;
            case "s" -> Direction.SOUTH;
            default -> Direction.WEST;
        };
    }

    private static String getMovement(){
        System.out.println("Enter the vehicle instructions - L/R/M : ");
        String movement = "";
        boolean haveResponse = false;
        do {
            try {
                movement = reader.readLine();
                if (!movement.matches("^[LRM]+$")) {
                    System.out.println("String must contain only the letters: LRM ");
                } else {
                    haveResponse = true;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (!haveResponse);
        // We have a valid response!
        System.out.println("Movement String: " + movement);
        return movement;
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
