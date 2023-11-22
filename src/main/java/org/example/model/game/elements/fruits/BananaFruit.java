package org.example.model.game.elements.fruits;

public class BananaFruit extends Fruit {
    private final int type = 2;
    public BananaFruit(int x, int y) {
        super(x, y);
    }
    public int getType() {return type;}
}
