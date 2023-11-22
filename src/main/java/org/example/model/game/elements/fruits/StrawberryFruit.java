package org.example.model.game.elements.fruits;

import org.example.model.game.elements.fruits.Fruit;

public class StrawberryFruit extends Fruit {
    private final int type = 5;
    public StrawberryFruit(int x, int y) {
        super(x, y);
    }
    public int getType() {return type;}
}
