package org.example.model.game.elements;

public abstract class Wall extends Element{
    public Wall(int x, int y) {
        super(x, y);
    }

    public abstract int getType();
}
