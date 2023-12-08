package badIceCream.viewer.game;

import badIceCream.GUI.Graphics;
import badIceCream.model.game.arena.Arena;
import badIceCream.model.game.elements.Element;
import badIceCream.model.game.elements.HotFloor;
import badIceCream.model.game.elements.IceCream;
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

        for(HotFloor hotFloor : model.getHotFloors()){
            int fruit = model.isFruit(hotFloor.getPosition());
            IceCream iceCream = model.getIceCream();

            Monster monster = model.hasMonster(hotFloor.getPosition());
            if (monster != null) {
                switch (monster.getType()) {
                    case 1: switch (monster.getLastAction()) {
                        case UP: drawElement(gui, hotFloor, new HotFloorViewer(), 1);
                            break;
                        case RIGHT: drawElement(gui, hotFloor, new HotFloorViewer(), 2);
                            break;
                        case LEFT: drawElement(gui, hotFloor, new HotFloorViewer(), 3);
                            break;
                        default: drawElement(gui, hotFloor, new HotFloorViewer(), 4);
                    }
                        break;
                    case 2: switch (monster.getLastAction()) {
                        case UP: drawElement(gui, hotFloor, new HotFloorViewer(), 5);
                            break;
                        case RIGHT: drawElement(gui, hotFloor, new HotFloorViewer(), 6);
                            break;
                        case LEFT: drawElement(gui, hotFloor, new HotFloorViewer(), 7);
                            break;
                        default: drawElement(gui, hotFloor, new HotFloorViewer(), 8);
                    }
                        break;
                    case 3: {
                        if (!monster.isRunning()) {
                            switch (monster.getLastAction()) {
                                case UP:
                                    drawElement(gui, hotFloor, new HotFloorViewer(), 9);
                                    break;
                                case RIGHT:
                                    drawElement(gui, hotFloor, new HotFloorViewer(), 10);
                                    break;
                                case LEFT:
                                    drawElement(gui, hotFloor, new HotFloorViewer(), 11);
                                    break;
                                default:
                                    drawElement(gui, hotFloor, new HotFloorViewer(), 12);
                            }
                        }
                        else {
                            switch (monster.getLastAction()) {
                                case UP:
                                    drawElement(gui, hotFloor, new HotFloorViewer(), 13);
                                    break;
                                case RIGHT:
                                    drawElement(gui, hotFloor, new HotFloorViewer(), 14);
                                    break;
                                case LEFT:
                                    drawElement(gui, hotFloor, new HotFloorViewer(), 15);
                                    break;
                                default:
                                    drawElement(gui, hotFloor, new HotFloorViewer(), 16);
                            }
                        }
                    }
                    break;
                    case 4: switch (monster.getLastAction()) {
                        case UP: drawElement(gui, hotFloor, new HotFloorViewer(), 17);
                            break;
                        case RIGHT: drawElement(gui, hotFloor, new HotFloorViewer(), 18);
                            break;
                        case LEFT: drawElement(gui, hotFloor, new HotFloorViewer(), 19);
                            break;
                        default: drawElement(gui, hotFloor, new HotFloorViewer(), 20);
                    }
                }
            }
            else if (fruit != -1) {
                switch (fruit) {
                    case 1: drawElement(gui, hotFloor, new HotFloorViewer(), 21);
                        break;
                    case 2: drawElement(gui, hotFloor, new HotFloorViewer(), 22);
                        break;
                    case 3: drawElement(gui, hotFloor, new HotFloorViewer(), 23);
                        break;
                    case 4: drawElement(gui, hotFloor, new HotFloorViewer(), 24);
                        break;
                    case 5: drawElement(gui, hotFloor, new HotFloorViewer(), 25);
                        break;
                }
            }
            else if (iceCream.getPosition().equals(hotFloor.getPosition())) {
                switch (iceCream.getLastMovement()) {
                    case UP: drawElement(gui, hotFloor, new HotFloorViewer(), 26);
                        break;
                    case RIGHT: drawElement(gui, hotFloor, new HotFloorViewer(), 27);
                        break;
                    case LEFT: drawElement(gui, hotFloor, new HotFloorViewer(), 28);
                        break;
                    default: drawElement(gui, hotFloor, new HotFloorViewer(), 29);
                }
            }
            else {drawElement(gui, hotFloor, new HotFloorViewer(), 0);}
        }
    }
}
