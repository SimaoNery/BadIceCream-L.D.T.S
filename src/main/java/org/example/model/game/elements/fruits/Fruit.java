package org.example.model.game.elements.fruits;

import org.example.model.game.elements.Element;

public abstract class Fruit extends Element {
    public Fruit(int x, int y) {
        super(x, y);
    }
    abstract public int getType();
}
