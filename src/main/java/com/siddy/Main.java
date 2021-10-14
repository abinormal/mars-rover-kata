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

            Vehicle rover = new Rover(coords[0], coords[1], getDirection(), plateau);

            System.out.println("Enter the vehicle instructions - L/R/M : ");

            if (rover.processMovement(getMovement()) == Error.ERROR_BAD_MOVEMENT_STRING) {
                System.out.println("Movement string can only contain the letters LRM.");
            }
            System.out.println(rover.getPosX() + " " + rover.getPosY() + " " + rover.getDirection());
        } while (addAnotherVehicle());

    }

    private static int[] getCMDNumbers() {
        String size = "";
        boolean hasSize = false;
        do {
            try {
                size = reader.readLine();
                if (!size.matches("^[0-9]+( [0-9]+)")) {
                    System.out.println("Must be two numbers separated by a single space.");
                } else {
                    hasSize = true;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (!hasSize);
        String[] pSize = size.split(" ");
        return new int[]{Integer.parseInt(pSize[0]), Integer.parseInt(pSize[1])};
    }

    private static Direction getDirection(){
        System.out.println("Enter the direction the rover is facing - N/S/E/W : ");
        String dir = "";
        boolean haveResponse = false;
        do {
            try {
                dir = reader.readLine();
                if (!dir.matches("^[nsew|NSEW]")) {
                    System.out.println("Must be single character: N/S/E/W ");
                } else {
                    haveResponse = true;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (!haveResponse);
        return switch (dir.toLowerCase()) {
            case "n" -> Direction.NORTH;
            case "e" -> Direction.EAST;
            case "s" -> Direction.SOUTH;
            default -> Direction.WEST;
        };
    }

    private static String getMovement(){

        String movement = "";
            try {
                movement = reader.readLine();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
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
