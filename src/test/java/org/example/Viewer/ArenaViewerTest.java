package org.example.Viewer;

import org.example.GUI.GUI;
import org.example.model.Position;
import org.example.model.game.arena.Arena;
import org.example.model.game.elements.IceCream;
import org.example.model.game.elements.IceWall;
import org.example.model.game.elements.StoneWall;
import org.example.model.game.elements.fruits.*;
import org.example.model.game.elements.monsters.*;
import org.example.viewer.game.ArenaViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Arrays;

public class ArenaViewerTest {
    private GUI gui;
    private ArenaViewer viewer;

    @BeforeEach
    void setUp() {
        Arena arena = new Arena(10, 10);
        gui = Mockito.mock(GUI.class);

        viewer = new ArenaViewer(arena);

        arena.setWalls(Arrays.asList(
                new IceWall(1, 1), new IceWall(2, 2), new IceWall(3, 3),
                new StoneWall(4, 4), new StoneWall(5, 5), new StoneWall(6, 6)));

        arena.setMonsters(Arrays.asList(
                new DefaultMonster(1, 2), new DefaultMonster(1, 3),
                new JumperMonster(1, 4), new JumperMonster(1, 5),
                new RunnerMonster(1, 6), new RunnerMonster(1, 7),
                new WallBreakerMonster(1, 8), new WallBreakerMonster(1, 9)));

        arena.setIceCream(new IceCream(5, 8));

        arena.setFruits(Arrays.asList(
                new AppleFruit(2, 3), new AppleFruit(2, 4),
                new BananaFruit(2, 5), new BananaFruit(2, 6),
                new PepperFruit(2, 7), new PepperFruit(2, 8),
                new PineappleFruit(3, 4), new PineappleFruit(3, 5),
                new StrawberryFruit(3, 6), new StrawberryFruit(3, 7)));
    }
    @Test
    void drawIceWalls() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawIceWall(new Position(1, 1));
        Mockito.verify(gui, Mockito.times(1)).drawIceWall(new Position(2, 2));
        Mockito.verify(gui, Mockito.times(1)).drawIceWall(new Position(3, 3));
        Mockito.verify(gui, Mockito.times(3)).drawIceWall(Mockito.any(Position.class));
    }
    @Test
    void drawStoneWalls() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawStoneWall(new Position(4, 4));
        Mockito.verify(gui, Mockito.times(1)).drawStoneWall(new Position(5, 5));
        Mockito.verify(gui, Mockito.times(1)).drawStoneWall(new Position(6, 6));
        Mockito.verify(gui, Mockito.times(3)).drawStoneWall(Mockito.any(Position.class));
    }

    @Test
    void drawDefaultMonsters() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawDefaultMonster(new Position(1, 2));
        Mockito.verify(gui, Mockito.times(1)).drawDefaultMonster(new Position(1, 3));
        Mockito.verify(gui, Mockito.times(2)).drawDefaultMonster(Mockito.any(Position.class));
    }
    @Test
    void drawJumperMonsters() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawJumperMonster(new Position(1, 4));
        Mockito.verify(gui, Mockito.times(1)).drawJumperMonster(new Position(1, 5));
        Mockito.verify(gui, Mockito.times(2)).drawJumperMonster(Mockito.any(Position.class));
    }
    @Test
    void drawRunnerMonsters() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawRunnerMonster(new Position(1, 6));
        Mockito.verify(gui, Mockito.times(1)).drawRunnerMonster(new Position(1, 7));
        Mockito.verify(gui, Mockito.times(2)).drawJumperMonster(Mockito.any(Position.class));
    }
    @Test
    void drawWallBreakerMonsters() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawWallBreakerMonster(new Position(1, 8));
        Mockito.verify(gui, Mockito.times(1)).drawWallBreakerMonster(new Position(1, 9));
        Mockito.verify(gui, Mockito.times(2)).drawWallBreakerMonster(Mockito.any(Position.class));
    }

    @Test
    void drawIceCream() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawIceCream(new Position(5, 8));
        Mockito.verify(gui, Mockito.times(1)).drawIceCream(Mockito.any(Position.class));
    }
    @Test
    void drawAppleFruit() throws IOException{
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawAppleFruit(new Position(2, 3));
        Mockito.verify(gui, Mockito.times(1)).drawAppleFruit(new Position(2, 4));
        Mockito.verify(gui, Mockito.times(2)).drawAppleFruit(Mockito.any(Position.class));
    }
    @Test
    void drawBananaFruit() throws IOException{
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawBananaFruit(new Position(2, 5));
        Mockito.verify(gui, Mockito.times(1)).drawBananaFruit(new Position(2, 6));
        Mockito.verify(gui, Mockito.times(2)).drawBananaFruit(Mockito.any(Position.class));
    }
    @Test
    void drawPepperFruit() throws IOException{
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawPepperFruit(new Position(2, 7));
        Mockito.verify(gui, Mockito.times(1)).drawPepperFruit(new Position(2, 8));
        Mockito.verify(gui, Mockito.times(2)).drawPepperFruit(Mockito.any(Position.class));
    }
    @Test
    void drawPineappleFruit() throws IOException{
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawPineappleFruit(new Position(3, 4));
        Mockito.verify(gui, Mockito.times(1)).drawPineappleFruit(new Position(3, 5));
        Mockito.verify(gui, Mockito.times(2)).drawPineappleFruit(Mockito.any(Position.class));
    }
    @Test
    void drawStrawberryFruit() throws IOException{
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawStrawberryFruit(new Position(3, 6));
        Mockito.verify(gui, Mockito.times(1)).drawStrawberryFruit(new Position(3, 7));
        Mockito.verify(gui, Mockito.times(2)).drawStrawberryFruit(Mockito.any(Position.class));
    }

    @Test
    void refreshAndClear() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).clear();
        Mockito.verify(gui, Mockito.times(1)).refresh();
    }
}
