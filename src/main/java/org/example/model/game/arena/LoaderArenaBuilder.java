package org.example.model.game.arena;

import org.example.model.game.elements.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class LoaderArenaBuilder extends ArenaBuilder{
    private final int level;
    private final List<String> lines;

    public LoaderArenaBuilder(int level) throws IOException {
        this.level = level;

        URL resource = LoaderArenaBuilder.class.getResource("/levels/level" + level + ".lvl");
        BufferedReader br = new BufferedReader(new FileReader(resource.getFile()));

        lines = readLines(br);
    }

    private List<String> readLines(BufferedReader br) throws IOException {
        List<String> lines = new ArrayList<>();
        for (String line; (line = br.readLine()) != null; )
            lines.add(line);
        return lines;
    }

    @Override
    protected int getWidth() {
        int width = 0;
        for (String line : lines) width = Math.max(width, line.length());
        return width;
    }

    @Override
    protected int getHeight() {
        return lines.size();
    }

    @Override
    protected List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == '#') walls.add(new StoneWall(x, y));
                else if (line.charAt(x) == '=') walls.add(new StoneWall(x,y));
        }

        return walls;
    }

    @Override
    protected List<Monster> createMonsters() {
        List<Monster> monsters = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'D') monsters.add(new DefaultMonster(x, y));
                else if (line.charAt(x) == 'J') monsters.add(new JumperMonster(x, y));
                else if (line.charAt(x) == 'R') monsters.add(new RunnerMonster(x, y));
                else if (line.charAt(x) == 'W') monsters.add(new WallBreakerMonster(x, y));
        }
        return monsters;
    }

    @Override
    protected IceCream createIceCream() {
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'I') return new IceCream(x, y);
        }
        return null;
    }

    @Override
    protected List<Fruit> createFruits() {
        List<Fruit> fruits = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'B') fruits.add(new BananaFruit(x,y));
                else if (line.charAt(x) == 'S') fruits.add(new StrawberryFruit(x,y));
                else if (line.charAt(x) == 'P') fruits.add(new PepperFruit(x,y));
                else if (line.charAt(x) == 'N') fruits.add(new PineappleFruit(x,y));
                else if (line.charAt(x) == 'Q') fruits.add(new PineappleFruit(x,y));
        }
        return fruits;
    }
}
