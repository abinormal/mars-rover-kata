package com.siddy;

public abstract class Vehicle {
    private int posX;
    private int posY;
    private Direction d;
    private final Plateau p;

    public Vehicle(int y, int x, Direction d) {
        this.posX = x;
        this.posY = y;
        this.d = d;
        p = new Plateau(7,7);
        vehicleOnPlateau();
    }

    public Vehicle(int x, int y, Direction d, Plateau p) {
        this.posX = x;
        this.posY = y;
        this.d = d;
        this.p = p;
        vehicleOnPlateau();
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

    private void vehicleOnPlateau() {
        // If the vehicle isn't on the Plateau
        if (this.posX > p.getXMax() || this.posY > p.getYMax() ||
            this.posX < 0 || this.posY < 0){
            System.out.println("Vehicle is not on plateau. Good luck!");
        }
    }

    private Error checkMovementString(String instructions) {
        if (!instructions.matches("^[LMR]+$")) {
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

    private void move() throws Exception {
        if(this.p.move(this.posX,this.posY,this.d) == Error.ERROR_OVER_EDGE){
           throw new Exception("Rover has reached the edge");
        }
        Direction direction = this.d;
        switch (direction) {
            case NORTH -> this.posY += 1;
            case EAST -> this.posX += 1;
            case SOUTH -> this.posY -= 1;
            case WEST -> this.posX -= 1;
        }
    }
}
