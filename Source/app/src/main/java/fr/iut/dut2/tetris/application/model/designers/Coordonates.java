package fr.iut.dut2.tetris.application.model.designers;

public class Coordonates {
    private int x;
    public int getX(){ return x; }
    public void setX(int x){ this.x = x; }

    private int y;
    public int getY(){ return y; }
    public void setY(int y){ this.y = y; }

    public Coordonates(int x, int y){
        this.x = x;
        this.y = y;
    }
}
