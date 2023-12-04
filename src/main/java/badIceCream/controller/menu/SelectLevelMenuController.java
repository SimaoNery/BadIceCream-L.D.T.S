package badIceCream.controller.menu;

import badIceCream.GUI.GUI;
import badIceCream.GUI.GameGraphics;
import badIceCream.Game;
import badIceCream.model.game.arena.Arena;
import badIceCream.model.game.arena.LoaderArenaBuilder;
import badIceCream.model.menu.SelectLevelMenu;
import badIceCream.states.GameState;

import java.io.IOException;

public class SelectLevelMenuController extends MenuController<SelectLevelMenu> {
    public SelectLevelMenuController(SelectLevelMenu menu) {
        super(menu);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case LEFT:
                getModel().previousEntry();
                break;
            case RIGHT:
                getModel().nextEntry();
                break;
            case SELECT:
                if (getModel().isSelectedLevel1()){
                    game.setAudioController("LevelMusic.wav");
                    Arena arena = new LoaderArenaBuilder(1).createArena();
                    game.setState(new GameState(arena, game.getState().getLevel()), new GameGraphics(arena.getWidth(), arena.getHeight(), arena));
                }
                if (getModel().isSelectedLevel2() && game.getState().getLevel() >= 2){
                    game.setAudioController("LevelMusic.wav");
                    Arena arena = new LoaderArenaBuilder(2).createArena();
                    game.setState(new GameState(arena, game.getState().getLevel()), new GameGraphics(arena.getWidth(), arena.getHeight(), arena));
                }
                if (getModel().isSelectedLevel3() && game.getState().getLevel() >= 3){
                    game.setAudioController("LevelMusic.wav");
                    Arena arena = new LoaderArenaBuilder(3).createArena();
                    game.setState(new GameState(arena, game.getState().getLevel()), new GameGraphics(arena.getWidth(), arena.getHeight(), arena));
                }
                if (getModel().isSelectedLevel4() && game.getState().getLevel() >= 4){
                    game.setAudioController("LevelMusic.wav");
                    Arena arena = new LoaderArenaBuilder(4).createArena();
                    game.setState(new GameState(arena, game.getState().getLevel()), new GameGraphics(arena.getWidth(), arena.getHeight(), arena));
                }
                if (getModel().isSelectedLevel5() && game.getState().getLevel() >= 5){
                    game.setAudioController("LevelMusic.wav");
                    Arena arena = new LoaderArenaBuilder(5).createArena();
                    game.setState(new GameState(arena, game.getState().getLevel()), new GameGraphics(arena.getWidth(), arena.getHeight(), arena));
                }

        }
    }
}
