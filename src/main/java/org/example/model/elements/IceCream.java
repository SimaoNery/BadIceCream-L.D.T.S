package org.example.model.elements;

public class IceCream extends Element{
    private int health;
    public IceCream(int x, int y) {
        super(x, y);
    }
    public void decreaseHealth() {health--;}
    public int getHealth() {return health;}
}
