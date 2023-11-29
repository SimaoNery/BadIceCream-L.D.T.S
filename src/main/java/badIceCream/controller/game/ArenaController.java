package badIceCream.controller.game;

import badIceCream.Game;
import badIceCream.controller.game.monsters.DefaultMovement;
import badIceCream.controller.game.monsters.JumperMovement;
import badIceCream.controller.game.monsters.WallBreakerMovement;
import badIceCream.model.game.arena.Arena;
import badIceCream.GUI.GUI;
import badIceCream.model.game.elements.monsters.Monster;
import badIceCream.model.menu.MainMenu;
import badIceCream.states.MainMenuState;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ArenaController extends GameController {
    private final IceCreamController iceCreamController;
    private final List<MonsterController> monsterController;

    public ArenaController(Arena arena) {
        super(arena);
        this.iceCreamController = new IceCreamController(arena);
        monsterController = new ArrayList<>();

        for (Monster m : arena.getMonsters()) {
            switch (m.getType()) {
                case 1: monsterController.add(new MonsterController(arena, new DefaultMovement(), m, 750));
                    break;
                case 2: monsterController.add(new MonsterController(arena, new JumperMovement(), m, 500));
                    break;
                case 3: monsterController.add(new MonsterController(arena, new DefaultMovement(), m, 250));
                    break;
                case 4: monsterController.add(new MonsterController(arena, new WallBreakerMovement(), m, 500));
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
                m.step(time);
            }
        }
    }
}