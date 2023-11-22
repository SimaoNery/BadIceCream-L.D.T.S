package org.example.model.elements;

public class RunnerMonster extends Monster{
    private boolean run = false;
    public RunnerMonster(int x, int y) {
        super(x, y);
    }
    public void startRunning() {this.run = true;}
    public void stopRunning(){this.run = false;}
}
