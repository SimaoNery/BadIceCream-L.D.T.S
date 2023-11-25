package org.example.model.game.elements.monsters;

import org.example.model.game.elements.monsters.Monster;

public class WallBreakerMonster extends Monster {
    private final int type = 4;
    public WallBreakerMonster(int x, int y) {
        super(x, y);
    }
    @Override
    public int getType() {return type;}
}
