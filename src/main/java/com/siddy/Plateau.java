package com.siddy;

public class Plateau {
    int X_MIN = 0;
    int Y_MIN = 0;
    int X_MAX;
    int Y_MAX;

    public void Plateau(int x, int y) {
        this.X_MAX = x;
        this.Y_MAX = y;
    }

    public int getYMax(){
        return this.Y_MAX;
    }
    public int getXMax(){
        return this.X_MAX;
    }
//    public Error move(int x, int y, Direction d){
//        return Error.
//    }
//+ move(x: int, y: int, d: Direction): Error
//- collisionCheck(): Error
//- edgeCheck(): Error

}
