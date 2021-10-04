package com.siddy;

public abstract class Vehicle {
    private int posX;
    private int posY;
    private Direction d;

    public Vehicle(int y, int x, Direction d){
        this.posX = x;
        this.posY = y;
        this.d = d;
        // todo - check for collision here and throw exception if coordinates are taken
    }

    public int getPosY(){
        return this.posY;
    }
    public int getPosX(){
        return this.posX;
    }
    public Direction getDirection(){
        return this.d;
    }

    public Error processMovement(String instructions){
        // todo - check there is a valid instruction string here.
        // todo - add a for here
        String[] instructionArray = instructions.split("");
        for (String instruction : instructionArray) {
            switch (instruction) {
                case "L":
                    goLeft();
                    break;
                default:
                    System.out.println("Something else? " + instructions);
            }
        }
        return Error.NO_ERROR;
    }

    private Error checkMovementString(String instructions){
        return Error.NO_ERROR;
    }

    private void goLeft(){
        Direction direction = this.d;
        switch (direction) {
            case EAST:
                this.d = Direction.NORTH;
                break;
            case SOUTH:
                this.d = Direction.EAST;
                break;
            default:
                System.out.println("Um.. You passed me what!");
        }
    }

    private void goRight(){

    }

    private Error move(){
        return Error.NO_ERROR;
    }
}
