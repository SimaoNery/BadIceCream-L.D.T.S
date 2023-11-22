package org.example.model.game.elements.fruits;

public class AppleFruit extends Fruit {
    private final int type = 1;
    public AppleFruit(int x, int y) {
        super(x, y);
    }
    public int getType() {return type;}
}
