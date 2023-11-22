package org.example.model.game.arena;

import org.example.model.Position;
import org.example.model.game.elements.IceCream;
import org.example.model.game.elements.IceWall;
import org.example.model.game.elements.monsters.Monster;
import org.example.model.game.elements.Wall;

import java.util.List;

public class Arena {
    private final int width;
    private final int height;
    private IceCream iceCream;
    private List<Monster> monsters;
    private List<Wall> walls;

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
    public void setIceCream(IceCream iceCream) {
        this.iceCream = iceCream;
    }
    public List<Monster> getMonsters() {
        return monsters;
    }

    public void setMonsters(List<Monster> monsters) {
        this.monsters = monsters;
    }

    public List<Wall> getWalls() {
        return walls;
    }

    public void setWalls(List<Wall> walls) {
        this.walls = walls;
    }
    public boolean isEmpty(Position position) {
        for (Wall wall : walls)
            if (wall.getPosition().equals(position))
                return false;
        return true;
    }
    public boolean isIceWall(Position position) {
        for (Wall wall : walls) {
            if (wall instanceof IceWall && wall.getPosition().equals(position)) {
                return true;
            }
        }
        return true;
    }
    public boolean isMonster(Position position) {
        for (Monster monster : monsters)
            if (monster.getPosition().equals(position))
                return true;
        return false;
    }
}
