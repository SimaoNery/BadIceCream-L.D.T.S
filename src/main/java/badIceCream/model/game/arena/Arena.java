package badIceCream.model.game.arena;

import badIceCream.Exceptions.StoneWallDestroyedException;
import badIceCream.GUI.GUI;
import badIceCream.model.Position;

import badIceCream.model.game.elements.*;
import badIceCream.model.game.elements.fruits.Fruit;
import badIceCream.model.game.elements.monsters.Monster;


import java.util.List;

public class Arena {
    private final int width;
    private final int height;
    private IceCream iceCream;
    private List<Monster> monsters;
    private List<Wall> walls;
    private List<Fruit> fruits;
    private List<HotFloor> hotFloors;

    public Arena(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public IceCream getIceCream() {
        return iceCream;
    }
    public List<Monster> getMonsters() {
        return monsters;
    }
    public List<Wall> getWalls() {
        return walls;
    }
    public List<Fruit> getFruits(){return fruits;}
    public void setIceCream(IceCream iceCream) {
        this.iceCream = iceCream;
    }

    public List<HotFloor> getHotFloors() {
        return hotFloors;
    }

    public void setMonsters(List<Monster> monsters) {
        this.monsters = monsters;
    }
    public void setFruits(List<Fruit> fruits) {
        this.fruits = fruits;
    }
    public void setWalls(List<Wall> walls) {
        this.walls = walls;
    }
    public void setHotFloors(List<HotFloor> hotFloors) {
        this.hotFloors = hotFloors;
    }

    public boolean isEmpty(Position position) {
        for (Wall wall : walls)
            if (wall.getPosition().equals(position))
                return false;
        return true;
    }

    public boolean isEmptyMonsters(Position position) {
        for (Wall wall : walls)
            if (wall.getPosition().equals(position))
                return false;
        for (Monster monster : monsters) {
            if (monster.getPosition().equals(position)) {
                return false;
            }
        }
        return true;
    }

    public boolean isEmptyNoStoneWall(Position position) {
        for (Wall wall : walls)
            if (wall instanceof StoneWall && wall.getPosition().equals(position))
                return false;
        for (Monster monster : monsters) {
            if (monster.getPosition().equals(position)) {
                return false;
            }
        }
        return true;
    }

    public boolean isHotFloor(Position position) {
        for(HotFloor hotFloor : hotFloors) {
            if (position.equals(hotFloor.getPosition()))
                return true;
        }
        return false;
    }

    public void iceWallDestroyed(Position position) throws StoneWallDestroyedException {
        for (Wall wall : walls) {
            if (wall.getPosition().equals(position) && wall instanceof StoneWall) {
                throw new StoneWallDestroyedException();
            }
            if (wall.getPosition().equals(position)) {
                walls.remove(wall);
                return;
            }
        }
    }
    public boolean isIceWall(Position position) {
        for (Wall wall : walls) {
            if (wall instanceof IceWall && wall.getPosition().equals(position)) {
                return true;
            }
        }
        return false;
    }
    public boolean isMonster(Position position) {
        for (Monster monster : monsters)
            if (monster.getPosition().equals(position))
                return true;
        return false;
    }
    public boolean isFruit(Position position) {
        for (Fruit fruit : fruits) {
            if (fruit.getPosition().equals(position))
                return true;
        }
        return false;
    }

    public void powerIceCream(GUI.ACTION lastMovement) {
        switch (lastMovement) {
            case UP: {
                if (isIceWall(iceCream.getPosition().getUp())) {
                    destroyIceWall(0, -1);
                }
                else {
                    constroyIceWall(0, -1);
                }
                break;
            }
            case DOWN: {
                if (isIceWall(iceCream.getPosition().getDown())) {
                    destroyIceWall(0, 1);
                }
                else {
                    constroyIceWall(0, 1);
                }
                break;
            }
            case RIGHT: {
                if (isIceWall(iceCream.getPosition().getRight())) {
                    destroyIceWall(1, 0);
                }
                else {
                    constroyIceWall(1, 0);
                }
                break;
            }
            case LEFT: {
                if (isIceWall(iceCream.getPosition().getLeft())) {
                    destroyIceWall(-1, 0);
                }
                else {
                    constroyIceWall(-1, 0);
                }
                break;
            }
        }
    }

    private void destroyIceWall(int deltaX, int deltaY) {
        Position pos = new Position(iceCream.getPosition().getX() + deltaX, iceCream.getPosition().getY() + deltaY);

        while (isIceWall(pos)) {
            try {
                iceWallDestroyed(pos);
                pos.setX(pos.getX() + deltaX);
                pos.setY(pos.getY() + deltaY);
            }
            catch (StoneWallDestroyedException e) {
                System.err.println("Error: " + e.getMessage());
                break;
            }
        }
    }

    private void createIceWall(Position pos) {
        IceWall newIceWall = new IceWall(pos.getX(), pos.getY());
        walls.add(newIceWall);
    }

    private void constroyIceWall(int deltaX, int deltaY) {
        Position pos = new Position(iceCream.getPosition().getX() + deltaX, iceCream.getPosition().getY() + deltaY);

        while (isEmptyMonsters(pos) && !isHotFloor(pos)) {
            createIceWall(pos);
            pos.setX(pos.getX() + deltaX);
            pos.setY(pos.getY() + deltaY);
        }
    }
}
