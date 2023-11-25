package badIceCream.controller.game;

import badIceCream.model.game.elements.monsters.Monster;
import badIceCream.GUI.GUI;
import badIceCream.model.Position;

import java.io.IOException;

public interface MonsterController {
    void step(Monster monster, GUI.ACTION action, long time) throws IOException;
    void moveMonster(Monster monster, Position position);
}
