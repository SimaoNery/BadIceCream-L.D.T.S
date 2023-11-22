package org.example.model.game.elements.fruits;

import org.example.model.game.elements.fruits.Fruit;

public class PepperFruit extends Fruit {
    private final int type = 3;
    public PepperFruit(int x, int y) {
        super(x, y);
    }
    public int getType() {return type;}
}
