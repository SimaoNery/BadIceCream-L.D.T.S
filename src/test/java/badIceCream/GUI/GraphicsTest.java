package badIceCream.GUI;

import badIceCream.model.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class GraphicsTest {
    @Mock
    private GUI gui;
    @Mock
    private Position position;
    private Graphics graphics;

    @BeforeEach
    public void setUp() throws IOException {
        MockitoAnnotations.openMocks(this);
        when(position.getX()).thenReturn(1);
        when(position.getY()).thenReturn(1);
        graphics = new Graphics(gui);
    }
    @Test
    public void getNextAction() throws IOException {
        when(gui.getNextAction()).thenReturn(GUI.ACTION.UP);
        assertNotNull(graphics.getNextAction());
        when(gui.getNextAction()).thenReturn(GUI.ACTION.DOWN);
        assertNotNull(graphics.getNextAction());
        when(gui.getNextAction()).thenReturn(GUI.ACTION.LEFT);
        assertNotNull(graphics.getNextAction());
        when(gui.getNextAction()).thenReturn(GUI.ACTION.RIGHT);
        assertNotNull(graphics.getNextAction());
        when(gui.getNextAction()).thenReturn(GUI.ACTION.NONE);
        assertNotNull(graphics.getNextAction());
        when(gui.getNextAction()).thenReturn(GUI.ACTION.PAUSE);
        assertNotNull(graphics.getNextAction());
        when(gui.getNextAction()).thenReturn(GUI.ACTION.SPACE);
        assertNotNull(graphics.getNextAction());
        when(gui.getNextAction()).thenReturn(GUI.ACTION.SELECT);
        assertNotNull(graphics.getNextAction());

        verify(gui,times(8)).getNextAction();
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
    public void drawIceCream(){
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
    public void drawStoneWall(){
        graphics.drawStoneWall(position);
        verify(gui,times(1)).drawCharacter(position.getX(), position.getY(), 'G', "#696969");
    }
    @Test
    public void drawIceWall(){
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
    public void drawDefaultMonster() {
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
    public void drawJumperMonster() {
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
    public void drawRunnerMonster() {
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
    public void drawWallBreakerMonster() {
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
    public void drawAppleFruit() {
        graphics.drawAppleFruit(position);
        verify(gui,times(1)).drawCharacter(position.getX(), position.getY(), ']', "#FF0000");
    }
    @Test
    public void drawBananaFruit() {
        graphics.drawBananaFruit(position);
        verify(gui,times(1)).drawCharacter(position.getX(), position.getY(), 'a', "#FFFF00");
    }
    @Test
    public void drawPineappleFruit() {
        graphics.drawPineappleFruit(position);
        verify(gui,times(1)).drawCharacter(position.getX(), position.getY(), '^', "#FFFF66");
    }
    @Test
    public void drawPepperFruit() {
        graphics.drawPepperFruit(position);
        verify(gui,times(1)).drawCharacter(position.getX(), position.getY(), '\\', "#FF0000");
    }
    @Test
    public void drawStrawberryFruit() {
        graphics.drawStrawberryFruit(position);
        verify(gui,times(1)).drawCharacter(position.getX(), position.getY(), '_', "#FF0000");
    }
    @Test
    public void drawHotFloor() {
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
    public void drawText() {
        String text = "string";
        String color = "color";
        graphics.drawText(position, text, color);
        verify(gui,times(1)).drawText(position,text,color);
    }
    @Test
    public void drawCharacters() {
        graphics.drawCharacters();
        verify(gui, times(1)).drawCharacter(33, 15, 'Ê', "#00FF00");
        verify(gui, times(1)).drawCharacter(33, 18, 'À', "#00FF00");
        verify(gui, times(1)).drawCharacter(33, 21, 'Á', "#00FF00");
        verify(gui, times(1)).drawCharacter(33, 24, 'È', "#00FF00");
        verify(gui, times(1)).drawCharacter(33, 27, 'É', "#00FF00");
        verify(gui, times(1)).drawCharacter(33, 30, 'Í', "#00FF00");
    }
}
