package org.example.model.game.elements.monsters;

public class DefaultMonster extends Monster {
    private final int type = 1;
    public DefaultMonster(int x, int y) {
        super(x, y);
    }
    @Override
    public int getType() {return type;}
}
