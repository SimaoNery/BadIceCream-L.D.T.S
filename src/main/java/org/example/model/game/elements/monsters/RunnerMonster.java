package org.example.model.game.elements.monsters;

import org.example.model.game.elements.monsters.Monster;

public class RunnerMonster extends Monster {
    private final int type = 3;
    private boolean run = false;
    public RunnerMonster(int x, int y) {
        super(x, y);
    }
    public void startRunning() {this.run = true;}
    public void stopRunning() {this.run = false;}

    public boolean isRunning() {return run;}
    @Override
    public int getType() {return type;}
}
