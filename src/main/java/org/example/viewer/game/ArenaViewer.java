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
    private <T extends Element> void drawElement(GUI gui, T element, ElementViewer<T> viewer) {
        viewer.draw(element, gui);
    }

    @Override
    public void drawElements(GUI gui) {
        for (Wall wall : getModel().getWalls()) {
            drawElement(gui, wall, new WallViewer());
        }

        drawElement(gui, getModel().getIceCream(), new IceCreamViewer());

        for(Monster monster : getModel().getMonsters()){
            drawElement(gui, monster, new MonsterViewer());
        }

    }
}
