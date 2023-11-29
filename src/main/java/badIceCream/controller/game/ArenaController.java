package badIceCream.controller.game;

import badIceCream.Game;
import badIceCream.controller.game.monsters.DefaultMovement;
import badIceCream.model.game.arena.Arena;
import badIceCream.GUI.GUI;
import badIceCream.model.game.elements.monsters.Monster;
import badIceCream.model.menu.MainMenu;
import badIceCream.states.MainMenuState;


import java.io.IOException;
import java.util.List;

public class ArenaController extends GameController {
    private final IceCreamController iceCreamController;
    private List<MonsterController> monsterController;

    public ArenaController(Arena arena) {
        super(arena);
        this.iceCreamController = new IceCreamController(arena);

        for (Monster m : arena.getMonsters()) {
            switch (m.getType()) {
                case 1: monsterController.add(new MonsterController(new DefaultMovement(arena), m, 750));
                    break;
                case 2: monsterController.add(new MonsterController(new DefaultMovement(arena), m, 500));
                    break;
                case 3: monsterController.add(new MonsterController(new DefaultMovement(arena), m, 250));
                    break;
                case 4: monsterController.add(new MonsterController(new DefaultMovement(arena), m, 500));
                    break;
            }
        }
    }

    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.QUIT || getModel().getIceCream().getAlive())
            game.setState(new MainMenuState(new MainMenu()));
        else {
            iceCreamController.step(game, action, time);
            for (MonsterController m : monsterController) {
                m.step(action, time);
            }
        }
    }
}