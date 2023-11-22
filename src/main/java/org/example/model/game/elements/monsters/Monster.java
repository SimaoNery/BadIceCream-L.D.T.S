package org.example.model.game.elements.monsters;

import org.example.model.game.elements.Element;

public abstract class Monster extends Element {

    public Monster(int x, int y) {
        super(x, y);
    }
    abstract public int getType();
}
