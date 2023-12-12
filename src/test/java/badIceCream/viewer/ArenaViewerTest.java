    package badIceCream.viewer;

    import badIceCream.GUI.GUI;
    import badIceCream.GUI.Graphics;
    import badIceCream.model.Position;
    import badIceCream.model.game.arena.Arena;
    import badIceCream.model.game.elements.*;
    import badIceCream.model.game.elements.fruits.*;
    import badIceCream.model.game.elements.monsters.*;
    import org.junit.jupiter.api.BeforeEach;
    import org.junit.jupiter.api.Test;
    import org.mockito.Mock;
    import org.mockito.MockitoAnnotations;

    import java.util.Arrays;
    import java.util.List;

    import static org.mockito.Mockito.*;


    public class ArenaViewerTest {
        @Mock
        private Arena arena;
        private ArenaViewer viewer;
        @Mock
        private Graphics graphics;

        @Mock
        private FruitViewer fruitViewer;
        @Mock
        private MonsterViewer monsterViewer;
        @Mock
        private WallViewer wallViewer;
        @Mock
        private HotFloorViewer hotFloorViewer;
        @Mock
        private IceCreamViewer iceCreamViewer;
        @BeforeEach
        void setUp() {
            MockitoAnnotations.openMocks(this);

            viewer = new ArenaViewer(arena, fruitViewer, monsterViewer, wallViewer, hotFloorViewer, iceCreamViewer);
        }

        @Test
        void drawElements() {
            AppleFruit apple = mock(AppleFruit.class);
            BananaFruit banana = mock(BananaFruit.class);
            CherryFruit cherry = mock(CherryFruit.class);
            PineappleFruit pineapple = mock(PineappleFruit.class);
            StrawberryFruit strawberry = mock(StrawberryFruit.class);

            when(apple.getType()).thenReturn(1);
            when(banana.getType()).thenReturn(2);
            when(cherry.getType()).thenReturn(3);
            when(pineapple.getType()).thenReturn(4);
            when(strawberry.getType()).thenReturn(5);

            List<Fruit> fruits = Arrays.asList(apple, banana, cherry, pineapple, strawberry);

            DefaultMonster defaultMonster = mock(DefaultMonster.class);
            JumperMonster jumperMonster = mock(JumperMonster.class);
            RunnerMonster runnerMonster = mock(RunnerMonster.class);
            WallBreakerMonster wallBreakerMonster = mock(WallBreakerMonster.class);

            when(defaultMonster.getType()).thenReturn(1);
            when(jumperMonster.getType()).thenReturn(2);
            when(runnerMonster.getType()).thenReturn(3);
            when(wallBreakerMonster.getType()).thenReturn(4);

            List<Monster> monsters = Arrays.asList(defaultMonster, jumperMonster, runnerMonster, wallBreakerMonster);

            StoneWall stoneWall = mock(StoneWall.class);
            IceWall iceWallDefault = mock(IceWall.class);
            IceWall iceWallApple = mock(IceWall.class);
            IceWall iceWallBanana = mock(IceWall.class);
            IceWall iceWallcherry = mock(IceWall.class);
            IceWall iceWallPineapple = mock(IceWall.class);
            IceWall iceWallStrawberry = mock(IceWall.class);
            IceWall iceWallJumperUp = mock(IceWall.class);
            IceWall iceWallJumperDown = mock(IceWall.class);
            IceWall iceWallJumperRight = mock(IceWall.class);
            IceWall iceWallJumperLeft = mock(IceWall.class);

            when(stoneWall.getType()).thenReturn(2);
            Position stonePosition = mock(Position.class);
            when(arena.hasMonster(stonePosition)).thenReturn(null);

            when(iceWallDefault.getType()).thenReturn(1);
            Position defaultPosition = mock(Position.class);
            when(iceWallDefault.getPosition()).thenReturn(defaultPosition);
            when(arena.isFruit(eq(defaultPosition))).thenReturn(0);
            when(arena.hasMonster(defaultPosition)).thenReturn(null);

            when(iceWallApple.getType()).thenReturn(1);
            Position applePosition = mock(Position.class);
            when(iceWallApple.getPosition()).thenReturn(applePosition);
            when(arena.isFruit(eq(applePosition))).thenReturn(1);
            when(arena.hasMonster(applePosition)).thenReturn(null);

            when(iceWallBanana.getType()).thenReturn(1);
            Position bananaPosition = mock(Position.class);
            when(iceWallBanana.getPosition()).thenReturn(bananaPosition);
            when(arena.isFruit(eq(bananaPosition))).thenReturn(2);
            when(arena.hasMonster(bananaPosition)).thenReturn(null);

            when(iceWallcherry.getType()).thenReturn(1);
            Position cherryPosition = mock(Position.class);
            when(iceWallcherry.getPosition()).thenReturn(cherryPosition);
            when(arena.isFruit(eq(cherryPosition))).thenReturn(3);
            when(arena.hasMonster(cherryPosition)).thenReturn(null);

            when(iceWallPineapple.getType()).thenReturn(1);
            Position pineapplePosition = mock(Position.class);
            when(iceWallPineapple.getPosition()).thenReturn(pineapplePosition);
            when(arena.isFruit(eq(pineapplePosition))).thenReturn(4);
            when(arena.hasMonster(pineapplePosition)).thenReturn(null);

            when(iceWallStrawberry.getType()).thenReturn(1);
            Position strawberryPosition = mock(Position.class);
            when(iceWallStrawberry.getPosition()).thenReturn(strawberryPosition);
            when(arena.isFruit(eq(strawberryPosition))).thenReturn(5);
            when(arena.hasMonster(strawberryPosition)).thenReturn(null);

            when(iceWallJumperUp.getType()).thenReturn(1);
            Position jumperUpPosition = mock(Position.class);
            JumperMonster jumper1 = mock(JumperMonster.class);
            when(arena.isFruit(jumperUpPosition)).thenReturn(-1);
            when(iceWallJumperUp.getPosition()).thenReturn(jumperUpPosition);
            when(arena.hasMonster(eq(jumperUpPosition))).thenReturn(jumper1);
            when(jumper1.getType()).thenReturn(2);
            when(jumper1.getLastAction()).thenReturn(GUI.ACTION.UP);

            when(iceWallJumperDown.getType()).thenReturn(1);
            Position jumperDownPosition = mock(Position.class);
            JumperMonster jumper2 = mock(JumperMonster.class);
            when(arena.isFruit(jumperDownPosition)).thenReturn(-1);
            when(iceWallJumperDown.getPosition()).thenReturn(jumperDownPosition);
            when(arena.hasMonster(eq(jumperDownPosition))).thenReturn(jumper2);
            when(jumper2.getType()).thenReturn(2);
            when(jumper2.getLastAction()).thenReturn(GUI.ACTION.DOWN);

            when(iceWallJumperRight.getType()).thenReturn(1);
            Position jumperRightPosition = mock(Position.class);
            JumperMonster jumper3 = mock(JumperMonster.class);
            when(arena.isFruit(jumperRightPosition)).thenReturn(-1);
            when(iceWallJumperRight.getPosition()).thenReturn(jumperRightPosition);
            when(arena.hasMonster(eq(jumperRightPosition))).thenReturn(jumper3);
            when(jumper3.getType()).thenReturn(2);
            when(jumper3.getLastAction()).thenReturn(GUI.ACTION.RIGHT);

            when(iceWallJumperLeft.getType()).thenReturn(1);
            Position jumperLeftPosition = mock(Position.class);
            JumperMonster jumper4 = mock(JumperMonster.class);
            when(arena.isFruit(jumperLeftPosition)).thenReturn(-1);
            when(iceWallJumperLeft.getPosition()).thenReturn(jumperLeftPosition);
            when(arena.hasMonster(eq(jumperLeftPosition))).thenReturn(jumper4);
            when(jumper4.getType()).thenReturn(2);
            when(jumper4.getLastAction()).thenReturn(GUI.ACTION.LEFT);

            List<Wall> walls = Arrays.asList(stoneWall, iceWallDefault, iceWallApple, iceWallBanana, iceWallcherry, iceWallPineapple, iceWallStrawberry, iceWallJumperUp, iceWallJumperDown, iceWallJumperRight, iceWallJumperLeft);

            IceCream iceCream = mock(IceCream.class);

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

            when(iceCream.getPosition()).thenReturn(new Position(1, 2));

            Position defaultHotFloorPosition = new Position(1,1);
            when(defaultHotFloor.getPosition()).thenReturn(defaultHotFloorPosition);
            when(arena.isFruit(defaultHotFloorPosition)).thenReturn(-1);
            when(arena.hasMonster(defaultHotFloorPosition)).thenReturn(null);

            Position defaultMonterUpHotFloorPosition = new Position(2,1);
            when(defaultMonsterUpHotFloor.getPosition()).thenReturn(defaultMonterUpHotFloorPosition);
            DefaultMonster defaultMonster1 = mock(DefaultMonster.class);
            when(arena.isFruit(defaultMonterUpHotFloorPosition)).thenReturn(-1);
            when(arena.hasMonster(defaultMonterUpHotFloorPosition)).thenReturn(defaultMonster1);
            when(defaultMonster1.getType()).thenReturn(1);
            when(defaultMonster1.getLastAction()).thenReturn(GUI.ACTION.UP);

            Position defaultMonterRightHotFloorPosition = new Position(2,2);
            when(defaultMonsterRightHotFloor.getPosition()).thenReturn(defaultMonterRightHotFloorPosition);
            DefaultMonster defaultMonster2 = mock(DefaultMonster.class);
            when(arena.isFruit(defaultMonterRightHotFloorPosition)).thenReturn(-1);
            when(arena.hasMonster(defaultMonterRightHotFloorPosition)).thenReturn(defaultMonster2);
            when(defaultMonster2.getType()).thenReturn(1);
            when(defaultMonster2.getLastAction()).thenReturn(GUI.ACTION.RIGHT);

            Position defaultMonterLeftHotFloorPosition = new Position(2,3);
            when(defaultMonsterLeftHotFloor.getPosition()).thenReturn(defaultMonterLeftHotFloorPosition);
            DefaultMonster defaultMonster3 = mock(DefaultMonster.class);
            when(arena.isFruit(defaultMonterLeftHotFloorPosition)).thenReturn(-1);
            when(arena.hasMonster(defaultMonterLeftHotFloorPosition)).thenReturn(defaultMonster3);
            when(defaultMonster3.getType()).thenReturn(1);
            when(defaultMonster3.getLastAction()).thenReturn(GUI.ACTION.LEFT);

            Position defaultMonterDownHotFloorPosition = new Position(2,4);
            when(defaultMonsterDownHotFloor.getPosition()).thenReturn(defaultMonterDownHotFloorPosition);
            DefaultMonster defaultMonster4 = mock(DefaultMonster.class);
            when(arena.isFruit(defaultMonterDownHotFloorPosition)).thenReturn(-1);
            when(arena.hasMonster(defaultMonterDownHotFloorPosition)).thenReturn(defaultMonster4);
            when(defaultMonster4.getType()).thenReturn(1);
            when(defaultMonster4.getLastAction()).thenReturn(GUI.ACTION.DOWN);

            Position jumperMonterUpHotFloorPosition = new Position(3,1);
            when(jumperMonsterUpHotFloor.getPosition()).thenReturn(jumperMonterUpHotFloorPosition);
            JumperMonster jumperMonster1 = mock(JumperMonster.class);
            when(arena.isFruit(jumperMonterUpHotFloorPosition)).thenReturn(-1);
            when(arena.hasMonster(jumperMonterUpHotFloorPosition)).thenReturn(jumperMonster1);
            when(jumperMonster1.getType()).thenReturn(2);
            when(jumperMonster1.getLastAction()).thenReturn(GUI.ACTION.UP);

            Position jumperMonterRightHotFloorPosition = new Position(3,2);
            when(jumperMonsterRightHotFloor.getPosition()).thenReturn(jumperMonterRightHotFloorPosition);
            JumperMonster jumperMonster2 = mock(JumperMonster.class);
            when(arena.isFruit(jumperMonterRightHotFloorPosition)).thenReturn(-1);
            when(arena.hasMonster(jumperMonterRightHotFloorPosition)).thenReturn(jumperMonster2);
            when(jumperMonster2.getType()).thenReturn(2);
            when(jumperMonster2.getLastAction()).thenReturn(GUI.ACTION.RIGHT);

            Position jumperMonterLeftHotFloorPosition = new Position(3,3);
            when(jumperMonsterLeftHotFloor.getPosition()).thenReturn(jumperMonterLeftHotFloorPosition);
            JumperMonster jumperMonster3 = mock(JumperMonster.class);
            when(arena.isFruit(jumperMonterLeftHotFloorPosition)).thenReturn(-1);
            when(arena.hasMonster(jumperMonterLeftHotFloorPosition)).thenReturn(jumperMonster3);
            when(jumperMonster3.getType()).thenReturn(2);
            when(jumperMonster3.getLastAction()).thenReturn(GUI.ACTION.LEFT);

            Position jumperMonterDownHotFloorPosition = new Position(3,4);
            when(jumperMonsterDownHotFloor.getPosition()).thenReturn(jumperMonterDownHotFloorPosition);
            JumperMonster jumperMonster4 = mock(JumperMonster.class);
            when(arena.isFruit(jumperMonterDownHotFloorPosition)).thenReturn(-1);
            when(arena.hasMonster(jumperMonterDownHotFloorPosition)).thenReturn(jumperMonster4);
            when(jumperMonster4.getType()).thenReturn(2);
            when(jumperMonster4.getLastAction()).thenReturn(GUI.ACTION.DOWN);

            Position runnerMonterNormalUpHotFloorPosition = new Position(4,1);
            when(runnerMonsterNormalUptHotFloor.getPosition()).thenReturn(runnerMonterNormalUpHotFloorPosition);
            RunnerMonster runnerMonster1 = mock(RunnerMonster.class);
            when(arena.isFruit(runnerMonterNormalUpHotFloorPosition)).thenReturn(-1);
            when(arena.hasMonster(runnerMonterNormalUpHotFloorPosition)).thenReturn(runnerMonster1);
            when(runnerMonster1.getType()).thenReturn(3);
            when(runnerMonster1.isRunning()).thenReturn(false);
            when(runnerMonster1.getLastAction()).thenReturn(GUI.ACTION.UP);

            Position runnerMonterNormalRightHotFloorPosition = new Position(4,2);
            when(runnerMonsterNormalRighttHotFloor.getPosition()).thenReturn(runnerMonterNormalRightHotFloorPosition);
            RunnerMonster runnerMonster2 = mock(RunnerMonster.class);
            when(arena.isFruit(runnerMonterNormalRightHotFloorPosition)).thenReturn(-1);
            when(arena.hasMonster(runnerMonterNormalRightHotFloorPosition)).thenReturn(runnerMonster2);
            when(runnerMonster2.getType()).thenReturn(3);
            when(runnerMonster2.isRunning()).thenReturn(false);
            when(runnerMonster2.getLastAction()).thenReturn(GUI.ACTION.RIGHT);

            Position runnerMonterNormalLeftHotFloorPosition = new Position(4,3);
            when(runnerMonsterNormalLefttHotFloor.getPosition()).thenReturn(runnerMonterNormalLeftHotFloorPosition);
            RunnerMonster runnerMonster3 = mock(RunnerMonster.class);
            when(arena.isFruit(runnerMonterNormalLeftHotFloorPosition)).thenReturn(-1);
            when(arena.hasMonster(runnerMonterNormalLeftHotFloorPosition)).thenReturn(runnerMonster3);
            when(runnerMonster3.getType()).thenReturn(3);
            when(runnerMonster3.isRunning()).thenReturn(false);
            when(runnerMonster3.getLastAction()).thenReturn(GUI.ACTION.LEFT);


            Position runnerMonterNormalDownHotFloorPosition = new Position(4,4);
            when(runnerMonsterNormalDowntHotFloor.getPosition()).thenReturn(runnerMonterNormalDownHotFloorPosition);
            RunnerMonster runnerMonster4 = mock(RunnerMonster.class);
            when(arena.isFruit(runnerMonterNormalDownHotFloorPosition)).thenReturn(-1);
            when(arena.hasMonster(runnerMonterNormalDownHotFloorPosition)).thenReturn(runnerMonster4);
            when(runnerMonster4.getType()).thenReturn(3);
            when(runnerMonster4.isRunning()).thenReturn(false);
            when(runnerMonster4.getLastAction()).thenReturn(GUI.ACTION.DOWN);

            Position runnerMonterRunningUpHotFloorPosition = new Position(4,5);
            when(runnerMonsterRunningUptHotFloor.getPosition()).thenReturn(runnerMonterRunningUpHotFloorPosition);
            RunnerMonster runnerMonster5 = mock(RunnerMonster.class);
            when(arena.isFruit(runnerMonterRunningUpHotFloorPosition)).thenReturn(-1);
            when(arena.hasMonster(runnerMonterRunningUpHotFloorPosition)).thenReturn(runnerMonster5);
            when(runnerMonster5.getType()).thenReturn(3);
            when(runnerMonster5.isRunning()).thenReturn(true);
            when(runnerMonster5.getLastAction()).thenReturn(GUI.ACTION.UP);

            Position runnerMonterRunningRightHotFloorPosition = new Position(4,6);
            when(runnerMonsterRunningRighttHotFloor.getPosition()).thenReturn(runnerMonterRunningRightHotFloorPosition);
            RunnerMonster runnerMonster6 = mock(RunnerMonster.class);
            when(arena.isFruit(runnerMonterRunningRightHotFloorPosition)).thenReturn(-1);
            when(arena.hasMonster(runnerMonterRunningRightHotFloorPosition)).thenReturn(runnerMonster6);
            when(runnerMonster6.getType()).thenReturn(3);
            when(runnerMonster6.isRunning()).thenReturn(true);
            when(runnerMonster6.getLastAction()).thenReturn(GUI.ACTION.RIGHT);

            Position runnerMonterRunningLeftHotFloorPosition = new Position(4,7);
            when(runnerMonsterRunningLefttHotFloor.getPosition()).thenReturn(runnerMonterRunningLeftHotFloorPosition);
            RunnerMonster runnerMonster7 = mock(RunnerMonster.class);
            when(arena.isFruit(runnerMonterRunningLeftHotFloorPosition)).thenReturn(-1);
            when(arena.hasMonster(runnerMonterRunningLeftHotFloorPosition)).thenReturn(runnerMonster7);
            when(runnerMonster7.getType()).thenReturn(3);
            when(runnerMonster7.isRunning()).thenReturn(true);
            when(runnerMonster7.getLastAction()).thenReturn(GUI.ACTION.LEFT);

            Position runnerMonterRunningDownHotFloorPosition = new Position(4,8);
            when(runnerMonsterRunningDowntHotFloor.getPosition()).thenReturn(runnerMonterRunningDownHotFloorPosition);
            RunnerMonster runnerMonster8 = mock(RunnerMonster.class);
            when(arena.isFruit(runnerMonterRunningDownHotFloorPosition)).thenReturn(-1);
            when(arena.hasMonster(runnerMonterRunningDownHotFloorPosition)).thenReturn(runnerMonster8);
            when(runnerMonster8.getType()).thenReturn(3);
            when(runnerMonster8.isRunning()).thenReturn(true);
            when(runnerMonster8.getLastAction()).thenReturn(GUI.ACTION.DOWN);

            Position wallBreakerMonterUpHotFloorPosition = new Position(5,1);
            when(wallBreakerMonsterUpHotFloor.getPosition()).thenReturn(wallBreakerMonterUpHotFloorPosition);
            WallBreakerMonster wallBreakerMonster1 = mock(WallBreakerMonster.class);
            when(arena.isFruit(wallBreakerMonterUpHotFloorPosition)).thenReturn(-1);
            when(arena.hasMonster(wallBreakerMonterUpHotFloorPosition)).thenReturn(wallBreakerMonster1);
            when(wallBreakerMonster1.getType()).thenReturn(4);
            when(wallBreakerMonster1.getLastAction()).thenReturn(GUI.ACTION.UP);

            Position wallBreakerMonterRightHotFloorPosition = new Position(5,2);
            when(wallBreakerMonsterRightHotFloor.getPosition()).thenReturn(wallBreakerMonterRightHotFloorPosition);
            WallBreakerMonster wallBreakerMonster2 = mock(WallBreakerMonster.class);
            when(arena.isFruit(wallBreakerMonterRightHotFloorPosition)).thenReturn(-1);
            when(arena.hasMonster(wallBreakerMonterRightHotFloorPosition)).thenReturn(wallBreakerMonster2);
            when(wallBreakerMonster2.getType()).thenReturn(4);
            when(wallBreakerMonster2.getLastAction()).thenReturn(GUI.ACTION.RIGHT);

            Position wallBreakerMonterLeftHotFloorPosition = new Position(5,3);
            when(wallBreakerMonsterLeftHotFloor.getPosition()).thenReturn(wallBreakerMonterLeftHotFloorPosition);
            WallBreakerMonster wallBreakerMonster3 = mock(WallBreakerMonster.class);
            when(arena.isFruit(wallBreakerMonterLeftHotFloorPosition)).thenReturn(-1);
            when(arena.hasMonster(wallBreakerMonterLeftHotFloorPosition)).thenReturn(wallBreakerMonster3);
            when(wallBreakerMonster3.getType()).thenReturn(4);
            when(wallBreakerMonster3.getLastAction()).thenReturn(GUI.ACTION.LEFT);

            Position wallBreakerMonterDownHotFloorPosition = new Position(5,4);
            when(wallBreakerMonsterDownHotFloor.getPosition()).thenReturn(wallBreakerMonterDownHotFloorPosition);
            WallBreakerMonster wallBreakerMonster4 = mock(WallBreakerMonster.class);
            when(arena.isFruit(wallBreakerMonterDownHotFloorPosition)).thenReturn(-1);
            when(arena.hasMonster(wallBreakerMonterDownHotFloorPosition)).thenReturn(wallBreakerMonster4);
            when(wallBreakerMonster4.getType()).thenReturn(4);
            when(wallBreakerMonster4.getLastAction()).thenReturn(GUI.ACTION.DOWN);

            Position appleHotFloorPosition = new Position(6,1);
            when(appletHotFloor.getPosition()).thenReturn(appleHotFloorPosition);
            when(arena.isFruit(appleHotFloorPosition)).thenReturn(1);
            when(arena.hasMonster(appleHotFloorPosition)).thenReturn(null);

            Position bananaHotFloorPosition = new Position(6,2);
            when(bananatHotFloor.getPosition()).thenReturn(bananaHotFloorPosition);
            when(arena.isFruit(bananaHotFloorPosition)).thenReturn(2);
            when(arena.hasMonster(appleHotFloorPosition)).thenReturn(null);

            Position cherryHotFloorPosition = new Position(6,3);
            when(cherryHotFloor.getPosition()).thenReturn(cherryHotFloorPosition);
            when(arena.isFruit(cherryHotFloorPosition)).thenReturn(3);
            when(arena.hasMonster(cherryHotFloorPosition)).thenReturn(null);

            Position pineappleHotFloorPosition = new Position(6,4);
            when(pineappleHotFloor.getPosition()).thenReturn(pineappleHotFloorPosition);
            when(arena.isFruit(pineappleHotFloorPosition)).thenReturn(4);
            when(arena.hasMonster(pineappleHotFloorPosition)).thenReturn(null);

            Position strawberryHotFloorPosition = new Position(6,5);
            when(strawberryHotFloor.getPosition()).thenReturn(strawberryHotFloorPosition);
            when(arena.isFruit(strawberryHotFloorPosition)).thenReturn(5);
            when(arena.hasMonster(strawberryHotFloorPosition)).thenReturn(null);

            Position iceCreamUpHotFloorPosition = new Position(1,2);
            when(iceCreamUpHotFloor.getPosition()).thenReturn(iceCreamUpHotFloorPosition);
            when(arena.isFruit(iceCreamUpHotFloorPosition)).thenReturn(-1);
            when(arena.hasMonster(iceCreamUpHotFloorPosition)).thenReturn(null);
            when(iceCream.getLastMovement()).thenReturn(GUI.ACTION.UP);

            /*Position iceCreamRightHotFloorPosition = new Position(1,2);
            when(iceCreamRightHotFloor.getPosition()).thenReturn(iceCreamRightHotFloorPosition);
            when(arena.isFruit(iceCreamRightHotFloorPosition)).thenReturn(-1);
            when(arena.hasMonster(iceCreamRightHotFloorPosition)).thenReturn(null);
            when(iceCream.getLastMovement()).thenReturn(GUI.ACTION.RIGHT);

            Position iceCreamLeftHotFloorPosition = new Position(1,2);
            when(iceCreamLeftHotFloor.getPosition()).thenReturn(iceCreamLeftHotFloorPosition);
            when(arena.isFruit(iceCreamLeftHotFloorPosition)).thenReturn(-1);
            when(arena.hasMonster(iceCreamLeftHotFloorPosition)).thenReturn(null);
            when(iceCream.getLastMovement()).thenReturn(GUI.ACTION.LEFT);

            Position iceCreamDwonHotFloorPosition = new Position(1,2);
            when(iceCreamDownHotFloor.getPosition()).thenReturn(iceCreamDwonHotFloorPosition);
            when(arena.isFruit(iceCreamDwonHotFloorPosition)).thenReturn(-1);
            when(arena.hasMonster(iceCreamDwonHotFloorPosition)).thenReturn(null);
            when(iceCream.getLastMovement()).thenReturn(GUI.ACTION.DOWN);*/

            List<HotFloor> hotFloors = Arrays.asList(defaultHotFloor, defaultMonsterUpHotFloor, defaultMonsterRightHotFloor, defaultMonsterLeftHotFloor, defaultMonsterDownHotFloor, jumperMonsterUpHotFloor, jumperMonsterRightHotFloor, jumperMonsterLeftHotFloor, jumperMonsterDownHotFloor, runnerMonsterNormalUptHotFloor, runnerMonsterNormalRighttHotFloor, runnerMonsterNormalLefttHotFloor, runnerMonsterNormalDowntHotFloor, runnerMonsterRunningUptHotFloor, runnerMonsterRunningRighttHotFloor, runnerMonsterRunningLefttHotFloor, runnerMonsterRunningDowntHotFloor, wallBreakerMonsterUpHotFloor, wallBreakerMonsterRightHotFloor, wallBreakerMonsterDownHotFloor, wallBreakerMonsterLeftHotFloor, appletHotFloor, bananatHotFloor, cherryHotFloor, pineappleHotFloor, strawberryHotFloor, iceCreamUpHotFloor/*, iceCreamRightHotFloor, iceCreamLeftHotFloor, iceCreamDownHotFloor*/);

            when(arena.getFruits()).thenReturn(fruits);
            when(arena.getMonsters()).thenReturn(monsters);
            when(arena.getWalls()).thenReturn(walls);
            when(arena.getIceCream()).thenReturn(iceCream);
            when(arena.getHotFloors()).thenReturn(hotFloors);

            viewer.drawElements(graphics);

            verify(fruitViewer, times(1)).draw(apple, graphics, 1);
            verify(fruitViewer, times(1)).draw(banana, graphics, 2);
            verify(fruitViewer, times(1)).draw(cherry, graphics, 3);
            verify(fruitViewer, times(1)).draw(pineapple, graphics, 4);
            verify(fruitViewer, times(1)).draw(strawberry, graphics, 5);

            verify(monsterViewer, times(1)).draw(defaultMonster, graphics, 1);
            verify(monsterViewer, times(1)).draw(jumperMonster, graphics, 2);
            verify(monsterViewer, times(1)).draw(runnerMonster, graphics, 3);
            verify(monsterViewer, times(1)).draw(wallBreakerMonster, graphics, 4);

            verify(wallViewer, times(1)).draw(stoneWall, graphics, 2);
            verify(wallViewer, times(1)).draw(iceWallDefault, graphics, 1);
            verify(wallViewer, times(1)).draw(iceWallApple, graphics, 3);
            verify(wallViewer, times(1)).draw(iceWallBanana, graphics, 4);
            verify(wallViewer, times(1)).draw(iceWallcherry, graphics, 5);
            verify(wallViewer, times(1)).draw(iceWallPineapple, graphics, 6);
            verify(wallViewer, times(1)).draw(iceWallStrawberry, graphics, 7);
            verify(wallViewer, times(1)).draw(iceWallJumperUp, graphics, 9);
            verify(wallViewer, times(1)).draw(iceWallJumperDown, graphics, 8);
            verify(wallViewer, times(1)).draw(iceWallJumperRight, graphics, 10);
            verify(wallViewer, times(1)).draw(iceWallJumperLeft, graphics, 11);

            verify(iceCreamViewer, times(1)).draw(iceCream, graphics, 1);

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
            verify(hotFloorViewer, times(1)).draw(wallBreakerMonsterDownHotFloor, graphics, 20);
            verify(hotFloorViewer, times(1)).draw(wallBreakerMonsterLeftHotFloor, graphics, 19);
            verify(hotFloorViewer, times(1)).draw(appletHotFloor, graphics, 21);
            verify(hotFloorViewer, times(1)).draw(bananatHotFloor, graphics, 22);
            verify(hotFloorViewer, times(1)).draw(cherryHotFloor, graphics, 23);
            verify(hotFloorViewer, times(1)).draw(pineappleHotFloor, graphics, 24);
            verify(hotFloorViewer, times(1)).draw(strawberryHotFloor, graphics, 25);
            verify(hotFloorViewer, times(1)).draw(iceCreamUpHotFloor, graphics, 26);
            //verify(hotFloorViewer, times(1)).draw(iceCreamRightHotFloor, graphics, 27);
            //verify(hotFloorViewer, times(1)).draw(iceCreamLeftHotFloor, graphics, 28);
            //verify(hotFloorViewer, times(1)).draw(iceCreamDownHotFloor, graphics, 29);
        }
    }