package com.siddy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Vehicle {
    private int posX;
    private int posY;
    private Direction d;
    private Plateau p;

    public Vehicle(int y, int x, Direction d) {
        this.posX = x;
        this.posY = y;
        this.d = d;
    }

    public Vehicle(int y, int x, Direction d, Plateau p) {
        // todo - check for collision here and throw exception if coordinates are taken
        this.posX = x;
        this.posY = y;
        this.d = d;
        this.p = p;
    }

    public int getPosY() {
        return this.posY;
    }

    public int getPosX() {
        return this.posX;
    }

    public Direction getDirection() {
        return this.d;
    }

    public Error processMovement(String instructions) {
        // todo - check there is a valid instruction string here.
        if (checkMovementString(instructions) == Error.ERROR_BAD_MOVEMENT_STRING) {
            return Error.ERROR_BAD_MOVEMENT_STRING;
        }
        String[] instructionArray = instructions.split("");
        for (String instruction : instructionArray) {
            try {
                switch (instruction) {
                    case "L" -> goLeft();
                    case "R" -> goRight();
                    case "M" -> move();
                    default -> System.out.println("Something else? " + instruction);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return Error.NO_ERROR;
    }

    private Error checkMovementString(String instructions) {
        Pattern pattern = Pattern.compile("[^L|M|R]", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(instructions);
        if (matcher.find()) {
            return Error.ERROR_BAD_MOVEMENT_STRING;
        }
        return Error.NO_ERROR;
    }

    private void goLeft() {
        Direction direction = this.d;
        switch (direction) {
            case EAST -> this.d = Direction.NORTH;
            case SOUTH -> this.d = Direction.EAST;
            case WEST -> this.d = Direction.SOUTH;
            case NORTH -> this.d = Direction.WEST;
            default -> System.out.println("Um.. You passed me what!" + direction);
        }
    }

    private void goRight() {
        Direction direction = this.d;
        switch (direction) {
            case EAST -> this.d = Direction.SOUTH;
            case SOUTH -> this.d = Direction.WEST;
            case WEST -> this.d = Direction.NORTH;
            case NORTH -> this.d = Direction.EAST;
            default -> System.out.println("What direction is this?" + direction);
        }
    }

    private Error move() throws Exception {
        Error error = this.p.move(this.posX,this.posY,this.d);
        if(error == Error.ERROR_OVER_EDGE){
           throw new Exception("Rover has reached the edge");
        }
        Direction direction = this.d;
        switch (direction) {
            case NORTH -> this.posY += 1;
            case EAST -> this.posX += 1;
            case SOUTH -> this.posY -= 1;
            case WEST -> this.posX -= 1;
        }
        return Error.NO_ERROR;
    }
}
