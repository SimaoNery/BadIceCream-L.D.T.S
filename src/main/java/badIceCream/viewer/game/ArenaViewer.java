package badIceCream.viewer.game;

import badIceCream.GUI.GUI;
import badIceCream.GUI.GameGraphics;
import badIceCream.GUI.Graphics;
import badIceCream.model.game.arena.Arena;
import badIceCream.model.game.elements.Element;
import badIceCream.model.game.elements.HotFloor;
import badIceCream.model.game.elements.Wall;
import badIceCream.model.game.elements.fruits.Fruit;
import badIceCream.model.game.elements.monsters.Monster;
import badIceCream.viewer.Viewer;

public class ArenaViewer extends Viewer<Arena> {
    public ArenaViewer(Arena arena){
        super(arena);
    }
    private <T extends Element> void drawElement(Graphics gui, T element, ElementViewer<T> viewer) {
        viewer.draw(element, gui);
    }
    @Override
    public void drawElements(Graphics gui) {
        for (Wall wall : getModel().getWalls()) {
            drawElement(gui, wall, new WallViewer());
        }

        drawElement(gui, getModel().getIceCream(), new IceCreamViewer());

        for(Monster monster : getModel().getMonsters()){
            drawElement(gui, monster, new MonsterViewer());
        }

        for (Fruit fruit : getModel().getFruits()){
            drawElement(gui, fruit, new FruitViewer());
        }
        for(HotFloor hotFloor : getModel().getHotFloors()){
            drawElement(gui, hotFloor, new HotFloorViewer());
        }
    }
}
