package org.example.model.game.elements;

public class IceWall extends Wall{
    private final int type = 1;
    public IceWall(int x, int y) {
        super(x, y);
    }

    public int getType() {return type;}
}
