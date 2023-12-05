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
    private <T extends Element> void drawElement(Graphics gui, T element, ElementViewer<T> viewer, int type) {
        viewer.draw(element, gui, type);
    }
    @Override
    public void drawElements(Graphics gui) {

        for(HotFloor hotFloor : model.getHotFloors()){
            drawElement(gui, hotFloor, new HotFloorViewer(), hotFloor.getType());
        }

        for (Fruit fruit : model.getFruits()){
            drawElement(gui, fruit, new FruitViewer(), fruit.getType());
        }

        for(Monster monster : model.getMonsters()){
            drawElement(gui, monster, new MonsterViewer(), monster.getType());
        }

        for (Wall wall : model.getWalls()) {
            int type = wall.getType();
            if (type == 2) {
                drawElement(gui, wall, new WallViewer(), type);
            }
            else {
                int fruit = model.isFruit(wall.getPosition());
                switch (fruit) {
                    case 1: drawElement(gui, wall, new WallViewer(), 3);
                        break;
                    case 2: drawElement(gui, wall, new WallViewer(), 4);
                        break;
                    case 3: drawElement(gui, wall, new WallViewer(), 5);
                        break;
                    case 4: drawElement(gui, wall, new WallViewer(), 6);
                        break;
                    case 5: drawElement(gui, wall, new WallViewer(), 7);
                        break;
                    default: drawElement(gui, wall, new WallViewer(), 1);
                }

                Monster monster = model.hasMonster(wall.getPosition());
                if (monster != null) {
                    if (monster.getType() == 2) {
                        switch (monster.getLastAction()) {
                            case UP: drawElement(gui, wall, new WallViewer(), 9);
                                break;
                            case RIGHT: drawElement(gui, wall, new WallViewer(), 10);
                                break;
                            case LEFT: drawElement(gui, wall, new WallViewer(), 11);
                                break;
                            default: drawElement(gui, wall, new WallViewer(), 8);
                        }
                    }
                }
            }
        }


        drawElement(gui, getModel().getIceCream(), new IceCreamViewer(), 1);
    }
}
