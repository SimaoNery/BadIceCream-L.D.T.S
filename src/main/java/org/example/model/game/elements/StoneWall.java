package org.example.model.game.elements;

public class StoneWall extends Wall{

    private final int type = 2;
    public StoneWall(int x, int y) {
        super(x, y);
    }

    @Override
    public int getType() {return type;}
}
