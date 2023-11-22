package org.example.model.game.arena;

import org.example.model.game.elements.IceCream;
import org.example.model.game.elements.monsters.Monster;
import org.example.model.game.elements.Wall;

import java.util.List;

public abstract class ArenaBuilder {public Arena createArena() {
    Arena arena = new Arena(getWidth(), getHeight());

    arena.setIceCream(createIceCream());
    arena.setMonsters(createMonsters());
    arena.setWalls(createWalls());

    return arena;
}

    protected abstract int getWidth();

    protected abstract int getHeight();

    protected abstract List<Wall> createWalls();

    protected abstract List<Monster> createMonsters();

    protected abstract IceCream createIceCream();
}
