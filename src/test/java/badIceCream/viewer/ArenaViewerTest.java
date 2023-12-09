package badIceCream.viewer;

import badIceCream.GUI.Graphics;
import badIceCream.model.game.arena.Arena;
import badIceCream.model.game.elements.HotFloor;
import badIceCream.model.game.elements.IceCream;
import badIceCream.model.game.elements.IceWall;
import badIceCream.model.game.elements.StoneWall;
import badIceCream.model.game.elements.fruits.*;
import badIceCream.model.game.elements.monsters.DefaultMonster;
import badIceCream.model.game.elements.monsters.JumperMonster;
import badIceCream.model.game.elements.monsters.RunnerMonster;
import badIceCream.model.game.elements.monsters.WallBreakerMonster;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import static org.mockito.Mockito.*;


public class ArenaViewerTest {
    @Mock
    private Arena arena;
    private ArenaViewer viewer;
    @Mock
    private IceCream iceCream;
    @Mock
    private Graphics graphics;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);

        viewer = new ArenaViewer(arena);

        iceCream = mock(IceCream.class);
        when(arena.getIceCream()).thenReturn(iceCream);
    }

    @Test
    void drawSingleFruits() {
        AppleFruit apple = mock(AppleFruit.class);
        BananaFruit banana = mock(BananaFruit.class);
        PepperFruit pepper = mock(PepperFruit.class);
        PineappleFruit pineapple = mock(PineappleFruit.class);
        StrawberryFruit strawberry = mock(StrawberryFruit.class);

        FruitViewer fruitViewer = mock(FruitViewer.class);

        viewer.drawElement(graphics, apple, fruitViewer, 1);
        viewer.drawElement(graphics, banana, fruitViewer, 2);
        viewer.drawElement(graphics, pepper, fruitViewer, 3);
        viewer.drawElement(graphics, pineapple, fruitViewer, 4);
        viewer.drawElement(graphics, strawberry, fruitViewer, 5);

        verify(fruitViewer, times(1)).draw(apple, graphics, 1);
        verify(fruitViewer, times(1)).draw(banana, graphics, 2);
        verify(fruitViewer, times(1)).draw(pepper, graphics, 3);
        verify(fruitViewer, times(1)).draw(pineapple, graphics, 4);
        verify(fruitViewer, times(1)).draw(strawberry, graphics, 5);
    }

    @Test
    void drawSingleMonsters() {
        DefaultMonster defaultMonster = mock(DefaultMonster.class);
        JumperMonster jumperMonster = mock(JumperMonster.class);
        RunnerMonster runnerMonster = mock(RunnerMonster.class);
        WallBreakerMonster wallBreakerMonster = mock(WallBreakerMonster.class);

        MonsterViewer monsterViewer = mock(MonsterViewer.class);

        viewer.drawElement(graphics, defaultMonster, monsterViewer, 1);
        viewer.drawElement(graphics, jumperMonster, monsterViewer, 2);
        viewer.drawElement(graphics, runnerMonster, monsterViewer, 3);
        viewer.drawElement(graphics, wallBreakerMonster, monsterViewer, 4);

        verify(monsterViewer, times(1)).draw(defaultMonster, graphics, 1);
        verify(monsterViewer, times(1)).draw(jumperMonster, graphics, 2);
        verify(monsterViewer, times(1)).draw(runnerMonster, graphics, 3);
        verify(monsterViewer, times(1)).draw(wallBreakerMonster, graphics, 4);
    }

    @Test
    void drawSingleWalls(){
        StoneWall stoneWall = mock(StoneWall.class);
        IceWall iceWallDefault = mock(IceWall.class);
        IceWall iceWallApple = mock(IceWall.class);
        IceWall iceWallBanana = mock(IceWall.class);
        IceWall iceWallPepper = mock(IceWall.class);
        IceWall iceWallPineapple = mock(IceWall.class);
        IceWall iceWallStrawberry = mock(IceWall.class);
        IceWall iceWallJumperUp = mock(IceWall.class);
        IceWall iceWallJumperDown = mock(IceWall.class);
        IceWall iceWallJumperRight = mock(IceWall.class);
        IceWall iceWallJumperLeft = mock(IceWall.class);

        WallViewer wallViewer = mock(WallViewer.class);

        viewer.drawElement(graphics, stoneWall, wallViewer, 2);
        viewer.drawElement(graphics, iceWallDefault, wallViewer, 1);
        viewer.drawElement(graphics, iceWallApple, wallViewer, 3);
        viewer.drawElement(graphics, iceWallBanana, wallViewer, 5);
        viewer.drawElement(graphics, iceWallPepper, wallViewer, 4);
        viewer.drawElement(graphics, iceWallPineapple, wallViewer, 6);
        viewer.drawElement(graphics, iceWallStrawberry, wallViewer, 7);
        viewer.drawElement(graphics, iceWallJumperUp, wallViewer, 9);
        viewer.drawElement(graphics, iceWallJumperDown, wallViewer, 8);
        viewer.drawElement(graphics, iceWallJumperRight, wallViewer, 11);
        viewer.drawElement(graphics, iceWallJumperLeft, wallViewer, 10);

        verify(wallViewer, times(1)).draw(stoneWall, graphics, 2);
        verify(wallViewer, times(1)).draw(iceWallDefault, graphics, 1);
        verify(wallViewer, times(1)).draw(iceWallApple, graphics, 3);
        verify(wallViewer, times(1)).draw(iceWallBanana, graphics, 5);
        verify(wallViewer, times(1)).draw(iceWallPepper, graphics, 4);
        verify(wallViewer, times(1)).draw(iceWallPineapple, graphics, 6);
        verify(wallViewer, times(1)).draw(iceWallStrawberry, graphics, 7);
        verify(wallViewer, times(1)).draw(iceWallJumperUp, graphics, 9);
        verify(wallViewer, times(1)).draw(iceWallJumperDown, graphics, 8);
        verify(wallViewer, times(1)).draw(iceWallJumperRight, graphics, 11);
        verify(wallViewer, times(1)).draw(iceWallJumperLeft, graphics, 10);
    }

    @Test
    void drawSingleHotFloors(){
        HotFloor defaultHotFloor = mock(HotFloor.class);
        HotFloor defaultMonsterUpHotFloor = mock(HotFloor.class);
        HotFloor defaultMonsterRightHotFloor = mock(HotFloor.class);
        HotFloor defaultMonsterLeftHotFloor = mock(HotFloor.class);
        HotFloor defaultMonsterDownHotFloor = mock(HotFloor.class);
        HotFloor jumperMonsterUpHotFloor = mock(HotFloor.class);
        HotFloor jumperMonsterRightHotFloor = mock(HotFloor.class);
        HotFloor jumperMonsterLeftHotFloor = mock(HotFloor.class);
        HotFloor jumperMonsterDownHotFloor = mock(HotFloor.class);
        HotFloor runnerMonsterNormalUptHotFloor = mock(HotFloor.class);
        HotFloor runnerMonsterNormalRighttHotFloor = mock(HotFloor.class);
        HotFloor runnerMonsterNormalLefttHotFloor = mock(HotFloor.class);
        HotFloor runnerMonsterNormalDowntHotFloor = mock(HotFloor.class);
        HotFloor runnerMonsterRunningUptHotFloor = mock(HotFloor.class);
        HotFloor runnerMonsterRunningRighttHotFloor = mock(HotFloor.class);
        HotFloor runnerMonsterRunningLefttHotFloor = mock(HotFloor.class);
        HotFloor runnerMonsterRunningDowntHotFloor = mock(HotFloor.class);
        HotFloor wallBreakerMonsterUpHotFloor = mock(HotFloor.class);
        HotFloor wallBreakerMonsterRightHotFloor = mock(HotFloor.class);
        HotFloor wallBreakerMonsterDownHotFloor = mock(HotFloor.class);
        HotFloor wallBreakerMonsterLeftHotFloor = mock(HotFloor.class);
        HotFloor appletHotFloor = mock(HotFloor.class);
        HotFloor bananatHotFloor = mock(HotFloor.class);
        HotFloor cherryHotFloor = mock(HotFloor.class);
        HotFloor pineappleHotFloor = mock(HotFloor.class);
        HotFloor strawberryHotFloor = mock(HotFloor.class);
        HotFloor iceCreamUpHotFloor = mock(HotFloor.class);
        HotFloor iceCreamRightHotFloor = mock(HotFloor.class);
        HotFloor iceCreamLeftHotFloor = mock(HotFloor.class);
        HotFloor iceCreamDownHotFloor = mock(HotFloor.class);

        HotFloorViewer hotFloorViewer = mock(HotFloorViewer.class);

        viewer.drawElement(graphics, defaultHotFloor, hotFloorViewer, 0);
        viewer.drawElement(graphics, defaultMonsterUpHotFloor, hotFloorViewer, 1);
        viewer.drawElement(graphics, defaultMonsterRightHotFloor, hotFloorViewer, 2);
        viewer.drawElement(graphics, defaultMonsterLeftHotFloor, hotFloorViewer, 3);
        viewer.drawElement(graphics, defaultMonsterDownHotFloor, hotFloorViewer, 4);
        viewer.drawElement(graphics, jumperMonsterUpHotFloor, hotFloorViewer, 5);
        viewer.drawElement(graphics, jumperMonsterRightHotFloor, hotFloorViewer, 6);
        viewer.drawElement(graphics, jumperMonsterLeftHotFloor, hotFloorViewer, 7);
        viewer.drawElement(graphics, jumperMonsterDownHotFloor, hotFloorViewer, 8);
        viewer.drawElement(graphics, runnerMonsterNormalUptHotFloor, hotFloorViewer, 9);
        viewer.drawElement(graphics, runnerMonsterNormalRighttHotFloor, hotFloorViewer, 10);
        viewer.drawElement(graphics, runnerMonsterNormalLefttHotFloor, hotFloorViewer, 11);
        viewer.drawElement(graphics, runnerMonsterNormalDowntHotFloor, hotFloorViewer, 12);
        viewer.drawElement(graphics, runnerMonsterRunningUptHotFloor, hotFloorViewer, 13);
        viewer.drawElement(graphics, runnerMonsterRunningRighttHotFloor, hotFloorViewer, 14);
        viewer.drawElement(graphics, runnerMonsterRunningLefttHotFloor, hotFloorViewer, 15);
        viewer.drawElement(graphics, runnerMonsterRunningDowntHotFloor, hotFloorViewer, 16);
        viewer.drawElement(graphics, wallBreakerMonsterUpHotFloor, hotFloorViewer, 17);
        viewer.drawElement(graphics, wallBreakerMonsterRightHotFloor, hotFloorViewer, 18);
        viewer.drawElement(graphics, wallBreakerMonsterDownHotFloor, hotFloorViewer, 19);
        viewer.drawElement(graphics, wallBreakerMonsterLeftHotFloor, hotFloorViewer, 20);
        viewer.drawElement(graphics, appletHotFloor, hotFloorViewer, 21);
        viewer.drawElement(graphics, bananatHotFloor, hotFloorViewer, 22);
        viewer.drawElement(graphics, cherryHotFloor, hotFloorViewer, 23);
        viewer.drawElement(graphics, pineappleHotFloor, hotFloorViewer, 24);
        viewer.drawElement(graphics, strawberryHotFloor, hotFloorViewer, 25);
        viewer.drawElement(graphics, iceCreamUpHotFloor, hotFloorViewer, 26);
        viewer.drawElement(graphics, iceCreamRightHotFloor, hotFloorViewer, 27);
        viewer.drawElement(graphics, iceCreamLeftHotFloor, hotFloorViewer, 28);
        viewer.drawElement(graphics, iceCreamDownHotFloor, hotFloorViewer, 29);

        verify(hotFloorViewer, times(1)).draw(defaultHotFloor, graphics, 0);
        verify(hotFloorViewer, times(1)).draw(defaultMonsterUpHotFloor, graphics, 1);
        verify(hotFloorViewer, times(1)).draw(defaultMonsterRightHotFloor, graphics, 2);
        verify(hotFloorViewer, times(1)).draw(defaultMonsterLeftHotFloor, graphics, 3);
        verify(hotFloorViewer, times(1)).draw(defaultMonsterDownHotFloor, graphics, 4);
        verify(hotFloorViewer, times(1)).draw(jumperMonsterUpHotFloor, graphics, 5);
        verify(hotFloorViewer, times(1)).draw(jumperMonsterRightHotFloor, graphics, 6);
        verify(hotFloorViewer, times(1)).draw(jumperMonsterLeftHotFloor, graphics, 7);
        verify(hotFloorViewer, times(1)).draw(jumperMonsterDownHotFloor, graphics, 8);
        verify(hotFloorViewer, times(1)).draw(runnerMonsterNormalUptHotFloor, graphics, 9);
        verify(hotFloorViewer, times(1)).draw(runnerMonsterNormalRighttHotFloor, graphics, 10);
        verify(hotFloorViewer, times(1)).draw(runnerMonsterNormalLefttHotFloor, graphics, 11);
        verify(hotFloorViewer, times(1)).draw(runnerMonsterNormalDowntHotFloor, graphics, 12);
        verify(hotFloorViewer, times(1)).draw(runnerMonsterRunningUptHotFloor, graphics, 13);
        verify(hotFloorViewer, times(1)).draw(runnerMonsterRunningRighttHotFloor, graphics, 14);
        verify(hotFloorViewer, times(1)).draw(runnerMonsterRunningLefttHotFloor, graphics, 15);
        verify(hotFloorViewer, times(1)).draw(runnerMonsterRunningDowntHotFloor, graphics, 16);
        verify(hotFloorViewer, times(1)).draw(wallBreakerMonsterUpHotFloor, graphics, 17);
        verify(hotFloorViewer, times(1)).draw(wallBreakerMonsterRightHotFloor, graphics, 18);
        verify(hotFloorViewer, times(1)).draw(wallBreakerMonsterDownHotFloor, graphics, 19);
        verify(hotFloorViewer, times(1)).draw(wallBreakerMonsterLeftHotFloor, graphics, 20);
        verify(hotFloorViewer, times(1)).draw(appletHotFloor, graphics, 21);
        verify(hotFloorViewer, times(1)).draw(bananatHotFloor, graphics, 22);
        verify(hotFloorViewer, times(1)).draw(cherryHotFloor, graphics, 23);
        verify(hotFloorViewer, times(1)).draw(pineappleHotFloor, graphics, 24);
        verify(hotFloorViewer, times(1)).draw(strawberryHotFloor, graphics, 25);
        verify(hotFloorViewer, times(1)).draw(iceCreamUpHotFloor, graphics, 26);
        verify(hotFloorViewer, times(1)).draw(iceCreamRightHotFloor, graphics, 27);
        verify(hotFloorViewer, times(1)).draw(iceCreamLeftHotFloor, graphics, 28);
        verify(hotFloorViewer, times(1)).draw(iceCreamDownHotFloor, graphics, 29);
    }
}
