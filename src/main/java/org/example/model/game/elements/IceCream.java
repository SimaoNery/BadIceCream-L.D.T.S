package org.example.model.game.elements;

public class IceCream extends Element {

    private boolean alive;
    public IceCream(int x, int y) {
        super(x, y);
        alive = true;
    }

    public boolean getAlive() {
        return alive;
    }

    public void changeAlive() {
        this.alive = !this.alive;
    }
}
