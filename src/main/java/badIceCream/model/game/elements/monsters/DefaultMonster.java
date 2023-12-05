package badIceCream.model.game.elements.monsters;

import badIceCream.GUI.GUI;

public class DefaultMonster extends Monster {
    public DefaultMonster(int x, int y) {
        super(x, y);
    }
    @Override
    public int getType() {return 1;}
}
