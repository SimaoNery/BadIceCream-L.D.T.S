package badIceCream.GUI;

import badIceCream.model.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.mockito.Mockito.*;

public class GraphicsTest {
    @Mock
    private GUI gui;
    private Graphics graphics;

    @BeforeEach
    void setUp() throws IOException {
        MockitoAnnotations.openMocks(this);
        graphics = new Graphics(gui);
    }

    @Test
    public void getNextAction() throws IOException {
        GUI.ACTION action = graphics.getNextAction();
        verify(gui,times(1)).getNextAction();
    }
    @Test
    public void clear() {
        graphics.clear();
        verify(gui,times(1)).clear();
    }
    @Test
    public void refresh() throws IOException {
        graphics.refresh();
        verify(gui,times(1)).refresh();
    }
    @Test
    public void close() throws IOException {
        graphics.close();
        verify(gui,times(1)).close();
    }
    @Test
    void drawIceCream(){
        Position position = mock(Position.class);
        when(position.getX()).thenReturn(1);
        when(position.getY()).thenReturn(1);
        graphics.drawIceCream(position, GUI.ACTION.UP, true);
        verify(gui,times(1)).drawCharacter(position.getX(), position.getY(), '7', "#48DEFF");
        graphics.drawIceCream(position, GUI.ACTION.UP, false);
        verify(gui,times(1)).drawCharacter(position.getX(), position.getY(), '7', "#FFFFFF");
        graphics.drawIceCream(position, GUI.ACTION.DOWN, true);
        verify(gui,times(1)).drawCharacter(position.getX(), position.getY(), '8', "#48DEFF");
        graphics.drawIceCream(position, GUI.ACTION.DOWN, false);
        verify(gui,times(1)).drawCharacter(position.getX(), position.getY(), '8', "#FFFFFF");
        graphics.drawIceCream(position, GUI.ACTION.LEFT, true);
        verify(gui,times(1)).drawCharacter(position.getX(), position.getY(), ':', "#48DEFF");
        graphics.drawIceCream(position, GUI.ACTION.LEFT, false);
        verify(gui,times(1)).drawCharacter(position.getX(), position.getY(), ':', "#FFFFFF");
        graphics.drawIceCream(position, GUI.ACTION.RIGHT, true);
        verify(gui,times(1)).drawCharacter(position.getX(), position.getY(), '9', "#48DEFF");
        graphics.drawIceCream(position, GUI.ACTION.RIGHT, false);
        verify(gui,times(1)).drawCharacter(position.getX(), position.getY(), '9', "#FFFFFF");
    }
    @Test
    void drawStoneWall(){
        Position position = mock(Position.class);
        when(position.getX()).thenReturn(1);
        when(position.getY()).thenReturn(1);
        graphics.drawStoneWall(position);
        verify(gui,times(1)).drawCharacter(position.getX(), position.getY(), 'G', "#696969");
    }
    @Test
    void drawIceWall(){
        Position position = mock(Position.class);
        when(position.getX()).thenReturn(1);
        when(position.getY()).thenReturn(1);
        graphics.drawIceWall(position,1);
        verify(gui,times(1)).drawCharacter(position.getX(), position.getY(), 'F', "#87CEFA");
        graphics.drawIceWall(position,3);
        verify(gui,times(1)).drawCharacter(position.getX(), position.getY(), 'f', "#87CEFA");
        graphics.drawIceWall(position,4);
        verify(gui,times(1)).drawCharacter(position.getX(), position.getY(), 'h', "#87CEFA");
        graphics.drawIceWall(position,5);
        verify(gui,times(1)).drawCharacter(position.getX(), position.getY(), 'g', "#87CEFA");
        graphics.drawIceWall(position,6);
        verify(gui,times(1)).drawCharacter(position.getX(), position.getY(), 'i', "#87CEFA");
        graphics.drawIceWall(position,7);
        verify(gui,times(1)).drawCharacter(position.getX(), position.getY(), 'e', "#87CEFA");
        graphics.drawIceWall(position,8);
        verify(gui,times(1)).drawCharacter(position.getX(), position.getY(), 'k', "#87CEFA");
        graphics.drawIceWall(position,9);
        verify(gui,times(1)).drawCharacter(position.getX(), position.getY(), 'l', "#87CEFA");
        graphics.drawIceWall(position,10);
        verify(gui,times(1)).drawCharacter(position.getX(), position.getY(), 'm', "#87CEFA");
        graphics.drawIceWall(position,11);
        verify(gui,times(1)).drawCharacter(position.getX(), position.getY(), 'n', "#87CEFA");
    }
    @Test
    void drawDefaultMonster() {
        Position position = mock(Position.class);
        when(position.getX()).thenReturn(1);
        when(position.getY()).thenReturn(1);
        graphics.drawDefaultMonster(position, GUI.ACTION.UP);
        verify(gui,times(1)).drawCharacter(position.getX(), position.getY(), '4', "#00FF00");
        graphics.drawDefaultMonster(position, GUI.ACTION.LEFT);
        verify(gui,times(1)).drawCharacter(position.getX(), position.getY(), '~', "#00FF00");
        graphics.drawDefaultMonster(position, GUI.ACTION.RIGHT);
        verify(gui,times(1)).drawCharacter(position.getX(), position.getY(), 'È', "#00FF00");
        graphics.drawDefaultMonster(position, GUI.ACTION.DOWN);
        verify(gui,times(1)).drawCharacter(position.getX(), position.getY(), 'Y', "#00FF00");
    }
    @Test
    void drawJumperMonster() {
        Position position = mock(Position.class);
        when(position.getX()).thenReturn(1);
        when(position.getY()).thenReturn(1);
        graphics.drawJumperMonster(position, GUI.ACTION.UP);
        verify(gui,times(1)).drawCharacter(position.getX(), position.getY(), '/', "#FF3333");
        graphics.drawJumperMonster(position, GUI.ACTION.LEFT);
        verify(gui,times(1)).drawCharacter(position.getX(), position.getY(), 'y', "#FF3333");
        graphics.drawJumperMonster(position, GUI.ACTION.RIGHT);
        verify(gui,times(1)).drawCharacter(position.getX(), position.getY(), 'è', "#FF3333");
        graphics.drawJumperMonster(position, GUI.ACTION.DOWN);
        verify(gui,times(1)).drawCharacter(position.getX(), position.getY(), 'T', "#FF3333");
    }
    @Test
    void drawRunnerMonster() {
        Position position = mock(Position.class);
        when(position.getX()).thenReturn(1);
        when(position.getY()).thenReturn(1);
        graphics.drawRunnerMonster(position, GUI.ACTION.UP, true);
        verify(gui,times(1)).drawCharacter(position.getX(), position.getY(), '3', "#FF0000");
        graphics.drawRunnerMonster(position, GUI.ACTION.UP, false);
        verify(gui,times(1)).drawCharacter(position.getX(), position.getY(), '1', "#FFFF66");
        graphics.drawRunnerMonster(position, GUI.ACTION.LEFT, true);
        verify(gui,times(1)).drawCharacter(position.getX(), position.getY(), 'X', "#FF0000");
        graphics.drawRunnerMonster(position, GUI.ACTION.LEFT, false);
        verify(gui,times(1)).drawCharacter(position.getX(), position.getY(), 'W', "#FFFF66");
        graphics.drawRunnerMonster(position, GUI.ACTION.RIGHT, true);
        verify(gui,times(1)).drawCharacter(position.getX(), position.getY(), '}', "#FF0000");
        graphics.drawRunnerMonster(position, GUI.ACTION.RIGHT, false);
        verify(gui,times(1)).drawCharacter(position.getX(), position.getY(), '2', "#FFFF66");
        graphics.drawRunnerMonster(position, GUI.ACTION.DOWN, true);
        verify(gui,times(1)).drawCharacter(position.getX(), position.getY(), '|', "#FF0000");
        graphics.drawRunnerMonster(position, GUI.ACTION.DOWN, false);
        verify(gui,times(1)).drawCharacter(position.getX(), position.getY(), 'V', "#FFFF66");
    }
    @Test
    void drawWallBreakerMonster() {
        Position position = mock(Position.class);
        when(position.getX()).thenReturn(1);
        when(position.getY()).thenReturn(1);
        graphics.drawWallBreakerMonster(position, GUI.ACTION.UP);
        verify(gui,times(1)).drawCharacter(position.getX(), position.getY(), '0', "#FF99FF");
        graphics.drawWallBreakerMonster(position, GUI.ACTION.LEFT);
        verify(gui,times(1)).drawCharacter(position.getX(), position.getY(), 'é', "#FF99FF");
        graphics.drawWallBreakerMonster(position, GUI.ACTION.RIGHT);
        verify(gui,times(1)).drawCharacter(position.getX(), position.getY(), 'z', "#FF99FF");
        graphics.drawWallBreakerMonster(position, GUI.ACTION.DOWN);
        verify(gui,times(1)).drawCharacter(position.getX(), position.getY(), 'U', "#FF99FF");
    }
    @Test
    void drawAppleFruit() {
        Position position = mock(Position.class);
        when(position.getX()).thenReturn(1);
        when(position.getY()).thenReturn(1);
        graphics.drawAppleFruit(position);
        verify(gui,times(1)).drawCharacter(position.getX(), position.getY(), ']', "#FF0000");
    }
    @Test
    void drawBananaFruit() {
        Position position = mock(Position.class);
        when(position.getX()).thenReturn(1);
        when(position.getY()).thenReturn(1);
        graphics.drawBananaFruit(position);
        verify(gui,times(1)).drawCharacter(position.getX(), position.getY(), 'a', "#FFFF00");
    }
    @Test
    void drawPineappleFruit() {
        Position position = mock(Position.class);
        when(position.getX()).thenReturn(1);
        when(position.getY()).thenReturn(1);
        graphics.drawPineappleFruit(position);
        verify(gui,times(1)).drawCharacter(position.getX(), position.getY(), '^', "#FFFF66");
    }
    @Test
    void drawPepperFruit() {
        Position position = mock(Position.class);
        when(position.getX()).thenReturn(1);
        when(position.getY()).thenReturn(1);
        graphics.drawPepperFruit(position);
        verify(gui,times(1)).drawCharacter(position.getX(), position.getY(), '\\', "#FF0000");
    }
    @Test
    void drawStrawberryFruit() {
        Position position = mock(Position.class);
        when(position.getX()).thenReturn(1);
        when(position.getY()).thenReturn(1);
        graphics.drawStrawberryFruit(position);
        verify(gui,times(1)).drawCharacter(position.getX(), position.getY(), '_', "#FF0000");
    }
    @Test
    void drawHotFloor() {
        Position position = mock(Position.class);
        when(position.getX()).thenReturn(1);
        when(position.getY()).thenReturn(1);
        graphics.drawHotFloor(position,1);
        verify(gui,times(1)).drawCharacter(position.getX(), position.getY(), 'w', "#FF0000");
        graphics.drawHotFloor(position,2);
        verify(gui,times(1)).drawCharacter(position.getX(), position.getY(), 'd', "#FF0000");
        graphics.drawHotFloor(position,3);
        verify(gui,times(1)).drawCharacter(position.getX(), position.getY(), 'c', "#FF0000");
        graphics.drawHotFloor(position,4);
        verify(gui,times(1)).drawCharacter(position.getX(), position.getY(), 'x', "#FF0000");
        graphics.drawHotFloor(position,5);
        verify(gui,times(1)).drawCharacter(position.getX(), position.getY(), '%', "#FF0000");
        graphics.drawHotFloor(position,6);
        verify(gui,times(1)).drawCharacter(position.getX(), position.getY(), '(', "#FF0000");
        graphics.drawHotFloor(position,7);
        verify(gui,times(1)).drawCharacter(position.getX(), position.getY(), '\'', "#FF0000");
        graphics.drawHotFloor(position,8);
        verify(gui,times(1)).drawCharacter(position.getX(), position.getY(), '&', "#FF0000");
        graphics.drawHotFloor(position,9);
        verify(gui,times(1)).drawCharacter(position.getX(), position.getY(), ')', "#FF0000");
        graphics.drawHotFloor(position,10);
        verify(gui,times(1)).drawCharacter(position.getX(), position.getY(), '+', "#FF0000");
        graphics.drawHotFloor(position,11);
        verify(gui,times(1)).drawCharacter(position.getX(), position.getY(), ',', "#FF0000");
        graphics.drawHotFloor(position,12);
        verify(gui,times(1)).drawCharacter(position.getX(), position.getY(), '*', "#FF0000");
        graphics.drawHotFloor(position,13);
        verify(gui,times(1)).drawCharacter(position.getX(), position.getY(), '-', "#FF0000");
        graphics.drawHotFloor(position,14);
        verify(gui,times(1)).drawCharacter(position.getX(), position.getY(), '.', "#FF0000");
        graphics.drawHotFloor(position,15);
        verify(gui,times(1)).drawCharacter(position.getX(), position.getY(), 'S', "#FF0000");
        graphics.drawHotFloor(position,16);
        verify(gui,times(1)).drawCharacter(position.getX(), position.getY(), 'R', "#FF0000");
        graphics.drawHotFloor(position,17);
        verify(gui,times(1)).drawCharacter(position.getX(), position.getY(), '!', "#FF0000");
        graphics.drawHotFloor(position,18);
        verify(gui,times(1)).drawCharacter(position.getX(), position.getY(), '#', "#FF0000");
        graphics.drawHotFloor(position,19);
        verify(gui,times(1)).drawCharacter(position.getX(), position.getY(), '"', "#FF0000");
        graphics.drawHotFloor(position,20);
        verify(gui,times(1)).drawCharacter(position.getX(), position.getY(), '$', "#FF0000");
        graphics.drawHotFloor(position,21);
        verify(gui,times(1)).drawCharacter(position.getX(), position.getY(), 'C', "#FF0000");
        graphics.drawHotFloor(position,22);
        verify(gui,times(1)).drawCharacter(position.getX(), position.getY(), '@', "#FF0000");
        graphics.drawHotFloor(position,23);
        verify(gui,times(1)).drawCharacter(position.getX(), position.getY(), 'D', "#FF0000");
        graphics.drawHotFloor(position,24);
        verify(gui,times(1)).drawCharacter(position.getX(), position.getY(), 'B', "#FF0000");
        graphics.drawHotFloor(position,25);
        verify(gui,times(1)).drawCharacter(position.getX(), position.getY(), 'A', "#FF0000");
        graphics.drawHotFloor(position,26);
        verify(gui,times(1)).drawCharacter(position.getX(), position.getY(), ';', "#FF0000");
        graphics.drawHotFloor(position,27);
        verify(gui,times(1)).drawCharacter(position.getX(), position.getY(), '=', "#FF0000");
        graphics.drawHotFloor(position,28);
        verify(gui,times(1)).drawCharacter(position.getX(), position.getY(), '>', "#FF0000");
        graphics.drawHotFloor(position,29);
        verify(gui,times(1)).drawCharacter(position.getX(), position.getY(), '<', "#FF0000");
        graphics.drawHotFloor(position,30);
        verify(gui,times(1)).drawCharacter(position.getX(), position.getY(), 'b', "#FF0000");
    }
    @Test
    void drawText() {
        Position position = mock(Position.class);
        String text = "string";
        String color = "color";
        graphics.drawText(position, text, color);
        verify(gui,times(1)).drawText(position,text,color);
    }

/*
    @Test
    public void testClone() {
        Graphics cloned = graphics.clone();
        assertNotSame(graphics, cloned);
        assertEquals(graphics, cloned);
    }
 */
}
