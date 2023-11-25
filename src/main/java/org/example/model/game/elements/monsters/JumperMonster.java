package org.example.model.game.elements.monsters;

public class JumperMonster extends Monster {
    private final int type = 2;
    public JumperMonster(int x, int y) {
        super(x, y);
    }

    @Override
    public int getType() {return type;}
}
