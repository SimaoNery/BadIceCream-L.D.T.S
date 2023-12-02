package badIceCream.model.game.elements;

public class IceCream extends Element {
    private boolean alive;

    private boolean strawberry;
    public IceCream(int x, int y) {
        super(x, y);
        alive = true;
        strawberry = false;
    }

    public boolean getAlive() {
        return alive;
    }

    public void changeAlive() {
        this.alive = !this.alive;
    }

    public boolean isStrawberryActive() {
        return this.strawberry;
    }

    public void setStrawberry(boolean bool) {
        this.strawberry = bool;
    }
}
