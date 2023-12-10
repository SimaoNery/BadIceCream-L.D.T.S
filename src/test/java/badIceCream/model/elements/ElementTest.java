package badIceCream.model.elements;

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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;

public class ElementTest {
    @Test
    public void hotFloorGetType() {
        HotFloor hotFloor = new HotFloor(anyInt(),anyInt());
        assertEquals(0,hotFloor.getType());
    }
    @Test
    public void iceCreamGetType() {
        IceCream iceCream = new IceCream(anyInt(),anyInt());
        assertEquals(1,iceCream.getType());
    }
    @Test
    public void stoneWallGetType() {
        StoneWall stoneWall = new StoneWall(anyInt(),anyInt());
        assertEquals(2, stoneWall.getType());
    }
    @Test
    public void iceWallGetType() {
        IceWall iceWall = new IceWall(anyInt(),anyInt());
        assertEquals(1, iceWall.getType());
    }
    @Test
    public void wallBreakerGetType() {
        WallBreakerMonster wallBreakerMonster = new WallBreakerMonster( anyInt(),anyInt());
        assertEquals(4, wallBreakerMonster.getType());
    }
    @Test
    public void runnerMonsterGetType() {
        RunnerMonster runnerMonster = new RunnerMonster(anyInt(),anyInt());
        assertEquals(3, runnerMonster.getType());
    }
    @Test
    public void jumperMonsterGetType() {
        JumperMonster jumperMonster = new JumperMonster(anyInt(),anyInt());
        assertEquals(2, jumperMonster.getType());
    }
    @Test
    public void DefaultMonsterGetType() {
        DefaultMonster defaultMonster = new DefaultMonster(anyInt(),anyInt());
        assertEquals(1, defaultMonster.getType());
    }
    @Test
    public void StrawBerryFruitGetType() {
        StrawberryFruit strawberryFruit = new StrawberryFruit(anyInt(),anyInt());
        assertEquals(5, strawberryFruit.getType());
    }
    @Test
    public void PineappleFruitGetType() {
        PineappleFruit pineappleFruit = new PineappleFruit(anyInt(),anyInt());
        assertEquals(4, pineappleFruit.getType());
    }
    @Test
    public void CherryFruitGetType() {
        CherryFruit cherryFruit = new CherryFruit(anyInt(),anyInt());
        assertEquals(3, cherryFruit.getType());
    }
    @Test
    public void BananaFruitGetType() {
        BananaFruit bananaFruit = new BananaFruit(anyInt(),anyInt());
        assertEquals(2, bananaFruit.getType());
    }
    @Test
    public void AppleFruitGetType() {
        AppleFruit appleFruit = new AppleFruit(anyInt(),anyInt());
        assertEquals(1, appleFruit.getType());
    }
}
