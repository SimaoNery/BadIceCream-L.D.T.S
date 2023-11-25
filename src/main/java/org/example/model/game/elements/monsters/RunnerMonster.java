package org.example.model.game.elements.monsters;


public class RunnerMonster extends Monster {
    private boolean run = false;
    public RunnerMonster(int x, int y) {
        super(x, y);
    }
    public void startRunning() {this.run = true;}
    public void stopRunning() {this.run = false;}

    public boolean isRunning() {return run;}
    @Override
    public int getType() {return 3;}
}
