package org.example.viewer.game;

import org.example.GUI.GUI;
import org.example.model.Position;
import org.example.model.game.arena.Arena;
import org.example.model.game.elements.Element;
import org.example.model.game.elements.IceWall;
import org.example.model.game.elements.StoneWall;
import org.example.model.game.elements.Wall;
import org.example.model.game.elements.fruits.Fruit;
import org.example.model.game.elements.monsters.*;
import org.example.viewer.Viewer;

import java.util.List;

public class ArenaViewer extends Viewer<Arena> {
    public ArenaViewer(Arena arena){
        super(arena);
    }
    private <T extends Element, P extends ElementViewer<T>> void drawElement(GUI gui, T element, ElementViewer<P> viewer) {
        viewer.draw(element, gui);
    }

    @Override
    <P extends Element>
    public void drawElements(GUI gui) {
        drawElement(gui, getModel().getIceCream(), new IceCreamViewer());
        for(P wall : getModel().getWalls()){
            if(wall.getType() == 1){drawElement(gui, wall, new IceWallViewer());}
            else{drawElement(gui, StoneWall, new StoneWallViewer());}
        }
        for(Monster monster : getModel().getMonsters()){
            if(monster.getType() == 1){
                drawElement(gui, DefaultMonster, new DefaultMonsterViewer());
            }
            else if(monster.getType() == 2){
                drawElement(gui, JumperMonster, new JumperMonsterViewer());
            }
            else if(monster.getType() == 3){
                drawElement(gui, RunnerMonster, new RunnerMonsterViewer());
            }
            else{
                drawElement(gui, WallBreakerMonster, new WallBreakerMonsterViewer());
            }
        }
        for(Fruit fruit : getModel().)
    }
}
