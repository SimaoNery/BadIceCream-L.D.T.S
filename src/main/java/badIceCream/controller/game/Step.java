package badIceCream.controller.game;

import badIceCream.GUI.GUI;
import badIceCream.model.Position;
import badIceCream.model.game.elements.monsters.Monster;

import java.io.IOException;

public interface Step {
    void step(Monster monster, GUI.ACTION action, long time, int TIME_CONST) throws IOException;
    void moveMonster(Monster monster, Position position);
}
