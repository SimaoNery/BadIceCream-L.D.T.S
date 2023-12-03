package badIceCream.model.game.elements.monsters;

import badIceCream.GUI.GUI;

public class JumperMonster extends Monster {
    public JumperMonster(int x, int y) {
        super(x, y);
    }

    @Override
    public int getType() {return 2;}

}
